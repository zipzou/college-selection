package com.github.xiaotong.collegeselection.dao.mapper;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.CollectionReportBean;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;

/**
 * 我的志愿填报
 */
public interface CollectionReportDao {
    /**
     * 得到指定的用户指定标志类大学录取概率
     */
    @Select("select user_no,c.university_id,ranking,mark,u.university_name from collection_report as c,university_info as u where user_no = #{userNo} and c.university_id = u.university_id and mark = #{mark};")
    @Results(id = "report",value = 
        {
            @Result(column = "user_no", property = "userNo"),
            @Result(column = "university_id", property = "uID"),
            @Result(column = "ranking", property = "ranking"),
            @Result(column = "mark", property = "mark"),
            @Result(column = "university_name", property = "uName")
        }
    )
    public List<CollectionReportBean> getReportCollection(@Param("userNo") String userNo,@Param("mark") String mark);

    /**
     * 得到具体大学的录取概率
     * @param userNo
     * @param uID
     * @return
     */
    @Select("select user_no,c.university_id,ranking,mark,u.university_name from collection_report as c,university_info as u where user_no = #{userNo} and c.university_id = u.university_id and university_id = #{uID};")
    @ResultMap(value = "report")
    public CollectionReportBean getAnUniversityRank(@Param("userNo") String userNo,@Param("uID")Integer uID);

    /**
     * 插入大学录取概率
     * @param userNo
     * @param uID
     * @param ranking
     * @param mark
     */
    @Insert("INSERT into collection_report(user_no,university_id,ranking,mark) VALUES(#{userNo},#{uID},#{ranking},#{mark});")
    public void insertReportCollect(@Param("userNo") String userNo,@Param("uID") Integer uID,@Param("ranking")Double ranking,@Param("mark")String mark);

    /**
     * 判断数据库里是否已经存在该用户的数据
     * @param userNo
     */
    @Select("select user_no from collection_report where user_no = #{userNo} limit 1;")
    public String CheckUserReport(@Param("userNo")String userNo);
}
