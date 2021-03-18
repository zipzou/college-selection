package com.github.xiaotong.collegeselection.service;

import java.util.List;

import com.github.xiaotong.collegeselection.body.ResponseData;
import com.github.xiaotong.collegeselection.dao.bean.ScoreSegmentBean;
import com.github.xiaotong.collegeselection.dao.mapper.ScoreSegmentDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 历年各省分数段
 */
@Service
public class ScoreSegmentService {
    private @Autowired ScoreSegmentDao dao;

    /**
     * 得到所有的信息
     */
    public List<ScoreSegmentBean> getAll() {
        return dao.selectAll();
    }

    /**
     * 得到特定省份的历年分数线
     */
    public ResponseData<Object> getAnProvinceSeg(String pNo) {
        List<ScoreSegmentBean> results = dao.getAnProvinceSeg(pNo);
        if(results.isEmpty())
        {
            return ResponseData.successF("省份id:"+pNo+"错误！");
        }
        else
        {
            return ResponseData.success(results);
        }
    } 
}
