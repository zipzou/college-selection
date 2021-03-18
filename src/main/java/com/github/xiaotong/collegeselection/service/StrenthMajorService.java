package com.github.xiaotong.collegeselection.service;

import java.util.List;

import com.github.xiaotong.collegeselection.body.ResponseData;
import com.github.xiaotong.collegeselection.dao.bean.ViewBasicMajorBean;
import com.github.xiaotong.collegeselection.dao.mapper.ViewBasicMajorDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 强基计划专业
 */
@Service
public class StrenthMajorService {
    private @Autowired ViewBasicMajorDao dao;

    /**
     * 根据id得到该学校的强基计划专业
     */
    public ResponseData<Object> getMajorsByID(Integer id) {
        List<ViewBasicMajorBean> results = dao.getMajor(id);
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
