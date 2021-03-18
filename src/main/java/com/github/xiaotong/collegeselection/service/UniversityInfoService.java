package com.github.xiaotong.collegeselection.service;

import java.util.List;

import com.github.xiaotong.collegeselection.body.ResponseData;
import com.github.xiaotong.collegeselection.dao.bean.UniversityHotBean;
import com.github.xiaotong.collegeselection.dao.bean.UniversityInfoBean;
import com.github.xiaotong.collegeselection.dao.bean.UniversityListBean;
import com.github.xiaotong.collegeselection.dao.mapper.UniversityInfoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 高校介绍
 */
@Service
public class UniversityInfoService {
    private @Autowired UniversityInfoDao dao;

     /**
     * 所有高校信息
     */
    public List<UniversityInfoBean> getAllUniversityInfo() {
        return dao.selectAll();
    }
    
    /**
     * 高校列表
     */
     public List<UniversityListBean> getUniversityList() {
        return dao.getUniversityList();
    } 

    /**
     * 通过id获取高校所有信息
     */

    public ResponseData<Object> getInfoWithUniversityID(Integer id){
        UniversityInfoBean results = dao.selectAllByID(id);
        if(null == results){
            return ResponseData.successF("高校id: "+id+"不存在！");
        }else{
            return ResponseData.success(results);
        }
    }

    /**
     * 更新点击率
     */
    public ResponseData<Object> updateRate(Integer id){
        if(null != dao.selectAllByID(id))
        {
            dao.updateRate(id);
            return ResponseData.successMes("成功增加"+id+"的概率！");
        }
        else
        {
            return ResponseData.successF("学校id："+id+"不存在！");
        }
    }

    /**
     * 高校热榜
     * @return
     */
    public List<UniversityHotBean> getUniversityHot(){
        List<UniversityHotBean> results = dao.getHotUniversity();
        return results;
    }
}
