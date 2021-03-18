package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 省份信息
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProvinceInfoBean {
    private String provinceNo;
    private String region;
    private String provinceName;
}
