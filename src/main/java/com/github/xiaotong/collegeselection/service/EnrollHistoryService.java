package com.github.xiaotong.collegeselection.service;

import java.util.List;

import com.github.xiaotong.collegeselection.body.ResponseData;
import com.github.xiaotong.collegeselection.dao.bean.ViewEnrollHistoryBean;
import com.github.xiaotong.collegeselection.dao.mapper.ViewEnrollHistoryDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 历年招生计划
 */
@Service
public class EnrollHistoryService {
    private @Autowired ViewEnrollHistoryDao dao;
    
    /**
     * 得到所有信息
     * @return
     */
    public List<ViewEnrollHistoryBean> getAll()
    {
        return dao.selectAll();
    }
    
    /**
     * 得到省份的所有大学招生计划
     * @param pNo
     * @return
     */
    public ResponseData<Object> getProvinceEnroll(String pNo)
    {
        List<ViewEnrollHistoryBean> results = dao.getProvinceEnroll(pNo);
        if(results.isEmpty()){
            return ResponseData.successF("省份id："+pNo+"错误！");
        }else{
            return ResponseData.success(results);
        }
    }

    /**
     * 得到大学的招生计划
     * @param id
     * @return
     */
    public ResponseData<Object> getUniversityEnroll(Integer id)
    {
        List<ViewEnrollHistoryBean> results = dao.getUniversityEnroll(id);
        if(results.isEmpty()){
            return ResponseData.successF("学校id："+id+"错误！");
        }else{
            return ResponseData.success(results);
        }
    }

    /**
     * 根据大学id和省份id找到的招生计划
     * @param pNo
     * @param id
     * @return
     */
    public ResponseData<Object> getSpecificEnroll(String pNo,Integer id)
    {
        List<ViewEnrollHistoryBean> results = dao.getSpecificEnroll(id, pNo);
        if(results.isEmpty()){
            return ResponseData.successF("学校id："+id+"和省份id："+pNo+"组合查询不出结果！");
        }else{
            return ResponseData.success(results);
        }
    }

    /**
     * 根据省份id和专业id找到的招生计划
     * @param pNo
     * @param mCode
     * @return
     */
    public ResponseData<Object> getMajorEnroll(String pNo,String mCode)
    {
        List<ViewEnrollHistoryBean> results = dao.getMajorEnroll(pNo, mCode);
        if(results.isEmpty()){
            return ResponseData.successF("专业id："+mCode+"和省份id："+pNo+"组合查询不出结果！");
        }else{
            return ResponseData.success(results);
        }
    }
}
