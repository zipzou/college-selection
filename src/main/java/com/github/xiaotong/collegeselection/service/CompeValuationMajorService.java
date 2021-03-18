package com.github.xiaotong.collegeselection.service;

import java.util.List;

import com.github.xiaotong.collegeselection.body.ResponseData;
import com.github.xiaotong.collegeselection.dao.bean.ViewCompeMajorBean;
import com.github.xiaotong.collegeselection.dao.mapper.ViewCompeMajorDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 综合测评专业
 */
@Service
public class CompeValuationMajorService {
    private @Autowired ViewCompeMajorDao dao;
    
    /**
     * 根据id得到该学校的综合测评专业
     */
    public ResponseData<Object> getMajorsByID(Integer id) {
        List<ViewCompeMajorBean> results = dao.getMajor(id);
        if(results.isEmpty())
        {
            return ResponseData.successF("错误的学校ID");
        }
        else
        {
            return ResponseData.success(results);
        }
    }
}
