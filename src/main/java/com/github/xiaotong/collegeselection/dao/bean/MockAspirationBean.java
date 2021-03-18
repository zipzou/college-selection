package com.github.xiaotong.collegeselection.dao.bean;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 模拟志愿
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MockAspirationBean {
    private Integer universityID;
    private String stuNo;
    private Date examTime;
    private BigDecimal firstRate;
    private BigDecimal secondRate;
    private BigDecimal specialRate;
}
