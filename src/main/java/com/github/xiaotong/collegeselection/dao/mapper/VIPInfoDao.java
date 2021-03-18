package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.VIPInfoBean;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 会员信息
 */
public interface VIPInfoDao {
    @Select("select * from vip_info;")
    @Results(
        {
            @Result(column = "card_no", property = "cardNo"),
            @Result(column = "user_no", property = "userNo"),
            @Result(column = "vip_start", property = "vipStart"),
            @Result(column = "vip_time", property = "vipTime")
        }
    )
    public List<VIPInfoBean> selectAll();
}
