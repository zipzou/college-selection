package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 讲座信息
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class LectureInfoBean {
    private Integer lecID;
    private String lecTitile;
    private String lecLabel;
    private String lecFilePath;
    private String lecUrl;
}
