package com.github.xiaotong.collegeselection.service;

import java.util.List;

import com.github.xiaotong.collegeselection.body.ResponseData;
import com.github.xiaotong.collegeselection.dao.bean.ScoreHistoryBean;
import com.github.xiaotong.collegeselection.dao.mapper.ScoreHistoryDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 历年各省分数线
 */
@Service
public class ScoreHistoryService {
    private @Autowired ScoreHistoryDao dao;

    /**
     * 得到全部省份历年分数线
     * @return
     */
    public List<ScoreHistoryBean> getAll() {
        return dao.selectAll();
    } 

    /**
     * 得到特定省份的历年分数线
     */
    public ResponseData<Object> getAnProvince(String pNo) {
        List<ScoreHistoryBean> results = dao.getInfoByNo(pNo);
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
