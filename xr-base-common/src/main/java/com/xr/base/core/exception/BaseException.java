package com.xr.base.core.exception;

import com.xr.base.core.enums.ResultCodeEnum;

import java.util.Map;

/**
 * Created by forvoyager@outlook.com on 2019-01-31 14:54.
 */
public class BaseException extends RuntimeException{
  /**
   * 代码
   * @see ResultCodeEnum
   */
  private String code;
  /**
   * 信息提示
   */
  private String message;
  /**
   * 扩展数据
   */
  private Map extData;

  public BaseException(ResultCodeEnum code, String message){
    this.code = code.getCode();
    this.message = message;
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

  public Map getExtData() {
    return extData;
  }

  public void setExtData(Map extData) {
    this.extData = extData;
  }
}
