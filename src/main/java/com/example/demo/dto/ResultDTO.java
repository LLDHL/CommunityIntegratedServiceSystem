package com.example.demo.dto;

import com.example.demo.exception.CustomErrorCode;
import lombok.Data;

@Data
public class ResultDTO<T> {
    private Integer code;
    private String message;
    private T data;

    public static ResultDTO okOf(){
        ResultDTO resultDTO=new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("获取成功");
        return resultDTO;
    }

    /*发帖返回数据*/
    public static <T>ResultDTO okOfPublish(T data){
        ResultDTO resultDTO=new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("发表成功");
        resultDTO.setData(data);
        return resultDTO;
    }

    /*删帖返回数据*/
    public static ResultDTO okOfDelete(){
        ResultDTO resultDTO=new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("删除成功");
        return resultDTO;
    }

    /*修改返回数据*/
    public static <T>ResultDTO okOfUpdate(T data){
        ResultDTO resultDTO=new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("修改成功");
        resultDTO.setData(data);
        return resultDTO;
    }

    public static ResultDTO okOf(String message){
        ResultDTO resultDTO=new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static <T>ResultDTO okOf(String message,T data){
        ResultDTO resultDTO=new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage(message);
        resultDTO.setData(data);
        return resultDTO;
    }

    public static ResultDTO errorOf(CustomErrorCode errorCode) {
        return errorOf(errorCode.getCode(),errorCode.getMessage());
    }

    public static ResultDTO errorOf(Integer code,String message) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static <T>ResultDTO baseOf(Integer code,String message,T data){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        resultDTO.setData(data);
        return resultDTO;
    }
}
