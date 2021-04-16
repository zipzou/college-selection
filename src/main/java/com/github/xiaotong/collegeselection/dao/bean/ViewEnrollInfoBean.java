package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 历年录取情况视图
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ViewEnrollInfoBean {
    private String provinceNo;
    private String provinceName;
    private Short years;
    private Integer universityID;
    private String universityName;
    private String planCategory;
    private Short numbers;
    private Integer minScore;
    private Integer avgScore;
    private Long avgRanking;
    private Long minRanking;
}
