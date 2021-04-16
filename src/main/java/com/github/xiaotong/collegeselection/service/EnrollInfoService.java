package com.github.xiaotong.collegeselection.service;

import java.util.List;

import com.github.xiaotong.collegeselection.body.ResponseData;
import com.github.xiaotong.collegeselection.dao.bean.ViewEnrollInfoBean;
import com.github.xiaotong.collegeselection.dao.mapper.ViewEnrollInfoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.ToString;
import lombok.extern.log4j.Log4j;

/**
 * 历年录取情况
 */
@Service
@Log4j
@ToString
public class EnrollInfoService {
    private @Autowired ViewEnrollInfoDao dao;
    
    /**
     * 得到所有的录取信息
     * @return
     */
    public List<ViewEnrollInfoBean> getAll()
    {
        List<ViewEnrollInfoBean> results = dao.selectAll();
        return results;
    }

    /**
     * 查这个省份各个学校的录取信息
     * @param pNo
     * @return
     */
    public ResponseData<Object> getAnProvinceEnroll(String pNo) {
        log.info(pNo);
        List<ViewEnrollInfoBean> results = dao.getAnProvince(pNo);
        log.info(results);
        if(results.isEmpty()){
            return ResponseData.successF("省份编号："+pNo+"错误！");
        } else{
            return ResponseData.success(results);
        }
    } 

    /**
     * 查这个高校的录取信息
     * @param id
     * @return
     */
    public ResponseData<Object> getAnUniEnroll(Integer id) {
        List<ViewEnrollInfoBean> results = dao.getAnUniversity(id);
        if(results.isEmpty()){
            return ResponseData.successF("学校id："+id+"错误！");
        } else{
            return ResponseData.success(results);
        }
    } 

    /**
     * 查这个高校在这个省份的录取信息
     * @param pNo
     * @param id
     * @return
     */
    public ResponseData<Object> getAnEnrollInfo(String pNo,Integer id) {
        List<ViewEnrollInfoBean> results = dao.getAnEnrollInfo(id, pNo);
        if(results.isEmpty()){
            return ResponseData.successF("学校id："+id+"和省份id："+pNo+"联合查不出来，请检查这两个是否有错误！");
        } else{
            return ResponseData.success(results);
        }
    }
    
}
