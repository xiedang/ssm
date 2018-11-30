package com.xiedang.www.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 3Des 加密解密
 * Created by abc_pc on 2018/8/15.
 */
public class ThreeDESUtil {

    /**
     * key 根据实际情况对应的修改
     * keyByte为加密密钥，长度为24字节
     */
    private static final String key = "19940306";

    /**
     * 转换成十六进制字符串
     *
     * @return lee on 2017-08-09 10:54:19
     */
    public static byte[] hex(String key) {
        String f = DigestUtils.md5Hex(key);
        byte[] bKeys = f.getBytes();
        byte[] enk = new byte[24];
        for (int i = 0; i < 24; i++) {
            enk[i] = bKeys[i];
        }
        return enk;
    }

    /**
     * 3DES加密
     *
     * @param srcStr 将加密的字符串
     * @return lee on 2017-08-09 10:51:44
     */
    public static String encode3Des(String srcStr) throws Exception {
        byte[] keyByte = hex(key);
        byte[] src = srcStr.getBytes();
        //生成密钥
        SecretKey desKey = new SecretKeySpec(keyByte, "DESede");
        //加密
        Cipher c1 = Cipher.getInstance("DESede");
        c1.init(Cipher.ENCRYPT_MODE, desKey);
        String pwd = Base64.encodeBase64String(c1.doFinal(src));
        return pwd;
    }

    /**
     * 3DES解密
     *
     * @param desStr
     * @return lee on 2017-08-09 10:52:54
     */
    public static String decode3Des(String desStr) throws Exception {
        Base64 base64 = new Base64();
        byte[] keyByte = hex(key);
        byte[] src = base64.decode(desStr);
        //生成密钥
        SecretKey desKey = new SecretKeySpec(keyByte, "DESede");
        //解密
        Cipher c1 = Cipher.getInstance("DESede");
        c1.init(Cipher.DECRYPT_MODE, desKey);
        String pwd = new String(c1.doFinal(src), "UTF-8");
        return pwd;
    }

    public static void main(String[] args) throws Exception {
        String message = "zyk1314654321";
        String encode = ThreeDESUtil.encode3Des(message);
        System.out.println(encode);
    }

}