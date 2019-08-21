package com.feri.shop.newretail.resource.controller;

import com.feri.shop.newretail.common.config.SystemConfig;
import com.feri.shop.newretail.common.util.FileUtil;
import com.feri.shop.newretail.common.vo.R;
import com.feri.shop.newretail.resource.core.util.OssUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import java.io.IOException;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-15 15:25
 */
@RestController
public class OssController {

    //文件上传
    @PostMapping("nr/resource/saveoss")
    public R fileUp(CommonsMultipartFile file) throws IOException {
        if(!file.isEmpty()){
            String fn= FileUtil.renameFile(file.getOriginalFilename());
            String url= OssUtil.sendByte(SystemConfig.OSSBUCKET,fn,file.getInputStream());
            if(url!=null){
                return R.setOK("上传成功",url);
            }
        }
        return R.setERROR("上传异常，请重新尝试");
    }
    //删除文件
    @GetMapping("nr/resource/deloss")
    public R del(String objName) throws IOException {
        OssUtil.delObject(SystemConfig.OSSBUCKET,objName);
        return R.setOK("删除成功");
    }
}
