package com.github.xiaotong.collegeselection.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.github.xiaotong.collegeselection.body.PostParam;
import com.github.xiaotong.collegeselection.body.ResponseData;
import com.github.xiaotong.collegeselection.dao.bean.ViewStrenthBean;
import com.github.xiaotong.collegeselection.service.StrenthDisciplineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController//返回是json串
public class TestService {
 
  private @Autowired StrenthDisciplineService disciplineService;

  @GetMapping("/allstrenth")
  public ResponseData<Object> getAll() {
    List<ViewStrenthBean> results = disciplineService.getAllDiscipline();
    if (null != results) {
      return ResponseData.success(results);
    } else {
      return ResponseData.failed("系统错误");
    }
  }

  /**
   * 测试请求
   * @return 请求的JSON字符串
   */
  @GetMapping(value = "/hello")//get 请求
  public String hello() {
    Map<String, String> msg = new HashMap<String, String>();
    msg.put("message", "Hello SpringBoot!");
    //return JSON.toJSONString(msg);
    return "Hello World!";
  }

  /**
   * 测试请求
   * @return 请求返回的数据Body
   */
  @GetMapping(value="/hellobody")
  public ResponseData<Object> body() {
    return ResponseData.success("Hello SpringBoot!(with Body)");
  }

  /**
   * 
   */
  @PostMapping("/post/hello")
  public ResponseData<PostParam> postHello(@RequestBody PostParam data) {
    return ResponseData.success(data);
  }
}
