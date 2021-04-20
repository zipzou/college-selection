package com.github.xiaotong.collegeselection.dao.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 视频收藏
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CollectionVideoBean {
    private Long userNo;
    private Integer videoID; 
    private String videoTitle;
}
