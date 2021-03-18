package com.github.xiaotong.collegeselection.service;

import java.util.List;

import com.github.xiaotong.collegeselection.body.ResponseData;
import com.github.xiaotong.collegeselection.dao.bean.UListBean;
import com.github.xiaotong.collegeselection.dao.bean.ViewStrenthBean;
import com.github.xiaotong.collegeselection.dao.mapper.ViewStrenthDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 强基计划
 */
@Service
public class StrenthDisciplineService {

    private @Autowired ViewStrenthDao dao;

    /**
     * 得到所有的信息
     */
    public List<ViewStrenthBean> getAllDiscipline() {
        return dao.selectAll();
    }

    /**
     * 查到高校列表
     */
    public List<UListBean> getAllUniversityList(){
        return dao.getStrUniversityList();
    }

    /**
     * 通过高校id查询具体高校强基计划
     * @param id
     * @return
     */
    public ResponseData<Object> getDiscipliineWithUniversityID(Integer id) {
        ViewStrenthBean result = dao.getStrenthByID(id);
        if (null == result) {
            return ResponseData.successF("错误的学校ID");
        } else {
            return ResponseData.success(result);
        }
    }
}