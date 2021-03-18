package com.github.xiaotong.collegeselection.dao.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 会员信息
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class VIPInfoBean {
    private String cardNo;
    private String userNo;
    private Date vipStart;
    private Date vipTime;
}
