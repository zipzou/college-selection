package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 强基计划专业视图
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ViewBasicMajorBean {
    private Integer id;
    private String uCode;
    private String mCode;
    private String uName;
    private String mName;
    private String introduce;
}
