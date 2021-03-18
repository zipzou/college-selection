package com.github.xiaotong.collegeselection.dao.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.MajorsHotBean;
import com.github.xiaotong.collegeselection.dao.bean.MajorsInfoBean;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;

/**
 * 专业信息
 */
public interface MajorsInfoDao {
    @Select("select * from majors_info;")
    @Results(id = "majors",value = 
        {
            @Result(column = "major_year", property = "majorYear"),
            @Result(column = "major_code", property = "majorCode"),
            @Result(column = "major_category", property = "majorCategory"),
            @Result(column = "major_name", property = "majorName"),
            @Result(column = "major_memo", property = "majorMemo"),
            @Result(column = "click_rate", property = "clickRate")
        }
    )
    public List<MajorsInfoBean> selectAll();

    //查询这个mcode是否存在
    @Select("select * from majors_info where major_code = #{majorCode};")
    @ResultMap(value = "majors")
    public MajorsInfoBean getMajorByCode(@Param("majorCode") String majorCode);
    
    //更新clickRate
    @Update("update majors_info set click_rate = click_rate + 1 where major_code = #{majorCode};")
    public void updateRate(@Param("majorCode") String majorCode);

    /**
     * 专业热榜
     * @return
     */
    @Select("select major_code,major_name,click_rate from majors_info where click_rate > 0 order by click_rate desc limit 10;")
    @Results( 
        {
            @Result(column = "major_code", property = "majorCode"),
            @Result(column = "major_name", property = "majorName"),
            @Result(column = "click_rate", property = "clickRate")
        }
    )
    public List<MajorsHotBean> getMajorsHot();
}
