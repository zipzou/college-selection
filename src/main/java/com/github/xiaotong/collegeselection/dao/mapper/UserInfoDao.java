package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.UserInfoBean;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 用户信息
 */
public interface UserInfoDao {
    @Select("select * from user_info;")
    @Results(id = "user",value = 
        {
            @Result(column = "user_no", property = "userNo"),
            @Result(column = "if_vip", property = "ifVIP"),
            @Result(column = "nickname", property = "nickName")
        }
    )
    public List<UserInfoBean> selectAll();

    /**
     * 得到具体的用户信息
     * @param userNo
     * @return
     */
    @Select("select * from user_info where user_no = #{userNo};")
    @ResultMap(value = "user")
    public List<UserInfoBean> getAnUser(@Param("userNo") String userNo);
}
