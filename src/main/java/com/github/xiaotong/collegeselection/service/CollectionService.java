package com.github.xiaotong.collegeselection.service;

import java.util.List;

import com.github.xiaotong.collegeselection.body.ResponseData;
import com.github.xiaotong.collegeselection.dao.bean.CollectionCollegeBean;
import com.github.xiaotong.collegeselection.dao.bean.CollectionMajorBean;
import com.github.xiaotong.collegeselection.dao.bean.CollectionReportBean;
import com.github.xiaotong.collegeselection.dao.bean.CollectionVideoBean;
import com.github.xiaotong.collegeselection.dao.mapper.CollectCollegeDao;
import com.github.xiaotong.collegeselection.dao.mapper.CollectVideoDao;
import com.github.xiaotong.collegeselection.dao.mapper.CollectionMajorDao;
import com.github.xiaotong.collegeselection.dao.mapper.CollectionReportDao;
import com.github.xiaotong.collegeselection.dao.mapper.MajorsInfoDao;
import com.github.xiaotong.collegeselection.dao.mapper.UniversityInfoDao;
import com.github.xiaotong.collegeselection.dao.mapper.UserInfoDao;
import com.github.xiaotong.collegeselection.dao.mapper.VideosInfoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 个人收藏
 */
@Service
public class CollectionService {
    private @Autowired CollectVideoDao cvDao;
    private @Autowired CollectCollegeDao cuDao;
    private @Autowired CollectionMajorDao cmDao;
    private @Autowired CollectionReportDao reportDao;

    private @Autowired MajorsInfoDao majorsDao;
    private @Autowired VideosInfoDao videosDao;
    private @Autowired UniversityInfoDao universityDao;
    private @Autowired UserInfoDao userDao;
   
    /**
     * 返回专业收藏
     * @param id
     * @return
     */
    public ResponseData<Object> getMajorsCollection(String id) {
        List<CollectionMajorBean> results = cmDao.getMajorCollection(id);
        if(results.isEmpty())
        {
            return ResponseData.successF("该用户id："+id+"下不存在专业收藏！");
        }
        else
        {
            return ResponseData.success(results);
        }
    }

    /**
     * 返回大学收藏
     * @param id
     * @return
     */
    public ResponseData<Object> getCollegeCollection(String id) {
        List<CollectionCollegeBean> results = cuDao.getCollegeCollection(id);
        if(results.isEmpty())
        {
            return ResponseData.successF("该用户id："+id+"下不存在高校收藏！");
        }
        else
        {
            return ResponseData.success(results);
        }
    }

    /**
     * 返回视频收藏
     * @param id
     * @return
     */
    public ResponseData<Object> getVideoCollection(String id) {
        List<CollectionVideoBean> results = cvDao.getVideoCollection(id);
        if(results.isEmpty())
        {
            return ResponseData.successF("该用户id："+id+"下不存在视频收藏！");
        }
        else
        {
            return ResponseData.success(results);
        }
    }

    /**
     * 获得志愿填报
     * @param userNo
     * @param mark
     * @return
     */
    public ResponseData<Object> getReportCollect(String userNo,String mark)
    {
        List<CollectionReportBean> results = reportDao.getReportCollection(userNo, mark);
        if(results.isEmpty())
        {
            return ResponseData.successF("该用户："+userNo+mark+"下没有数据！");
        }
        else
        {
            return ResponseData.success(results);
        }
    }

    /**
     * 添加专业收藏
     * @param mCode
     * @param userNo
     * @return
     */
    public ResponseData<Object> insertMajorCollect(String mCode,String userNo){
        if(checkUser(userNo)){
            if(null != majorsDao.getMajorByCode(mCode))
            {
                //先判断添加的有没有
                if(checkMajorCollection(userNo,mCode))//如果有
                {
                    return ResponseData.successF("用户："+userNo+"中已经有专业："+mCode+"的收藏！");
                }
                else
                {
                    cmDao.insertMajorCollect(mCode, userNo);
                    return ResponseData.successMes("成功往用户："+userNo+"添加专业："+mCode+"的收藏！");
                }
            }
            else{
                return ResponseData.successF("专业："+mCode+"不存在！");
            }
        }
        else{
            return ResponseData.failed("用户id："+userNo+"不存在！");
        }
    }

    /**
     * 删除专业收藏
     * @param mCode
     * @param userNo
     * @return
     */
    public ResponseData<Object> deleteMajorCollect(String mCode,String userNo){
        if(checkUser(userNo)){
            if(null != mCode)
            {
                //先判断删除的有没有
                if(checkMajorCollection(userNo, mCode))//删除的有
                {
                    cmDao.deleteMajorCollect(mCode, userNo);
                    return ResponseData.successMes("成功删除用户："+userNo+"专业："+mCode+"的收藏！");
                }
                else
                {
                    return ResponseData.successF("用户："+userNo+"中没有专业："+mCode+"的收藏！");
                }
            }
            else{
                return ResponseData.successF("专业id为空！");
            }
        }
        else
        {
            return ResponseData.failed("用户id："+userNo+"不存在！");
        }
    }

    /**
     * 添加视频收藏
     * @param videoID
     * @param userNo
     * @return
     */
    public ResponseData<Object> insertVideoCollect(Integer videoID,String userNo){
        if(checkUser(userNo)){
            if(null != videosDao.getAnVideo(videoID))
            {
                //先判断待添加的有无
                if(checkVideoCollection(userNo, videoID))//有
                {
                    return ResponseData.successF("用户："+userNo+"中已经有视频："+videoID+"的收藏！");
                }
                else
                {
                    cvDao.insertVideoCollect(videoID, userNo);
                    return ResponseData.successMes("成功往用户："+userNo+"添加视频："+videoID+"的收藏！");
                }
            }
            else{
                return ResponseData.successF("视频："+videoID+"不存在！");
            }
        }
        else{
            return ResponseData.failed("用户id："+userNo+"不存在！");
        }
    }

    /**
     * 删除视频收藏
     * @param videoID
     * @param userNo
     * @return
     */
    public ResponseData<Object> deleteVideoCollect(Integer videoID,String userNo){
        if(checkUser(userNo)){
            if(null != videoID)
            {
                //先判断待删除的有无
                if(checkVideoCollection(userNo, videoID))//有
                {
                    cvDao.deleteVideoCollect(videoID, userNo);
                    return ResponseData.successMes("成功删除用户："+userNo+"视频："+videoID+"的收藏！");
                }
                else{
                    return ResponseData.successF("用户："+userNo+"中没有视频："+videoID+"的收藏！");
                }
            }
            else{
                return ResponseData.successF("视频id为空！");
            }
        }
        else
        {
            return ResponseData.failed("用户id："+userNo+"不存在！");
        }
    }

    /**
     * 添加大学收藏
     * @param universityID
     * @param userNo
     * @return
     */
    public ResponseData<Object> insertCollegeCollect(Integer universityID,String userNo){
        if(checkUser(userNo)){
            if(null!= universityDao.selectAllByID(universityID))
            {
                //先判断添加的有无
                if(checkCollegeCollection(userNo, universityID))//已经存在
                {
                    return ResponseData.successF("用户："+userNo+"已经存在大学："+universityID+"的收藏！");
                }
                else
                {
                    cuDao.insertCollegeCollect(universityID, userNo);
                    return ResponseData.successMes("成功往用户："+userNo+"添加大学："+universityID+"的收藏！");
                }
            }
            else{
                return ResponseData.successF("大学："+universityID+"不存在！");
            }
        }
        else{
            return ResponseData.failed("用户id："+userNo+"不存在！");
        }
    }

    /**
     * 删除高校收藏
     * @param universityID
     * @param userNo
     * @return
     */
    public ResponseData<Object> deleteCollegeCollect(Integer universityID,String userNo){
        if(checkUser(userNo)){
            if(null != universityID)
            {
                //先判断待删除的有无
                if(checkCollegeCollection(userNo, universityID))//有
                {
                    cuDao.deleteCollegeCollect(universityID, userNo);
                    return ResponseData.successMes("成功删除用户："+userNo+"大学："+universityID+"的收藏！");
                }
                else{
                    return ResponseData.successF("用户："+userNo+"中不存在大学："+universityID+"的收藏！");
                }
            }
            else{
                return ResponseData.successF("大学id为空！");
            }
        }
        else
        {
            return ResponseData.failed("用户id："+userNo+"不存在！");
        }
    }

    /**
     * 判断用户是否存在
     * @param userNo
     * @return
     */
    private Boolean checkUser(String userNo)
    {
        //用户存在
        if(!userDao.getAnUser(userNo).isEmpty())
        {
            return true;
        }
        //用户不存在
        else{
            return false;
        }
    } 

    /**
     * 判断该视频收藏是否存在
     * @param userNo
     * @param videoID
     * @return
     */
    private Boolean checkVideoCollection(String userNo,Integer videoID)
    {
        CollectionVideoBean anVideoCollection = cvDao.getAnVideoCollection(userNo, videoID);
        if(null == anVideoCollection)//不存在该视频收藏
        {
            return false;
        }
        else return true;
    }

    /**
     * 判断该专业收藏是否存在
     * @param userNo
     * @param mCode
     * @return
     */
    private Boolean checkMajorCollection(String userNo,String mCode)
    {
        CollectionMajorBean anMajorCollection = cmDao.getAnMajorCollection(mCode, userNo);
        if(null == anMajorCollection)//不存在该专业收藏
        {
            return false;
        }
        else return true;
    }

    /**
     * 判断该大学收藏是否存在
     * @param userNo
     * @param universityID
     * @return
     */
    private Boolean checkCollegeCollection(String userNo,Integer universityID)
    {
        CollectionCollegeBean anCollegeCollection = cuDao.getAnCollegeCollection(userNo, universityID);
        if(null == anCollegeCollection)//不存在该大学的收藏
        {
            return false;
        }
        return true;
    } 
}
