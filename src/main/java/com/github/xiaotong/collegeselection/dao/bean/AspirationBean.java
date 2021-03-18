package com.github.xiaotong.collegeselection.dao.bean;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
*高考志愿
*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AspirationBean {
    private Integer universityID;
    private String majorCode;
    private String stuNo;
    private BigDecimal admissionRate;
}
