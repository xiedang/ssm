package com.xiedang.www.service.impl;

import com.xiedang.www.constant.SysConstant;
import com.xiedang.www.mapper.BillFilesMapper;
import com.xiedang.www.model.BillFiles;
import com.xiedang.www.service.BillFileService;
import com.xiedang.www.utils.common.CommonResult;
import com.xiedang.www.utils.date.DateUtil;
import com.xiedang.www.vo.FilesVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * <p></p>
 *
 * @author : 谢当
 * @date : 2018/12/27 16:36
 */
@Service
public class BillFileServiceImpl implements BillFileService {

    @Autowired
    private SysConstant sysConstant;
    @Autowired
    private BillFilesMapper billFilesMapper;

    /**
     * 上传文件
     *
     * @param filesVo
     * @param file
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public CommonResult<BillFiles> uploadFile(FilesVo filesVo, MultipartFile file) throws IllegalStateException, IOException {
        CommonResult<BillFiles> result = new CommonResult<>(CommonResult.SUCCESS_CODE);
        //文件目录路径
        String fileDir = "";
        if(StringUtils.isNotBlank(filesVo.getFileDir())){
            fileDir= "/"+filesVo.getFileDir();
        }
        String fileUploadPath = sysConstant.uploadPath + fileDir;
        String fileName = "null.jpg";
        if (null != file.getOriginalFilename() && file.getOriginalFilename().length() > 4) {
            fileName = file.getOriginalFilename();
            int length = fileName.length();
            fileName = fileName.substring(0, length - 3).replaceAll("%", "").replace("#", "") + fileName.substring(length - 3, length).toLowerCase();
        }
        Date now = new Date();
        String realFileName = DateUtil.format(now, "yyyyMMddHHmmss") + "-" + fileName;
        BillFiles billFiles = new BillFiles();
        //按照年月创建文件夹进行分流
        String ny = DateUtil.format(now, "yyyy-MM");
        billFiles.setBfsName(fileName);
        billFiles.setBfsPath(fileDir + "/" + ny + "/" + realFileName);
        billFiles.setBfsCreateTime(new Date());
        billFiles.setBfsBillType(filesVo.getBfsBillType());
        billFiles.setBfsType(filesVo.getBfsType());
        billFilesMapper.insertSelective(billFiles);

        Path path = Paths.get(fileUploadPath + "/" + ny + "/" + realFileName);
        if (!Files.exists(path.getParent())) {
            //不存在就创建日期文件夹
            Files.createDirectories(path.getParent());
        }
        file.transferTo(path.toFile());
        result.setData(billFiles);
        return result;
    }
}
