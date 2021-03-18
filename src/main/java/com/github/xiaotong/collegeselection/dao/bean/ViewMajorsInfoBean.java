package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 专业介绍视图
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ViewMajorsInfoBean {
    private short mYear;
    private String mCode;
    private short mCategoryCode;
    private String mCategoryName;
    private String mName;
    private String mMemo;
    private String mRequ;
    private String subName;
    private short subCode;

}
