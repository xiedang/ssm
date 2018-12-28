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
    CommonResult<BillFiles> uploadFile(FilesVo filesVo, MultipartFile file) throws IllegalStateException, IOException;
}
