package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 专业信息
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MajorsInfoBean {
    private short majorYear;
    private Long clickRate;
    private String majorCode;
    private short majorCategory;
    private String majorName;
    private String majorMemo;
}
