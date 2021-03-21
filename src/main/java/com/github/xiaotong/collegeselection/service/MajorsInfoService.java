package com.github.xiaotong.collegeselection.service;

import java.util.List;

import com.github.xiaotong.collegeselection.body.ResponseData;
import com.github.xiaotong.collegeselection.dao.bean.CategoryListBean;
import com.github.xiaotong.collegeselection.dao.bean.MajorListBean;
import com.github.xiaotong.collegeselection.dao.bean.MajorsHotBean;
import com.github.xiaotong.collegeselection.dao.bean.SubCategoryListBean;
import com.github.xiaotong.collegeselection.dao.bean.ViewMajorsInfoBean;
import com.github.xiaotong.collegeselection.dao.mapper.MajorsInfoDao;
import com.github.xiaotong.collegeselection.dao.mapper.ViewMajorsInfoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 专业介绍
 */
@Service
public class MajorsInfoService {
    private @Autowired ViewMajorsInfoDao dao;
    private @Autowired MajorsInfoDao majorsDao;
    /**
     * 得到所有的信息
     */
    public List<ViewMajorsInfoBean> getAllMajors() {
        return dao.getAll();
    }

    /**
     * 得到学科门类列表
     */
    public List<SubCategoryListBean> getSubList() {
        return dao.getSubList();
    }

    /**
     * 通过学科门类id得到专业类别列表
     * @param code
     * @return
     */
    public ResponseData<Object> getCateListByID(Short code) {
        List<CategoryListBean> results = dao.getCategoryListByID(code);
        if(results.isEmpty()){
            return ResponseData.successF("学科门类id："+code+"错误！");
        } else{
            return ResponseData.success(results);
        }
    }

    /**
     * 通过学科门类id、专业类别id得到专业列表
     * @param subCode
     * @param mCateCode
     * @return
     */
    public ResponseData<Object> getMajorsListByID(Short subCode,Short mCateCode) {
        List<MajorListBean> results = dao.getMajorList(subCode, mCateCode);
        if(results.isEmpty()){
            return ResponseData.successF("学科门类id："+subCode+"专业类别id："+mCateCode+"错误！");
        } else{
            return ResponseData.success(results);
        }
    }

    /**
     * 通过学科门类id、专业类别id、专业code得到具体专业
     * @param code
     * @return
     */
    public ResponseData<Object> getAnMajor(Short subCode,Short mCateCode,String mCode) {
        ViewMajorsInfoBean results = dao.getAnMajor(subCode, mCateCode, mCode);
        if(null == results){
            return ResponseData.successF("专业代码："+mCode+"错误！");
        } else{
            return ResponseData.success(results);
        }
    }

    //更新点击率
    public ResponseData<Object> updateRate(String mCode)
    {
        if(null != majorsDao.getMajorByCode(mCode))
        {
            majorsDao.updateRate(mCode);
            return ResponseData.successMes("成功添加专业："+mCode+"的概率！");
        }
        else{
            return ResponseData.successF("该专业id："+mCode+"不存在！");
        }
    }

    /**
     * 得到专业热榜
     * @return
     */
    public List<MajorsHotBean> getMajorsHot(){
        List<MajorsHotBean> results = majorsDao.getMajorsHot();
        return results;
    }
}
