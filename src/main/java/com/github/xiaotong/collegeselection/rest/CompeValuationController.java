package com.github.xiaotong.collegeselection.rest;

import java.util.List;

import com.github.xiaotong.collegeselection.body.ResponseData;
import com.github.xiaotong.collegeselection.dao.bean.UListBean;
import com.github.xiaotong.collegeselection.dao.bean.ViewCompeValuationBean;
import com.github.xiaotong.collegeselection.service.CompeValuationMajorService;
import com.github.xiaotong.collegeselection.service.CompeValuationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

/**
 * 综合测评
 */
@RestController
@Log4j
@RequestMapping("/comp")
public class CompeValuationController {
    private @Autowired CompeValuationService compeService;
    private @Autowired CompeValuationMajorService compeMajor;
    /**
     * 得到所有的综合测评
     * @return
     */
    @GetMapping("/all_comp")
    public ResponseData<Object> getAll() {
        List<ViewCompeValuationBean> results = compeService.getAll();
        if (null == results) {
            return ResponseData.failed("系统错误");
        } else {
            return ResponseData.success(results);
        }
    }

    /**
     * 得到综合测评学校列表
     * @return
     */
    @GetMapping("/university")
    public ResponseData<Object> getUniversityList() {
        List<UListBean> results = compeService.getCompUniversityList();
        if (null != results) {
        return ResponseData.success(results);
        } else {
        return ResponseData.failed("系统错误");
        }
    }

    /**
     * 通过id得到具体学校综合测评内容
     * @return
     */
    @GetMapping("/AnCompUniversity/{id}")  
    public ResponseData<Object> getStrenthByID(@PathVariable Integer id) {
        log.info(id);
        ResponseData<Object> results = compeService.getCompByID(id);
        log.info(results);
        return results;
    }

    /**
     * 通过id得到具体学校综合测评专业
     * @param id
     * @return
     */
    @GetMapping("/majors/{id}")  
    public ResponseData<Object> getCompeMajors(@PathVariable Integer id) {
        log.info(id);
        ResponseData<Object> results = compeMajor.getMajorsByID(id);
        log.info(results);
        return results;
    }
}
