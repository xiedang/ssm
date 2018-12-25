package com.xiedang.www.utils.web;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * <P>Web工具包</P>
 */
public class WebUtil {

    private static Logger log = LoggerFactory.getLogger(WebUtil.class);

    /**
     * <p>返回文件或者文件流</p>
     *
     * @param response
     */
    public static void returnFile(HttpServletRequest request, HttpServletResponse response, String contentType, File file, boolean isDownload) {
        try {
            //获取文件名称，在转化为子串
            String filename = file.getName();
            String userAgent = request.getHeader("User-Agent");
            if (StringUtils.isNotBlank(userAgent)) {
                String mozilla = "Mozilla";
                if (userAgent.contains(mozilla)) {
                    // 火狐,chrome等
                    filename = new String(filename.getBytes("UTF-8"), "iso-8859-1");
                } else {
                    // ie
                    filename = java.net.URLEncoder.encode(filename, "UTF-8");
                }
                if (isDownload) {
                    //attachment --- 作为附件下载
                    //inline --- 在线打开
                    // 文件名外的双引号处理firefox的空格截断问题
                    response.setHeader("Content-disposition", String.format("attachment; filename=\"%s\"", filename));
                }
            }
            returnStream(response, contentType, new FileInputStream(file));
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
            log.error("向客户端输出流出错:{}", e);
        }
    }


    /**
     * <p>向客户端输出流</p>
     *
     * @param response
     * @param in
     */
    public static void returnStream(HttpServletResponse response, String contentType, InputStream in) {
        OutputStream out;
        try {
            int len;
            // 缓存作用
            byte[] buf = new byte[4096];
            if (StringUtils.isNotBlank(contentType)) {
                response.setContentType(contentType);
            }
            // 输出流
            out = response.getOutputStream();
            // 切忌这后面不能加 分号 ”;“
            while ((len = in.read(buf)) > 0) {
                // 向客户端输出，实际是把数据存放在response中，然后web服务器再去response中读取
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            log.error("打开输出流出错:{}", e);
        }
    }

    /**
     * 压缩文件
     * @param zipFile
     */
    public static File zipFile(List<File> files, File zipFile){
        try {
            byte[] bytes = new byte[1024];
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));
            for (File file : files) {
                String fileName = file.getName();
                FileInputStream fis = new FileInputStream(file);
                out.putNextEntry(new ZipEntry(fileName));
                int len;
                while ((len = fis.read(bytes)) != -1) {
                    out.write(bytes, 0, len);
                }
                out.closeEntry();
                fis.close();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return zipFile;
    }
}
