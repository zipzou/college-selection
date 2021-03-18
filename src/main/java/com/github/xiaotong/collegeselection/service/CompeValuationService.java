package com.github.xiaotong.collegeselection.service;

import java.util.List;

import com.github.xiaotong.collegeselection.body.ResponseData;
import com.github.xiaotong.collegeselection.dao.bean.UListBean;
import com.github.xiaotong.collegeselection.dao.bean.ViewCompeValuationBean;
import com.github.xiaotong.collegeselection.dao.mapper.ViewCompeValuationDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 综合测评
 */
@Service
public class CompeValuationService {
    private @Autowired ViewCompeValuationDao dao;
    
    /**
     * 得到所有的综合测评
     * @return
     */
    public List<ViewCompeValuationBean> getAll()
    {
        List<ViewCompeValuationBean> results = dao.selectAll();
        return results;
    }

    /**
     * 综合测评大学列表
     */
    public List<UListBean> getCompUniversityList()
    {
        List<UListBean> results = dao.getCompUniversityList();
        return results;
    }

    /**
     * 得到具体学校id的强基计划
     * @param id
     * @return
     */
    public ResponseData<Object> getCompByID(Integer id)
    {
        ViewCompeValuationBean results = dao.getCompByID(id);
        if(null == results)
        {
            return ResponseData.successF("错误的学校id！");
        }
        else
        {
            return ResponseData.success(results);
        }
    }
}
