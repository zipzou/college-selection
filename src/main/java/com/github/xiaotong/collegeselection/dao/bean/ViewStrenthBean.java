package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 强基计划的视图
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ViewStrenthBean {
    private Integer uID;
    private String uName;
    private String enrollType;
    private String guides;
    private String qualifications;
    private String timeTable;
    private String url;
    private String tel;
    private String logo;
}
