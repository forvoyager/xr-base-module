package com.xr.base.core.dto;

import com.xr.base.core.enums.ResultCodeEnum;
import com.xr.base.core.util.DateUtil;

import java.beans.Transient;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一响应信息格式
 *
 * Created by forvoyager@outlook.com on 2019-02-01 11:54.
 */
public class ResultDto<T> implements Serializable{
  /**
   * 响应代码 see ResultCodeEnum
   */
  private String code;
  /**
   * 信息提示
   */
  private String message;
  /**
   * 数据
   */
  private T data;
  /**
   * 扩展数据
   */
  private Map extData;
  /**
   * 时间
   */
  private Long time;

  public static ResultDto successMessage(String msg) {
    return success(msg, null);
  }

  public static ResultDto successData(Object data) {
    return success("OK", data);
  }

  public static ResultDto success(String msg, Object data) {
    ResultDto result = new ResultDto();
    result.setCode(ResultCodeEnum.SUCCESS.getCode());
    result.setMessage(msg);
    result.setTime(DateUtil.currentTimeInSecond());
    result.setData(data);
    return result;
  }

  public static ResultDto failure(String msg) {
    return failure(msg, null);
  }

  public static ResultDto failure(Object data) {
    return failure("Failed", data);
  }

  public static ResultDto failure(String msg, Object data) {
    ResultDto result = new ResultDto();
    result.setCode(ResultCodeEnum.UNKNOW_SYSTEM_ERROR.getCode());
    result.setMessage(msg);
    result.setTime(DateUtil.currentTimeInSecond());
    result.setData(data);
    return result;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public Map getExtData() {
    return extData;
  }

  public void setExtData(Map extData) {
    this.extData = extData;
  }

  public void putExtData(String key, Object data) {
    if(this.extData == null){
      this.extData = new HashMap();
    }

    this.extData.put(key, data);
  }

  public Long getTime() {
    return time;
  }

  public void setTime(Long time) {
    this.time = time;
  }

  @Transient
  public void assertSuccess(){
    if(ResultCodeEnum.SUCCESS.getCode().equals(code)){
      return;
    }

    throw new IllegalStateException(message);
  }

  @Transient
  public T getSuccessData(){
    this.assertSuccess();
    return data;
  }
}
