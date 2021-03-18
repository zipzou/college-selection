package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 历年招生计划
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class EnrollPlanHistoryBean {
    private String provinceNo;
    private Integer universityID;
    private String majorCode;
    private Short years;
    private String batchNo;
    private String planCategory;
    private String family;
    private Short planNum;
    private Short tuitionfee;
    private String schoolSystem;
    private String memo;
}
