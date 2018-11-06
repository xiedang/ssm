package com.xiedang.www.utils;

import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.StreamOpenOfficeDocumentConverter;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * <P>签章相关工具,根据模板生成word和word生成pdf</P>
 *
 * @author 陶焕(13294175866)
 * @date 2016年3月16日 下午8:36:38
 */
public class PdfUtils {

    private static final Logger log = LoggerFactory.getLogger(PdfUtils.class);

    /**
     * <p>TODO</p>
     *
     * @param srcFile  源文件, 绝对路径. 可以是Office2003-2007全部格式的文档, Office2010的没测试. 包括.doc,
     *                 .docx, .xls, .xlsx, .ppt, .pptx等. 示例: F:\\office\\source.doc
     * @param destFile 目标文件. 绝对路径. 示例: F:\\pdf\\dest.pdf
     * @return
     * @throws Exception
     * @author 陶焕(13294175866)
     */
    public static CommonResult<File> officeToPdf(String officeHost, int officePort, File srcFile, File destFile) throws Exception {
        CommonResult<File> result = new CommonResult<>(CommonResult.FAILURE_CODE);
        Path path = srcFile.toPath();
        boolean exists = Files.exists(path);
        // 如果目标路径不存在,则新建该路径
        if (exists) {
            if(!Files.exists(path.getParent())){
                Files.createDirectories(path.getParent());
            }
        }else {
            result.setMessage("找不到源文件");
            return result;
        }
        OpenOfficeConnection connection = new SocketOpenOfficeConnection(
                officeHost, officePort);
        log.info("开始连接openoffice{},{}", officeHost, officePort);
        connection.connect();
        log.info("连接openoffice{},{}成功。", officeHost, officePort);
        StreamOpenOfficeDocumentConverter converter = new StreamOpenOfficeDocumentConverter(connection);
        log.info("开始连接转换PDF");
        converter.convert(srcFile, destFile);
        log.info("连接转换PDF成功！");
        connection.disconnect();
        result.setData(destFile);
        result.setSuccess(CommonResult.SUCCESS_CODE);
        return result;
    }

    /**
     * <p>直接根据Word模板和数据生成Pdf</p>
     *
     * @param tmpFile  word模板
     * @param destFile 目的pdf文件
     * @param data     数据
     * @return
     * @throws Exception
     * @author 陶焕(13294175866)
     */
    public static CommonResult<File> genePdf(String officeHost, int officePort, File tmpFile, File destFile, Map<String, String> data) throws Exception {
        File srcFile = new File(FileUtils.getTempDirectory(), UUID.randomUUID().toString() + ".doc");
        CommonResult<File> result = geneWord(tmpFile, srcFile, data);
        if (Objects.equals(result.getSuccess(), CommonResult.FAILURE_CODE)) {
            return result;
        }
        srcFile = result.getData();
        result = officeToPdf(officeHost, officePort, srcFile, destFile);
        if (Objects.equals(result.getSuccess(), CommonResult.FAILURE_CODE)) {
            return result;
        }
        FileUtils.deleteQuietly(srcFile);
        return result;
    }

    /**
     * <p>根据模板和数据生成word</p>
     *
     * @param tmpFile
     * @param destFile
     * @param data
     * @return
     * @author 陶焕(13294175866)
     */
    public static CommonResult<File> geneWord(File tmpFile, File destFile, Map<String, String> data) throws Exception {
        CommonResult<File> result = new CommonResult<>(CommonResult.FAILURE_CODE);
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(tmpFile);
            HWPFDocument hdt = new HWPFDocument(new POIFSFileSystem(in));
            //替换读取到的word模板内容的指定字段
            Range range = hdt.getRange();
            for (Map.Entry<String, String> entry : data.entrySet()) {
                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                if (value.contains("\n")) {
                    String[] contents = value.split("\n");
                    StringBuilder content = new StringBuilder();
                    for (String content1 : contents) {
                        content.append(content1).append((char) 11);
                    }
                    range.replaceText("${" + entry.getKey() + "}$", content.toString());
                } else {
                    range.replaceText("${" + entry.getKey() + "}$", value);
                }
            }
            out = new FileOutputStream(destFile);
            hdt.write(out);
            result.setData(destFile);
        } finally {
            assert out != null;
            out.close();
            in.close();
        }
        result.setSuccess(CommonResult.SUCCESS_CODE);
        return result;
    }

}
