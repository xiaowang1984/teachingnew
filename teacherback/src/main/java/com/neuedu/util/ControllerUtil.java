package com.neuedu.util;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.neuedu.pojo.Imgs;
import com.neuedu.service.IImgsService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by wangyu on 2019/11/25.
 */
@Component
public class ControllerUtil {
    @Resource
    FastFileStorageClient storageClient;
    @Reference
    IImgsService imgsService;
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
}
