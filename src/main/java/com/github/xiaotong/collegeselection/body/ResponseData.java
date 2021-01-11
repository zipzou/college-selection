package com.github.xiaotong.collegeselection.body;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 返回给前端的实体包裹对象
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData<T> {
  private boolean success=true;
  private String reason;
  private String message;
  private T data;
  /**
   * 产生一个带有返回数据及失败原因的响应数据
   * @param <T> 返回数据的数据类型
   * @param data 需要返回的相应数据
   * @param reason 失败原因
   * @return 请求失败响应实体
   */
  public static <T> ResponseData<T> failed(T data, String reason) {
    ResponseData<T> res = new ResponseData<T>();
    res.data = data;
    res.success = false;
    res.message = reason;
    return res;
  }

  /**
   * 产生一个仅含有失败原因的响应实体
   * @param reason 请求失败原因
   * @return 请求失败响应实体
   */
  public static ResponseData<Object> failed(String reason) {
    ResponseData<Object> res = new ResponseData<Object>();
    res.data = null;
    res.success = false;
    res.message = reason;
    return res;
  }

  /**
   * 产生一个仅含有返回数据的请求成功实体
   * @param <T> 返回数据的数据类型
   * @param data 所需返回的数据
   * @return 请求成功响应实体
   */
  public static <T> ResponseData<T> success(T data) {
    ResponseData<T> res = new ResponseData<T>();
    res.data = data;
    res.success = true;
    return res;
  }

  /**
   * 产生一个既含有返回数据也含有执行结果的成功响应实体
   * @param <T> 返回数据的数据类型
   * @param data 所需返回的数据
   * @param message 请求执行后的信息
   * @return 请求成功的响应实体
   */
  public static <T> ResponseData<T> success(T data, String message) {
    ResponseData<T> res = new ResponseData<T>();
    res.data = data;
    res.success = true;
    res.message = message;
    return res;
  }

  /**
   * 产生一个仅含有请求消息的实体
   * @param message 请求执行后的信息
   * @return 请求成功的响应实体
   */
  public static ResponseData<Object> success(String message) {
    ResponseData<Object> res = new ResponseData<Object>();
    res.success = true;
    res.message = message;
    return res;
  }

  /**
   * 产生一个不含有任何信息的请求响应实体
   * @return 请求成功的响应实体
   */
  public static ResponseData<Object> success() {
    ResponseData<Object> res = new ResponseData<Object>();
    res.success = true;
    return res;
  }
}
