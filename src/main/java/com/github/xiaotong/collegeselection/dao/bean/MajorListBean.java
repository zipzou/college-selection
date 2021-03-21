package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 专业列表
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MajorListBean {
    private String majorCode;
    private String majorName;
}
