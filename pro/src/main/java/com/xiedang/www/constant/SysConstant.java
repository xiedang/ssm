package com.xiedang.www.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @author : 谢当
 * @date : 2018/11/6 9:43
 */
@Component
public class SysConstant {

    @Value("${var.openoffice.converter.host}")
    public String openOfficeHost;

    @Value("${var.openoffice.converter.port}")
    public String openOfficePort;
}
