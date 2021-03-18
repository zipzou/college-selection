package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 强基计划、综合测评高校列表
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UListBean {
    private Integer universityID;
    private String universityName;
    private String logo;
    private String provinceNo;
}
