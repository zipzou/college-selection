package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.EnrollInfoBean;
import com.github.xiaotong.collegeselection.dao.bean.RankingBean;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 历年录取情况
 */
public interface EnrollInfoDao {
    @Select("select * from enroll_info;")
    @Results(
        {
            @Result(column = "province_no", property = "provinceNo"),
            @Result(column = "years", property = "years"),
            @Result(column = "university_id", property = "universityID"),
            @Result(column = "plan_category", property = "planCategory"),
            @Result(column = "numbers", property = "numbers"),
            @Result(column = "min_score", property = "minScore"),
            @Result(column = "avg_score", property = "avgScore"),
            @Result(column = "avg_ranking", property = "avgRanking"),
            @Result(column = "min_ranking", property = "minRanking")
        }
    )
    public List<EnrollInfoBean> selectAll();

    /**
     * 得到指定年份指定大学和省份的平均和最低录取名次
     * @param years
     * @param pNo
     * @return
     */
    @Select("select avg_ranking,min_ranking from enroll_info where years = #{years} and province_no = #{pNo} and university_id = #{uID} and plan_category = #{p} ORDER BY avg_ranking ASC LIMIT 1;")
    @Results({
        @Result(column = "avg_ranking", property = "avgRanking"),
        @Result(column = "min_ranking", property = "minRanking")
    })
    public RankingBean getRanking(@Param("years")Short years,@Param("pNo")String pNo,@Param("uID") Integer uID,@Param("p")String p);

    /**
     * 得到大学列表
     * @param pNo
     * @return
     */
    @Select("select distinct university_id from enroll_info where province_no = #{pNo};")
    public List<Integer> getUniversityList(@Param("pNo")String pNo);
}
