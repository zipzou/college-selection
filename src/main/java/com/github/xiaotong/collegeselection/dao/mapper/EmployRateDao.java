package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.EmployRateBean;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

// @Mapper
/**
 * 就业率
 */
public interface EmployRateDao {
    /**
     * 
     * @return
     */
    @Select("select * from employrate;")
    @Results(
        {
            @Result(column = "Majorcode", property = "majorCode"),
            @Result(column = "universityID", property = "universityId"),
            @Result(column = "years", property = "years"),
            @Result(column = "Onetimeemprate", property = "oneTimeEmprate")
        }
    )
    public List<EmployRateBean> selectAll();
}
