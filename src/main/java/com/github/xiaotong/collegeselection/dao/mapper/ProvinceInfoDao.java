package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.ProvinceInfoBean;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 省份信息
 */

public interface ProvinceInfoDao {
    @Select("select * from province_info;")
    @Results(
        {
            @Result(column = "province_no", property = "provinceNo"),
            @Result(column = "region", property = "region"),
            @Result(column = "province_name", property = "provinceName")
        }
    )
    public List<ProvinceInfoBean> selectAll();
}
