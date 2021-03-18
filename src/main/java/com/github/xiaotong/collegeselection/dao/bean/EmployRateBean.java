package com.github.xiaotong.collegeselection.dao.bean;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 就业率
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployRateBean {
    private String majorCode;
    private String universityId;
    private Integer years;
    private BigDecimal onetimeEmprate;
}
