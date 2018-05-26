package com.example.demo4.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    public static String getResult(String input){
        BigInteger bigInteger=null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] inputData = input.getBytes();
            md.update(inputData);
            bigInteger = new BigInteger(md.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return bigInteger.toString(16);
    }

    public static void main(String[] args) {
        try {
            String inputStr = "如果帅能当饭吃";
            System.out.println(getResult(inputStr));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

