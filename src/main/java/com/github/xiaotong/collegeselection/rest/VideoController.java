package com.github.xiaotong.collegeselection.rest;

import java.util.List;

import com.github.xiaotong.collegeselection.body.ResponseData;
import com.github.xiaotong.collegeselection.dao.bean.VideoListBean;
import com.github.xiaotong.collegeselection.dao.bean.VideosInfoBean;
import com.github.xiaotong.collegeselection.service.VideoInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 宣讲视频
 */
@RestController
@RequestMapping("/video")
public class VideoController {
    private @Autowired VideoInfoService videoService;

    /**
     * 获得所有视频
     */
    @GetMapping("/all_video")
    public ResponseData<Object> getAll(){
        List<VideosInfoBean> results = videoService.getAll();
        if (null != results) {
            return ResponseData.success(results);
        } else {
            return ResponseData.failed("系统错误");
        }
    }

    /**
     * 获得视频列表
     * @return
     */
    @GetMapping("/video_list")
    public ResponseData<Object> getVideoList() {
        List<VideoListBean> results = videoService.getVideoList();
        if (null != results) {
            return ResponseData.success(results);
        } else {
            return ResponseData.failed("系统错误");
        }
    }
    
    /**
     * 通过标签来获得视频列表
     * @param label
     * @return
     */
    @GetMapping("/video_by_label/{label}")
    public ResponseData<Object> getVideoByLabel(@PathVariable String label) {
        ResponseData<Object> results = videoService.getVideoByLabel(label);
        return results;
    }
    
    /**
     * 通过id来获取视频
     * @param id
     * @return
     */
    @GetMapping("/an_video/{id}")
    public ResponseData<Object> getAnVideo(@PathVariable Integer id) {
        ResponseData<Object> results = videoService.getVideoByID(id);
        return results;
    }
    
}
