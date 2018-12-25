package com.xiedang.www.utils;

import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <P>Excel导入导出</P>
 *
 */
public class ExcelUtil {

    private static final Logger log = LoggerFactory.getLogger(ExcelUtil.class);

    /**
     * <p>读取excel的一个sheet</p>
     *
     * @param workbook
     * @param sheetIndex
     * @param headerRowCount 头的行数
     * @return
     */
    public static ExcelReadSheetResult readExcelSheet(Workbook workbook, int sheetIndex, int headerRowCount) {

        ExcelReadSheetResult result = new ExcelReadSheetResult();
        result.setHeaderRowCount(headerRowCount);
        result.setSheetIndex(sheetIndex);
        // 获取第sheetIndex张Sheet表
        Sheet readSheet = workbook.getSheet(sheetIndex);
        String sheetName = readSheet.getName();
        result.setSheetName(sheetName);

        //获取合并的单元格
        Range[] rangeCell = readSheet.getMergedCells();
        // 总列数
        int colSum = readSheet.getColumns();
        result.setTotalComulnCount(colSum);
        log.info("总列数:{}", colSum);
        // 总行数
        int rowSum = readSheet.getRows();
        result.setTotalRowCount(rowSum);
        log.info("总行数:{}", rowSum);
        result.setHeaderColumnCount(colSum);
        // 表头中文信息
        int row = 0;
        int realRow = headerRowCount;
        // 读取表头
        for (int j = 0; j < headerRowCount; j++) {
            String[] headers = new String[colSum];
            for (int i = 0; i < colSum; i++) {
                String str;
                str = readSheet.getCell(i, row).getContents();
                //判断是否在合并单元格内
                for (Range r : rangeCell) {
                    if (row >= r.getTopLeft().getRow()
                            && row <= r.getBottomRight().getRow()
                            && i >= r.getTopLeft().getColumn()
                            && i <= r.getBottomRight().getColumn()) {
                        str = readSheet.getCell(r.getTopLeft().getColumn(), r.getTopLeft().getRow()).getContents();
                    }
                }
                if (StringUtils.isBlank(str)) {
                    headers[i] = "";
                } else {
                    headers[i] = str.trim();
                }
            }
            row++;
            result.getHeaderDatas().add(headers);
        }

        //处理表头
        List<String[]> headerDatas = result.getHeaderDatas();
        List<String> handledHeader = new ArrayList<>();
        for (int i = 0; i < colSum; i++) {
            String[] tmpStrArr = new String[headerDatas.size()];
            for (int j = 0; j < headerDatas.size(); j++) {
                String[] strings = headerDatas.get(j);
                tmpStrArr[j] = strings[i];
            }
            String handleStr = StringUtils.join(tmpStrArr, "-");
            handledHeader.add(handleStr);
        }
        result.setHandledHeader(handledHeader);

        // 获取指定单元格的对象引用
        for (; row < rowSum; row++) {
            //是否是空行
            boolean isEmpty = true;
            String[] values = new String[colSum];
            for (int i = 0; i < colSum; i++) {
                String str;
                str = readSheet.getCell(i, row).getContents();
                for (Range r : rangeCell) {
                    if (row >= r.getTopLeft().getRow()
                            && row <= r.getBottomRight().getRow()
                            && i >= r.getTopLeft().getColumn()
                            && i <= r.getBottomRight().getColumn()) {
                        str = readSheet.getCell(r.getTopLeft().getColumn(),r.getTopLeft().getRow()).getContents();
                    }
                }
                if (StringUtils.isBlank(str)) {
                    values[i] = "";
                } else {
                    values[i] = str.trim();
                    isEmpty = false;
                }
            }
            if (isEmpty) {
                continue;
            } else {
                realRow++;
            }
            result.getBodyDatas().add(values);
        }
        result.setTotalRowCount(realRow);
        log.info("真实总行数:{}", realRow);
        return result;
    }

    /**
     * jxl只能获取2003版的excel
     *
     * @param is              输入流
     * @param headerRowCounts 每个sheet的头的行数
     * @return
     */
    public static ExcelReadTotalResult readExcelAll(InputStream is, int... headerRowCounts) throws Exception {
        Workbook workbook = null;
        ExcelReadTotalResult result;
        try {
            // 从读取流创建只读Workbook对象
            workbook = Workbook.getWorkbook(is);
            result = new ExcelReadTotalResult();
            int sheetCount = workbook.getNumberOfSheets();
            result.setSheetCount(sheetCount);
            for (int i = 0; i < sheetCount; i++) {
                if (headerRowCounts.length == 1) {
                    result.getDatas().add(readExcelSheet(workbook, i, headerRowCounts[0]));
                } else {
                    result.getDatas().add(readExcelSheet(workbook, i, headerRowCounts[i]));
                }
            }
        } catch (Exception e) {
            log.error("读取excel异常:{}", e);
            e.printStackTrace();
            throw e;
        } finally {
            if (workbook != null) {
                workbook.close();
            }
        }
        return result;
    }
}
