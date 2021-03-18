package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 职业类型推荐专业
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class RecProfessionBean {
    private Integer jobsType;
    private String recommMajor;
}
