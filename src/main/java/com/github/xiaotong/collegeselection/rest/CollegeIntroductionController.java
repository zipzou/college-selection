package com.github.xiaotong.collegeselection.rest;

import java.util.List;

import com.github.xiaotong.collegeselection.body.ResponseData;
import com.github.xiaotong.collegeselection.dao.bean.ScoreHistoryBean;
import com.github.xiaotong.collegeselection.dao.bean.ScoreSegmentBean;
import com.github.xiaotong.collegeselection.dao.bean.SubCategoryListBean;
import com.github.xiaotong.collegeselection.dao.bean.UniversityInfoBean;
import com.github.xiaotong.collegeselection.dao.bean.UniversityListBean;
import com.github.xiaotong.collegeselection.dao.bean.ViewEnrollHistoryBean;
import com.github.xiaotong.collegeselection.dao.bean.ViewEnrollInfoBean;
import com.github.xiaotong.collegeselection.dao.bean.ViewMajorsInfoBean;
import com.github.xiaotong.collegeselection.service.EnrollHistoryService;
import com.github.xiaotong.collegeselection.service.EnrollInfoService;
import com.github.xiaotong.collegeselection.service.MajorsInfoService;
import com.github.xiaotong.collegeselection.service.ScoreHistoryService;
import com.github.xiaotong.collegeselection.service.ScoreSegmentService;
import com.github.xiaotong.collegeselection.service.UniversityInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

/**
 * 高校介绍controller
 */
@RestController
@Log4j
@RequestMapping("/university")
public class CollegeIntroductionController {

  private @Autowired UniversityInfoService universityService;
  private @Autowired MajorsInfoService majorsService;
  private @Autowired ScoreHistoryService scoreService;
  private @Autowired ScoreSegmentService scoreSegService;
  private @Autowired EnrollInfoService enrollService;
  private @Autowired EnrollHistoryService enrollHistoryService;

  /**
   * 得到所有大学信息
   * 
   * @return
   */
  @GetMapping("/all_university")
  public ResponseData<Object> getAll() {
    List<UniversityInfoBean> results = universityService.getAllUniversityInfo();
    if (null == results) {
      return ResponseData.failed("系统错误");
    } else {
      return ResponseData.success(results);
    }
  }

  /**
   * 得到所有大学列表
   */
  @GetMapping("/u_list")
  public ResponseData<Object> getList() {
    List<UniversityListBean> results = universityService.getUniversityList();
    if (null == results) {
      return ResponseData.failed("系统错误");
    } else {
      return ResponseData.success(results);
    }
  }

  /**
   * 通过大学id获得该大学所有信息
   * 
   * @param id
   * @return
   */
  @GetMapping("/specific_university/{id}")
  public ResponseData<Object> getAllInfoByID(@PathVariable Integer id) {
    log.info(id);
    ResponseData<Object> results = universityService.getInfoWithUniversityID(id);
    log.info(results);
    return results;
  }

  /**
   * 得到所有专业信息
   * 
   * @return
   */
  @GetMapping("/all_majors")
  public ResponseData<Object> getAllMajors() {
    List<ViewMajorsInfoBean> results = majorsService.getAllMajors();
    if (null == results) {
      return ResponseData.failed("系统错误");
    } else {
      return ResponseData.success(results);
    }
  }

  /**
   * 得到所有学科门类列表
   * 
   * @return
   */
  @GetMapping("/sublist")
  public ResponseData<Object> getSubList() {
    List<SubCategoryListBean> results = majorsService.getSubList();
    if (null == results) {
      return ResponseData.failed("系统错误");
    } else {
      return ResponseData.success(results);
    }
  }

  /**
   * 通过学科门类code得到专业类别列表
   * 
   * @param code
   * @return
   */
  @GetMapping("/cateList/{subcode}")
  public ResponseData<Object> getSubList(@PathVariable Short subcode) {
    ResponseData<Object> results = majorsService.getCateListByID(subcode);
    return results;
  }

  /**
   * 通过学科门类、专业类别得到专业列表
   */
  @GetMapping("/majorsList/{subCode}/{mCateCode}")
  public ResponseData<Object> getMajorList(@PathVariable Short subCode,@PathVariable Short mCateCode)
  {
    ResponseData<Object> results = majorsService.getMajorsListByID(subCode, mCateCode);
    return results;
  }

  /**
   * 通过学科门类、专业类别、专业id得到特定专业
   * 
   * @param subcode
   * @param mCateCode
   * @param mCode
   * @return
   */
  @GetMapping("/an_major/{subcode}/{mCateCode}/{mCode}")
  public ResponseData<Object> getSubList(@PathVariable Short subcode, @PathVariable Short mCateCode,
      @PathVariable String mCode) {
    ResponseData<Object> results = majorsService.getAnMajor(subcode, mCateCode, mCode);
    return results;
  }

  /**
   * 得到所有省份的历年分数线
   */
  @GetMapping("/all_score_history")
  public ResponseData<Object> getAllScoreHistory() {
    List<ScoreHistoryBean> results = scoreService.getAll();
    if (null == results) {
      return ResponseData.failed("系统错误！");
    } else {
      return ResponseData.success(results);
    }
  }

  /**
   * 得到指定省份的历年分数线
   */
  @GetMapping("/an_province_score/{pNo}")
  public ResponseData<Object> getAnProvince(@PathVariable String pNo) {
    ResponseData<Object> results = scoreService.getAnProvince(pNo);
    return results;
  }

  /**
   * 得到所有省份的历年分数段情况
   */
  @GetMapping("/all_score_seg")
  public ResponseData<Object> getAllScoreSeg() {
    List<ScoreSegmentBean> results = scoreSegService.getAll();
    if(null == results)
    {
      return ResponseData.failed("系统错误！");
    }
    else
    {
      return ResponseData.success(results);
    }
  } 

  /**
   * 得到指定省份的历年分数段
   */
  @GetMapping("/an_province_seg/{pNo}")
  public ResponseData<Object> getAnProvinceSeg(@PathVariable String pNo)
  {
    ResponseData<Object> results = scoreSegService.getAnProvinceSeg(pNo);
    return results;
  }

  /**
   * 得到所有的录取信息
   * @return
   */
  @GetMapping("/all_enroll")
  public ResponseData<Object> getAllEnrollInfo()
  {
    List<ViewEnrollInfoBean> results = enrollService.getAll();
    if(null == results)
    {
      return ResponseData.failed("系统错误！");
    }
    else
    {
      return ResponseData.success(results);
    }
  }

  /**
   * 查这个省份各个学校的录取信息
   * @param pNo
   * @return
   */
  @GetMapping("/enroll_pno/{pNo}")
  public ResponseData<Object> getAnProvEnroll(@PathVariable String pNo)
  {
    ResponseData<Object> results = enrollService.getAnProvinceEnroll(pNo);
    return results;
  }

  /**
   * 查这个高校的录取信息
   * @param id
   * @return
   */
  @GetMapping("/enroll_id/{id}")
  public ResponseData<Object> getAnUniEnroll(@PathVariable Integer id)
  {
    ResponseData<Object> results = enrollService.getAnUniEnroll(id);
    return results;
  }

  /**
   * 查这个高校在这个省份的录取信息
   * @param id
   * @param pNo
   * @return
   */
  @GetMapping("/specific_enroll/{id}/{pNo}")
  public ResponseData<Object> getAnEnroll(@PathVariable Integer id,@PathVariable String pNo)
  {
    ResponseData<Object> results = enrollService.getAnEnrollInfo(pNo, id);
    return results;
  }

  /**
   * 获得所有的历史招生计划
   * @return
   */
  @GetMapping("/all_enroll_history")
  public ResponseData<Object> getAllEnroll()
  {
    List<ViewEnrollHistoryBean> results = enrollHistoryService.getAll();
    if(null == results)
    {
      return ResponseData.failed("系统错误！");
    }
    else
    {
      return ResponseData.success(results);
    }
  }

  /**
   * 得到省份的所有大学招生计划
   * @param pNo
   * @return
   */
  @GetMapping("/province_enroll_history/{pNo}")
  public ResponseData<Object> getProvinceEnroll(@PathVariable String pNo)
  {
    ResponseData<Object> results = enrollHistoryService.getProvinceEnroll(pNo);
    return results;
  }

  /**
   * 得到大学的招生计划
   * @param id
   * @return
   */
  @GetMapping("/u_enroll_history/{id}")
  public ResponseData<Object> getUniversityEnroll(@PathVariable Integer id)
  {
    ResponseData<Object> results = enrollHistoryService.getUniversityEnroll(id);
    return results;
  }

  /**
   * 根据大学id和省份id找到的招生计划
   * @param id
   * @param pNo
   * @return
   */
  @GetMapping("/specific_enroll_history/{pNo}/{id}")
  public ResponseData<Object> getUniversityEnroll(@PathVariable Integer id,@PathVariable String pNo)
  {
    ResponseData<Object> results = enrollHistoryService.getSpecificEnroll(pNo, id);
    return results;
  }

  /**
   * 根据省份id和专业id找到的招生计划
   * @param mCode
   * @param pNo
   * @return
   */
  @GetMapping("/major_enroll_history/{pNo}/{mCode}")
  public ResponseData<Object> getMajorEnroll(@PathVariable String mCode,@PathVariable String pNo)
  {
    ResponseData<Object> results = enrollHistoryService.getMajorEnroll(pNo, mCode);
    return results;
  }
}
