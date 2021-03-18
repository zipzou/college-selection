package com.github.xiaotong.collegeselection.service;

import java.util.List;

import com.github.xiaotong.collegeselection.body.ResponseData;
import com.github.xiaotong.collegeselection.dao.bean.VideoListBean;
import com.github.xiaotong.collegeselection.dao.bean.VideosInfoBean;
import com.github.xiaotong.collegeselection.dao.mapper.VideosInfoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 宣讲视频
 */
@Service
public class VideoInfoService {
    private @Autowired VideosInfoDao dao;
    
    /**
     * 获得所有视频
     * @return
     */
    public List<VideosInfoBean> getAll(){
        return dao.selectAll();
    }

    /**
     * 获得视频列表
     * @return
     */
    public List<VideoListBean> getVideoList(){
        return dao.getVideoList();
    }

    /**
     * 根据标签得到视频列表
     * @param videoLabel
     * @return
     */
    public ResponseData<Object> getVideoByLabel(String videoLabel){
        List<VideoListBean> results = dao.getVideoByLabel(videoLabel);
        if(results.isEmpty()){
            return ResponseData.successF("视频标签："+videoLabel+"内容为空！");
        }else{
            return ResponseData.success(results);
        }
    } 

    /**
     * 通过id来获取单个视频
     * @param id
     * @return
     */
    public ResponseData<Object> getVideoByID(Integer id){
        VideosInfoBean results = dao.getAnVideo(id);
        if(null == results){
            return ResponseData.successF("视频id："+id+"错误！");
        }else{
            return ResponseData.success(results);
        }
    }
}
