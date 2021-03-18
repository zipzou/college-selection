package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.RecProfessionBean;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 职业类型推荐专业
 */
public interface RecProfessionDao {
    @Select("select * from rec_profession;")
    @Results(
        {
            @Result(column = "jobs_type", property = "jobsType"),
            @Result(column = "recomm_major", property = "recommMajor")
        }
    )
    public List<RecProfessionBean> selectAll();
}
