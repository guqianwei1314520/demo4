package com.example.demo4.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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

    @RequestMapping(value = "/testDownload", method = RequestMethod.GET)
    public ResponseEntity<byte[]> testDownload(HttpServletResponse res)  throws IOException{
        /*String fileName = "111.txt";
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("multipart/form-data");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        InputStream  bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new FileInputStream("d://" + fileName);
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("success");*/
        File file = new File("d://111.txt");
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }
}

