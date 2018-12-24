package com.xiedang.www.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.Iterator;

/**
 * <p>带模板的excel导出</p>
 *
 * @author : 谢当
 * @date : 2018/7/30 14:00
 */
public class ExcelUtils {

    /**
     * 占位符的开头字符串
     */
    public static String PLACEHOLDER_CHAR="#";
    /**
     * 标识填充数据的地方
     */
    public static String SIGN_STR="start_data";

    /**
     * Sheet复制
     *
     * @param fromSheet
     * @param toSheet
     * @param copyValueFlag
     */
    public static void copySheet(Workbook wb, Sheet fromSheet, Sheet toSheet,
                                 boolean copyValueFlag) {
        //合并区域处理
        mergerRegion(fromSheet, toSheet);
        int index = 0;
        for (Iterator<Row> rowIt = fromSheet.rowIterator(); rowIt.hasNext(); ) {
            Row tmpRow = rowIt.next();
            Row newRow = toSheet.createRow(tmpRow.getRowNum());
            CellStyle style = tmpRow.getRowStyle();
            if (style != null) {
                newRow.setRowStyle(tmpRow.getRowStyle());
            }
            newRow.setHeight(tmpRow.getHeight());
            //针对第一行设置行宽
            if (index == 0) {
                int first = tmpRow.getFirstCellNum();
                int last = tmpRow.getLastCellNum();
                for (int i = first; i < last; i++) {
                    int w = fromSheet.getColumnWidth(i);
                    toSheet.setColumnWidth(i, w + 1);
                }
                toSheet.setDefaultColumnWidth(fromSheet.getDefaultColumnWidth());
            }
            //行复制
            copyRow(wb, tmpRow, newRow, copyValueFlag);
            index++;
        }
    }

    /**
     * 行复制功能
     *
     * @param fromRow
     * @param toRow
     */
    private static void copyRow(Workbook wb, Row fromRow, Row toRow, boolean copyValueFlag) {
        for (Iterator<Cell> cellIt = fromRow.cellIterator(); cellIt.hasNext(); ) {
            Cell tmpCell = cellIt.next();
            Cell newCell = toRow.createCell(tmpCell.getColumnIndex());
            copyCell(wb, tmpCell, newCell, copyValueFlag);
        }
    }

    /**
     * 复制原有sheet的合并单元格到新创建的sheet
     *
     * @param fromSheet 新创建sheet
     * @param toSheet   原有的sheet
     */
    private static void mergerRegion(Sheet fromSheet, Sheet toSheet) {
        int sheetMergerCount = fromSheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergerCount; i++) {
            CellRangeAddress cra = fromSheet.getMergedRegion(i);
            toSheet.addMergedRegion(cra);
        }
    }

    /**
     * 复制单元格
     *
     * @param srcCell
     * @param distCell
     * @param copyValueFlag true则连同cell的内容一起复制
     */
    public static void copyCell(Workbook wb, Cell srcCell, Cell distCell,
                                boolean copyValueFlag) {
        CellStyle newStyle = wb.createCellStyle();
        newStyle.cloneStyleFrom(srcCell.getCellStyle());
        //样式
        distCell.setCellStyle(newStyle);
        //评论
        if (srcCell.getCellComment() != null) {
            distCell.setCellComment(srcCell.getCellComment());
        }
        // 不同数据类型处理
        int srcCellType = srcCell.getCellType();
        distCell.setCellType(srcCellType);
        if (copyValueFlag) {
            if (srcCellType == Cell.CELL_TYPE_NUMERIC) {
                if (DateUtil.isCellDateFormatted(srcCell)) {
                    distCell.setCellValue(srcCell.getDateCellValue());
                } else {
                    distCell.setCellValue(srcCell.getNumericCellValue());
                }
            } else if (srcCellType == Cell.CELL_TYPE_STRING) {
                distCell.setCellValue(srcCell.getRichStringCellValue());
            } else if (srcCellType == Cell.CELL_TYPE_BOOLEAN) {
                distCell.setCellValue(srcCell.getBooleanCellValue());
            } else if (srcCellType == Cell.CELL_TYPE_ERROR) {
                distCell.setCellErrorValue(srcCell.getErrorCellValue());
            } else if (srcCellType == Cell.CELL_TYPE_FORMULA) {
                distCell.setCellFormula(srcCell.getCellFormula());
            }
        }
    }


    /**
     * 遍历sheet数据并替换模板占位符
     *
     * @param sheetData 数据Map
     * @param sheet     sheet
     */
    public static void writeData(SheetData<String> sheetData, Sheet sheet) {
        //从sheet中找到匹配符 #{}表示单个
        for (Iterator<Row> rowIt = sheet.rowIterator(); rowIt.hasNext(); ) {
            Row row = rowIt.next();
            //取cell
            for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                //判断cell的内容是否包含 $ 或者#
                if (cell.getStringCellValue() != null && cell.getStringCellValue().contains("#")) {
                    //剥离# $
                    String[] winds = CommonUtils.getWildcard(cell.getStringCellValue().trim());
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
    private static void replaceData(SheetData<String> sheetData, String keyWind, Cell cell) {
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
}
