package com.xiedang.www.utils.word;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.xwpf.usermodel.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * word 模板替换工具类
 */
public class WordUtil {

    private static Pattern pattern = Pattern.compile("\\$\\{(.+?)}", Pattern.CASE_INSENSITIVE);

    /**
     * 替换段落里面的变量
     *
     * @param doc    要替换的文档
     * @param params 参数
     */
    public void replaceInPara(XWPFDocument doc, Map<String, String> params) {
        Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
        while (iterator.hasNext()) {
            XWPFParagraph para = iterator.next();
            this.replaceInPara(para, params);
        }
    }

    /**
     * <p>word模板替换内容</p>
     *
     * @param doc
     * @param params
     */
    public void replaceWord(XWPFDocument doc, Map<String, String> params) {
        Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
        while (iterator.hasNext()) {
            XWPFParagraph para = iterator.next();
            this.replaceWord(para, params);
        }
    }

    /**
     * 替换段落里面的变量
     *
     * @param para   要替换的段落
     * @param params 参数
     */
    private void replaceInPara(XWPFParagraph para, Map<String, String> params) {
        if (this.matcher(para.getParagraphText()).find()) {
            List<XWPFRun> runs = para.getRuns();
            int start = -1;
            int end = -1;
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < runs.size(); i++) {
                XWPFRun run = runs.get(i);
                String runText = run.toString();
                if ('$' == runText.charAt(0) && '{' == runText.charAt(1)) {
                    start = i;
                }
                if ((start != -1)) {
                    str.append(runText);
                }
                if ('}' == runText.charAt(runText.length() - 1)) {
                    if (start != -1) {
                        end = i;
                        break;
                    }
                }
            }
            for (int i = start; i <= end; i++) {
                para.removeRun(i);
                i--;
                end--;
            }
            for (String key : params.keySet()) {
                if (str.toString().equals(key)) {
                    para.createRun().setText(params.get(key));
                    break;
                }
            }
        }
    }

    /**
     * <p>word模板替换内容</p>
     *
     * @param para
     * @param params
     */
    private void replaceWord(XWPFParagraph para, Map<String, String> params) {
        if (this.matcher(para.getParagraphText()).find()) {
            List<XWPFRun> runs = para.getRuns();
            int start = -1;
            int end = -1;
            for (int i = 0; i < runs.size(); i++) {
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < runs.size(); j++) {
                    XWPFRun run = runs.get(j);
                    String runText = run.toString();
                    if (StringUtils.isNotBlank(runText)) {
                        if ('$' == runText.charAt(0) && '{' == runText.charAt(1)) {
                            start = j;
                        }
                        if ((start != -1)) {
                            str.append(runText);
                        }
                        if ('}' == runText.charAt(runText.length() - 1)) {
                            if (start != -1) {
                                end = j;
                                break;
                            }
                        }
                    }
                }
                if (StringUtils.isNotBlank(str.toString())) {
                    if (str.indexOf("$") != -1) {
                        str = new StringBuilder(str.substring(str.indexOf("$")));
                        for (int k = start; k <= end; k++) {
                            para.removeRun(k);
                            k--;
                            end--;
                            if (start > end) {
                                for (String key : params.keySet()) {
                                    if (str.toString().equals(key)) {
                                        para.getRuns().get(k).setText(params.get(key));
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 替换表格里面的变量
     *
     * @param doc    要替换的文档
     * @param params 参数
     */
    public void replaceInTable(XWPFDocument doc, Map<String, String> params) {
        Iterator<XWPFTable> iterator = doc.getTablesIterator();
        while (iterator.hasNext()) {
            XWPFTable table = iterator.next();
            List<XWPFTableRow> rows = table.getRows();
            for (XWPFTableRow row : rows) {
                List<XWPFTableCell> cells = row.getTableCells();
                for (XWPFTableCell cell : cells) {
                    List<XWPFParagraph> paras = cell.getParagraphs();
                    for (XWPFParagraph para : paras) {
                        this.replaceInPara(para, params);
                    }
                }
            }
        }
    }



    /**
     * <p>表格形式替换模板</p>
     *
     * @param document
     * @param map
     */
    public void searchAndReplace(XWPFDocument document, Map<String, String> map) {
        try {
            /*
             * 替换段落中的指定文字
             */
            Iterator<XWPFParagraph> itPara = document.getParagraphsIterator();
            while (itPara.hasNext()) {
                XWPFParagraph paragraph = itPara.next();
                Set<String> set = map.keySet();
                for (String key : set) {
                    List<XWPFRun> run = paragraph.getRuns();
                    for (XWPFRun aRun : run) {
                        if (aRun.getText(aRun.getTextPosition()) != null &&
                                aRun.getText(aRun.getTextPosition()).equals(key)) {
                            /*
                             * 参数0表示生成的文字是要从哪一个地方开始放置,设置文字从位置0开始
                             * 就可以把原来的文字全部替换掉了
                             */
                            aRun.setText(map.get(key), 0);
                        }
                    }
                }
            }

            /*
             * 替换表格中的指定文字
             */
            Iterator<XWPFTable> itTable = document.getTablesIterator();
            while (itTable.hasNext()) {
                XWPFTable table = itTable.next();
                int count = table.getNumberOfRows();
                for (int i = 0; i < count; i++) {
                    XWPFTableRow row = table.getRow(i);
                    List<XWPFTableCell> cells = row.getTableCells();
                    for (XWPFTableCell cell : cells) {
                        for (Entry<String, String> e : map.entrySet()) {
                            if (cell.getText().equals(e.getKey())) {
                                cell.removeParagraph(0);
                                cell.setText(e.getValue());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 正则匹配字符串 匹配${xx}字符串
     *
     * @param str
     * @return
     */
    private Matcher matcher(String str) {
        return pattern.matcher(str);
    }

    /**
     * 关闭输入流
     *
     * @param is
     */
    public void close(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭输出流
     *
     * @param os
     */
    public void close(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}