package com.github.xiaotong.collegeselection.rest;

import java.util.List;

import com.github.xiaotong.collegeselection.body.ResponseData;
import com.github.xiaotong.collegeselection.dao.bean.UListBean;
import com.github.xiaotong.collegeselection.dao.bean.ViewStrenthBean;
import com.github.xiaotong.collegeselection.service.StrenthDisciplineService;
import com.github.xiaotong.collegeselection.service.StrenthMajorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

/**
 * 强基计划controller
 */
@RestController // 返回是json串
@RequestMapping("/strenth")
@Log4j
public class StrenthDisciplineController {
  private @Autowired StrenthDisciplineService disciplineService;
  private @Autowired StrenthMajorService majorsService;
  /**
   * 得到强基计划所有信息
   * @return
   */
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
   * 得到强基计划学校列表
   * @return
   */
  @GetMapping("/university")
  public ResponseData<Object> getUniversityList() {
    List<UListBean> results = disciplineService.getAllUniversityList();
    if (null != results) {
      return ResponseData.success(results);
    } else {
      return ResponseData.failed("系统错误");
    }
  }

  /**
   * 通过id得到具体学校强基计划内容
   * @return
   */
  @GetMapping("/specific/{id}")  
  public ResponseData<Object> getStrenthByID(@PathVariable Integer id) {
    log.info(id);
    ResponseData<Object> results = disciplineService.getDiscipliineWithUniversityID(id);
    log.info(results);
    return results;
  }

  /**
   * 通过id得到具体学校强基计划专业的内容
   * @return
   */
  @GetMapping("/majors/{id}")  
  public ResponseData<Object> getStrenthMajors(@PathVariable Integer id) {
    log.info(id);
    ResponseData<Object> results = majorsService.getMajorsByID(id);
    log.info(results);
    return results;
  }

 
}
