package com.xiedang.www.utils.excel;

import com.xiedang.www.utils.date.DateUtil;
import com.xiedang.www.utils.excel.model.SheetData;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Excel导出工具类
 */
public class ExportUtil {

    /**
     * 时间格式化方式
     */
    private static String dateFormat = "yyyy-MM-dd HH:mm";
    /**
     * BigDecimal 默认小数位数
     */
    private static int scale = 3;

    /**
     * 占位符的开头字符串
     */
    public static String PLACEHOLDER_CHAR="#";
    /**
     * 标识填充数据的地方
     */
    public static String SIGN_STR="start_data";

    private static final String POSITIVE_INTEGER = "^\\d+$";

    private static final String NUMBER = "^-?\\d+\\.?\\d+$";

    private static final String FIRST_COLUMN = "序号";

    /**
     * 判断是否为数字
     *
     * @param v
     * @return
     */
    public static boolean isNumber(Object v) {
        return v != null && (v instanceof Number || v.toString().matches(POSITIVE_INTEGER) || v.toString().matches(NUMBER));
    }

    /**
     * 返回 #{} 中包含的值
     *
     * @param str
     * @return eg:#{name}
     */
    public static String[] getWildcard(String str) {
        List<String> list = new ArrayList<>();
        int start = 0;
        while (start < str.length() && start >= 0) {
            start = str.indexOf("{", start);
            int end = str.indexOf("}", start);
            if (start > 0) {
                String wc = str.substring(start - 1, end + 1);
                list.add(wc);
            }
            if (start < 0) {
                break;
            }
            start = end + 1;
        }
        return list.toArray(new String[0]);
    }


    /**
     * 遍历sheet数据并替换模板占位符
     *
     * @param sheetData 数据Map
     * @param sheet     sheet
     */
    public static void writeData(SheetData sheetData, Sheet sheet) {
        //从sheet中找到匹配符 #{}表示单个
        for (Iterator<Row> rowIt = sheet.rowIterator(); rowIt.hasNext(); ) {
            Row row = rowIt.next();
            //取cell
            for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                //判断cell的内容是否包含 $ 或者#
                if (cell.getStringCellValue() != null && cell.getStringCellValue().contains("#")) {
                    //剥离# $
                    String[] winds = getWildcard(cell.getStringCellValue().trim());
                    for (String wind : winds) {
                        replaceData(sheetData, wind, cell);
                    }
                }
            }
        }
    }

    /**
     * 替换占位符
     *
     * @param sheetData
     * @param keyWind   #{name}只替换当前
     */
    private static void replaceData(SheetData sheetData, String keyWind, Cell cell) {
        String key = keyWind.substring(2, keyWind.length() - 1);
        if (keyWind.startsWith(PLACEHOLDER_CHAR)) {
            //简单替换
            Object value = sheetData.get(key);
            //为空则替换为空字符串
            if (value == null) {
                value = "";
            }
            String cellValue = cell.getStringCellValue();
            cellValue = cellValue.replace(keyWind, value.toString());
            cell.setCellValue(cellValue);
        }
    }

    private static int getInsertRowIndex(Sheet sheet) {
        int insertRowIndex = 0;
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 0; i <= lastRowNum; i++) {
            Row row = sheet.getRow(i);
            for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                if (SIGN_STR.equalsIgnoreCase(cell.getStringCellValue())) {
                    insertRowIndex = cell.getRowIndex();
                    cell.setCellValue("");
                }
            }
        }
        return insertRowIndex;
    }

    /**
     * 带模板的excel导出
     * @param templateFile
     * @param response
     * @param sheetData
     * @throws IOException
     */
    public static void exportWithTemplate(File templateFile, HttpServletResponse response, SheetData sheetData) throws IOException{
        InputStream input = new FileInputStream(templateFile);
        XSSFWorkbook wb = new XSSFWorkbook(input);
        Sheet sheet = wb.getSheetAt(0);
        List<List<String>> lists = sheetData.getLists();
        String name = sheetData.getName();
        wb.setSheetName(0, name);
        int insertRowIndex = getInsertRowIndex(sheet);
        //替换占位符
        writeData(sheetData, sheet);
        //首行
        Row headRow = sheet.createRow(insertRowIndex);
        if (lists.size()>0) {
            //将数据下移
            sheet.shiftRows(insertRowIndex, sheet.getLastRowNum(), lists.size()-1, true, false);
            for (int cel = 0; cel < lists.get(0).size(); cel++) {
                headRow.createCell(cel).setCellValue("");
                //设置每一列的块段
                sheet.setColumnWidth(cel, 256 * 30);
            }
            CellStyle headerStyle = ExportUtil.getHeaderStyle(wb);
            headRow.setHeight((short) (25 * 40));
            List<String> firstRow = lists.get(0);
            for (int j = 0; j <firstRow.size(); j++) {
                Cell cell = headRow.createCell(j);
                cell.setCellValue(firstRow.get(j));
                headRow.getCell(j).setCellStyle(headerStyle);
            }
            CellStyle bodyStyle = ExportUtil.getCellStyle(wb);
            for (int i = insertRowIndex+1; i <insertRowIndex + lists.size(); i++) {
                Row row = sheet.createRow(i);
                row.setHeight((short) (25 * 40));
                List<String> currentRow = lists.get(i - insertRowIndex);
                for (int j = 0; j <currentRow.size(); j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue(currentRow.get(j));
                    row.getCell(j).setCellStyle(bodyStyle);
                }
            }
        }
        export(response, wb, name);
    }

    /**
     * Excel导出工具类
     *
     * @param titles    Excel表头
     * @param columns   表头对应的字段，和headers一一对应
     * @param datas     需要导出的数据对象集合
     * @param fileName  导出的文件名称（不需要后缀）
     * @param sheetName 导出文件的sheet名称
     * @param response  response
     */
    public static void export(String[] titles, String[] columns, List datas, String fileName, String sheetName, HttpServletResponse response) {

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet1 = wb.createSheet(sheetName);
        XSSFRow header = sheet1.createRow(0);
        //设置表头信息
        XSSFCellStyle headerStyle = getHeaderStyle(wb);
        header.setHeightInPoints(20);
        for (int i = 0; i < titles.length; i++) {
            XSSFCell cell = header.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(headerStyle);
        }

        XSSFCellStyle cellStyle = getCellStyle(wb);
        //填充数据
        for (int i = 0; i < datas.size(); i++) {
            Object obj = datas.get(i);
            XSSFRow row = sheet1.createRow(i + 1);
            row.setHeightInPoints(20);
            for (int j = 0; j < titles.length; j++) {
                String value = getValue(columns[j], obj);
                XSSFCell cell = row.createCell(j);
                cell.setCellValue(value);
                cell.setCellStyle(cellStyle);
            }
        }
        if (FIRST_COLUMN.equals(titles[0])) {
            sheet1.setColumnWidth(0, 150 * 20);
        } else {
            sheet1.setColumnWidth(0, 300 * 20);
        }

        for (int i = 1; i < header.getPhysicalNumberOfCells(); i++) {
            sheet1.setColumnWidth(i, 300 * 20);
        }
        export(response, wb, fileName);
    }

    private static XSSFCellStyle getHeaderStyle(XSSFWorkbook wb) {
        //设置标题
        XSSFCellStyle titleStyle = wb.createCellStyle();
        // 水平居中
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        titleStyle.setFillForegroundColor(HSSFColor.LIME.index);

        // 垂直居中
        titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        //下边框
        titleStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //左边框
        titleStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //上边框
        titleStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //右边框
        titleStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);

        XSSFFont font = wb.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) 13);
        //粗体显示
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        titleStyle.setFont(font);
        return titleStyle;
    }

    private static XSSFCellStyle getCellStyle(XSSFWorkbook wb) {
        XSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        //下边框
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //左边框
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //上边框
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //右边框
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        return cellStyle;
    }

    /**
     * 所有数据类型都为string导出
     *
     * @param columnName
     * @param obj
     * @return
     */
    private static String getValue(String columnName, Object obj) {
        if (obj == null || columnName == null || "".equals(columnName)) {
            return "";
        }
        String methodName = "get" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1);
        Object objectValue = getMethodValue(methodName, obj);
        if (objectValue instanceof Date) {
            return DateUtil.format((Date) objectValue, dateFormat);
        }
        if (objectValue instanceof BigDecimal) {
            BigDecimal setScale = ((BigDecimal) objectValue).setScale(scale, BigDecimal.ROUND_HALF_UP);
            return setScale.toString();
        }
        if (objectValue instanceof String) {
            return (String) objectValue;
        }
        return objectValue.toString();
    }

    /**
     * @param methodName
     * @param obj
     * @param args
     * @return return value
     */
    private static Object getMethodValue(String methodName, Object obj,
                                         Object... args) {
        Object result = "";
        try {
            Method[] methods = obj.getClass().getMethods();
            if (methods.length <= 0) {
                return result;
            }
            Method method = null;
            for (Method method1 : methods) {
                if (method1.getName().equalsIgnoreCase(methodName)) {
                    method = method1;
                    break;
                }
            }
            if (method == null) {
                return result;
            }
            result = method.invoke(obj, args);
            if (result == null) {
                result = "";
            }
            //返回结果
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static void export(HttpServletResponse response, XSSFWorkbook wb, String fileName) {
        try {
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName + ".xlsx").getBytes(), StandardCharsets.ISO_8859_1));
            ServletOutputStream outputStream = response.getOutputStream();
            wb.write(outputStream);
            outputStream.flush();//刷新流
            outputStream.close();//关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
