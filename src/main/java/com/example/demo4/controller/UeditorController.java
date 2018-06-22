package com.example.demo4.controller;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/sys/ueditor")
public class UeditorController {

    @RequestMapping(value = "/exec")
    public String exec(HttpServletRequest request, @RequestParam String action,@RequestParam(value="upfile",required=false) MultipartFile file) throws UnsupportedEncodingException {
       if("config".equals(action)){
           String rootPath = request.getSession().getServletContext().getRealPath("/");
           File filePath = new File(rootPath + "/config.json");
           String content="";
           try {
               content = FileUtils.readFileToString(filePath, "UTF-8");
           } catch (IOException e) {

           }
           return content;
       }else{
           String fileName = file.getOriginalFilename();
           String filePath = request.getSession().getServletContext().getRealPath("/upload/");
           String rename=UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf("."));

               File targetFile = new File(filePath);
               if(!targetFile.exists()){
                   targetFile.mkdirs();
               }
           try {
               FileOutputStream out = new FileOutputStream(filePath+rename);
               out.write(file.getBytes());
               out.flush();
               out.close();
           } catch (Exception e) {

           }

           //{"original":"demo.jpg","name":"demo.jpg","url":"\/server\/ueditor\/upload\/image\/demo.jpg","size":"99697","type":".jpg","state":"SUCCESS"}
           JSONObject object=new JSONObject();
               object.put("url","http://localhost:8017/upload/"+rename);;
               object.put("state","SUCCESS");
           return object.toJSONString();
       }

    }
 }