package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 专业收藏 
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CollectionMajorBean {
    private String majorCode;
    private Long userNo;
    private String mName;
}
