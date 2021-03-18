package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 会员卡信息
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class VIPCardBean {
    private String cardNo;
    private String cardName;
}
