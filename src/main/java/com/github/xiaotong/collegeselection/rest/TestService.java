package com.github.xiaotong.collegeselection.rest;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService {
 
  @GetMapping(value = "/hello")
  public String hello() {
    Map<String, String> msg = new HashMap<String, String>();
    msg.put("message", "Hello SpringBoot!");
    return JSON.toJSONString(msg);
  }
}
