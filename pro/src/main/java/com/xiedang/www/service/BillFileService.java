package com.xiedang.www.service;

import com.xiedang.www.model.BillFiles;
import com.xiedang.www.utils.common.CommonResult;
import com.xiedang.www.vo.FilesVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p></p>
 *
 * @author : 谢当
 * @date : 2018/12/27 16:35
 */
public interface BillFileService {

    /**
     * 文件上传
     * @param filesVo 上传参数
     * @param file 上传文件
     * @return 附件实体类集合
     */
    CommonResult<BillFiles> uploadFile(FilesVo filesVo, MultipartFile file) throws IllegalStateException, IOException;
}
