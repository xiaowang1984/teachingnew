package com.neuedu.util;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.neuedu.pojo.Imgs;
import com.neuedu.service.IImgsService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangyu on 2019/11/25.
 */
@Component
public class ControllerUtil {
    @Resource
    FastFileStorageClient storageClient;
    @Reference
    IImgsService imgsService;
    // 上传文件 保存到 fastdfs 并返回路径
    public String upload(MultipartFile files){
        String path = null;
        try {
            String s = DigestUtils.md5Hex(files.getBytes());
            Imgs img = imgsService.getImgByMD5(s);
            if(null == img){
                StorePath storePath = storageClient.uploadFile(files.getInputStream(), files.getSize(), FilenameUtils.getExtension(files.getOriginalFilename()), null);
                path = storePath.getFullPath();
                img = new Imgs(s,path);
                imgsService.save(img);
            }else{
                path = img.getUrl();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
    // 生成二维码
    public static BufferedImage createQRCode(String contents, int width, int height,int margin) throws Exception {
        if (contents == null || contents.equals("")) {
            throw new Exception("contents不能为空。");
        }
        Map<EncodeHintType, Object> hints = new HashMap<>();
        // 设置编码字符集utf-8
        hints.put(EncodeHintType.CHARACTER_SET, CharacterSetECI.UTF8);
        /**
         * 设置纠错等级L/M/Q/H,
         * 当二维码被损毁一部分时，
         * 纠错等级越高，越可能读取成功；
         * 同样的，纠错等级越高，单位面积内点阵的点越多，
         * 机器扫描时，识别所需时间越长，当前设置等级为最高等级H
         *
         * */
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        // 可设置范围为0-10，但仅四个变化0 1(2) 3(4 5 6) 7(8 9 10)
        hints.put(EncodeHintType.MARGIN, margin);
        // 生成图片类型为QRCode
        BarcodeFormat format = BarcodeFormat.QR_CODE;
        BitMatrix matrix = null;
        try {
            // 生成二维码对应的位矩阵对象
            matrix = new MultiFormatWriter().encode(contents, format, width, height, hints);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        // 设置位矩阵转图片的参数
        MatrixToImageConfig config = new MatrixToImageConfig(Color.black.getRGB(), Color.white.getRGB());
        // 位矩阵对象转BufferedImage对象
        BufferedImage qrcode = MatrixToImageWriter.toBufferedImage(matrix, config);
        return qrcode;
    }

}
