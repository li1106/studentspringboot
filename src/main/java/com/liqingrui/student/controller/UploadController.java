package com.liqingrui.student.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/file/")
@CrossOrigin
public class UploadController {
    //    域
    @Value("${file.domain}")
    private String fileDomain;
    //    文件存放路径
    @Value("${file.path}")
    private String filePath;

    @PostMapping("upload")
    public Object upload(@RequestParam("file")MultipartFile file){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("result",false);
//        文件名
//        String fileName = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString()+".jpg";
//        文件保存地址
        File destFile = new File(filePath + fileName);
        try {
//            保存文件
            file.transferTo(destFile);
            resultMap.put("result",true);
//            将传入的文件的名字存入到map当中
            resultMap.put("fileName",fileName);
            resultMap.put("imgUrl",fileDomain+fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return resultMap;
        }
        return resultMap;
    }
    /**
     * 文件删除方法
     * @param fileName
     * @return
     */
    @GetMapping("del")
    public Object upload(@RequestParam("fileName") String fileName) {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("result", false);
//        文件地址
        File destFile = new File(filePath + fileName);
        destFile.delete();
        resultMap.put("result", true);
//        resultMap 为唯一标识  存放boolean值
        return resultMap;
    }

}
