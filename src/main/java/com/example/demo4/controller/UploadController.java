package com.example.demo4.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping("/test")
    public JSONObject uploadFile(@RequestParam("file") MultipartFile file,HttpServletRequest request){
        JSONObject object=new JSONObject();
        String fileName = file.getOriginalFilename();
        String filePath = request.getSession().getServletContext().getRealPath("/upload/");
        String rename=UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf("."));
        try {
            File targetFile = new File(filePath);
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }
            FileOutputStream out = new FileOutputStream(filePath+rename);
            out.write(file.getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {

        }
        object.put("code",1);
        return object;
    }
}
