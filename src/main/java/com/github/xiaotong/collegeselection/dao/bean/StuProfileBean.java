package com.github.xiaotong.collegeselection.dao.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 考生偏好
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class StuProfileBean {
    private Integer reportID;
    private String stuNo;
    private Date hollandTestTime;
    private short hollandScore;
    private Date mbtiTestTime;
    private short mbtiScore;
}
