package com.github.xiaotong.collegeselection.service;

import com.github.xiaotong.collegeselection.body.ResponseData;
import com.github.xiaotong.collegeselection.dao.bean.UserInfoBean;
import com.github.xiaotong.collegeselection.dao.mapper.UserInfoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户登录
 */
@Service
public class UserService {
    private @Autowired UserInfoDao dao;

    /**
     * 插入新用户
     * @param nickname
     * @return
     */
    public ResponseData<Object> InsertUser(String nickname) {
        dao.insertUser(nickname);
        UserInfoBean results = dao.getAnUserByName(nickname);
        if(null == results)
        {
            return ResponseData.successF("插入新用户失败！");
        }
        else{
            return ResponseData.success("插入成功！");
        }
    }
}
