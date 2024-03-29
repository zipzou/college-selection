package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 历年录取情况
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class EnrollInfoBean {
    private String provinceNo;
    private Short years;
    private Integer universityID;
    private String planCategory;
    private Short numbers;
    private Integer minScore;
    private Integer avgScore;
    private Long avgRanking;
    private Long minRanking;
}
