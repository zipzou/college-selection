package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.VIPCardBean;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 会员卡信息
 */
public interface VIPCardDao {
    @Select("select * from vip_card;")
    @Results(
        {
            @Result(column = "card_no", property = "cardNo"),
            @Result(column = "card_name", property = "cardName")
        }
    )
    public List<VIPCardBean> selectAll();
}
