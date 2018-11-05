package com.xiedang.www.utils;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
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
        if ("序号".equals(titles[0])) {
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
            return DateUtils.format((Date) objectValue, dateFormat);
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
            response.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName + ".xlsx").getBytes(), "iso-8859-1"));
            ServletOutputStream outputStream = response.getOutputStream();
            wb.write(outputStream);
            outputStream.flush();//刷新流
            outputStream.close();//关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
