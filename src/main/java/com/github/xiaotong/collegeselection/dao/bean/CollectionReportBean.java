package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
/**
 * 我的志愿填报
 */
public class CollectionReportBean {
    private Long userNo;
    private Integer uID;
    private String uName;
    private Double ranking;
    private String mark;
}
