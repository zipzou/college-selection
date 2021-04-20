package com.github.xiaotong.collegeselection.service;

import java.util.ArrayList;
import java.util.List;

import com.github.xiaotong.collegeselection.body.ResponseData;
import com.github.xiaotong.collegeselection.dao.bean.EnrollRankingBean;
import com.github.xiaotong.collegeselection.dao.bean.RankingBean;
import com.github.xiaotong.collegeselection.dao.mapper.CollectionReportDao;
import com.github.xiaotong.collegeselection.dao.mapper.EnrollInfoDao;
import com.github.xiaotong.collegeselection.dao.mapper.UserInfoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 填报志愿算法
 */
@Service
public class SelectAlgorithm {
    private Long t;//最低录取分数线的平均名次
    private Long a;//平均录取分数平均名次号
    private Long old = 0L;//老的用户名次
    private @Autowired EnrollInfoDao dao;
    private @Autowired CollectionReportDao reportDao;
    private @Autowired UserInfoDao userDao;
    
    private List<EnrollRankingBean> cRankList = new ArrayList<EnrollRankingBean>();//冲一冲大学列表
    private List<EnrollRankingBean> wRankList = new ArrayList<EnrollRankingBean>();//稳一稳大学列表
    private List<EnrollRankingBean> bRankList = new ArrayList<EnrollRankingBean>();//保底大学列表
    /**
     * 得到冲一冲列表
     * @param pNo
     * @param years
     * @param uRanking
     * @return
     */
    public ResponseData<Object> getCRankList(Long userNo,String pNo,Short years,Long uRanking,String planCate)
    {
        Boolean results;
        if(!checkUser(userNo))//用户不存在
        {
            return ResponseData.successF("用户不存在！");
        }
        if(uRanking<=0)//用户名次不对
        {
            return ResponseData.successF("用户名次小于等于零！");
        }
        if(!checkPlanCate(planCate))//用户考试类别不正确
        {
            return ResponseData.successF("用户输入的考试类别不正确！需输入文科、理科或者综合");
        }
        if(checkUserReport(userNo))//如果数据库已经有了，让他移步去个人收藏
        {
            return ResponseData.successF("请移步去个人收藏！");
        }
        if(cRankList.isEmpty()&&wRankList.isEmpty()&&bRankList.isEmpty())//说明没有数据
        {
            results = getAllRanking(pNo, years, uRanking,planCate);
            old = uRanking;
            if(!results)
            {
                return ResponseData.successF("该省份无大学历史录取信息！");
            }
            //开始插入
            if(!insertUserRanking(userNo))//插入失败
            { 
                return ResponseData.successF("插入数据库失败，数据库中已经有该用户的志愿填报内容！");
            }
        }
        if(old!=0&&(long)uRanking!=(long)old)//要更新了
        {
            results = getAllRanking(pNo, years, uRanking,planCate);
            old = uRanking;
            if(!results)
            {
                return ResponseData.successF("该省份无大学历史录取信息！");
            }
            //开始插入
            if(!insertUserRanking(userNo))//插入失败
            { 
                return ResponseData.successF("插入数据库失败，数据库中已经有该用户的志愿填报内容！");
            }
        }
        return ResponseData.success(cRankList);
    }

    /**
     * 得到稳一稳列表
     * @param pNo
     * @param years
     * @param uRanking
     * @return
     */
    public ResponseData<Object> getWRankList(Long userNo,String pNo,Short years,Long uRanking,String planCate)
    {
        Boolean results = false;
        if(!checkUser(userNo))//用户不存在
        {
            return ResponseData.successF("用户不存在！");
        }
        if(uRanking<=0)//用户名次不对
        {
            return ResponseData.successF("用户名次小于等于零！");
        }
        if(!checkPlanCate(planCate))//用户考试类别不正确
        {
            return ResponseData.successF("用户输入的考试类别不正确！需输入文科、理科或者综合");
        }
        if(checkUserReport(userNo))//如果数据库已经有了，让他移步去个人收藏
        {
            return ResponseData.successF("请移步去个人收藏！");
        }
        if(cRankList.isEmpty()&&wRankList.isEmpty()&&bRankList.isEmpty())//说明没有数据
        {
            results = getAllRanking(pNo, years, uRanking,planCate);
            old = uRanking;
            if(!results)
            {
                return ResponseData.successF("该省份无大学历史录取信息！");
            }
            //开始插入
            if(!insertUserRanking(userNo))//插入失败
            { 
                return ResponseData.successF("插入数据库失败，数据库中已经有该用户的志愿填报内容！");
            }
        }
        if(old!=0&&(long)uRanking!=(long)old)//要更新了
        {
            results = getAllRanking(pNo, years, uRanking,planCate);
            old = uRanking;
            if(!results)
            {
                return ResponseData.successF("该省份无大学历史录取信息！");
            }
            //开始插入
            if(!insertUserRanking(userNo))//插入失败
            { 
                return ResponseData.successF("插入数据库失败，数据库中已经有该用户的志愿填报内容！");
            }
        }
        return ResponseData.success(wRankList);
    }

    /**
     * 得到保底列表
     * @param pNo
     * @param years
     * @param uRanking
     * @return
     */
    public ResponseData<Object> getBRankList(Long userNo,String pNo,Short years,Long uRanking,String planCate)
    {
        Boolean results = false;
        if(!checkUser(userNo))//用户不存在
        {
            return ResponseData.successF("用户不存在！");
        }
        if(uRanking<=0)//用户名次不对
        {
            return ResponseData.successF("用户名次小于等于零！");
        }
        if(!checkPlanCate(planCate))//用户考试类别不正确
        {
            return ResponseData.successF("用户输入的考试类别不正确！需输入文科、理科或者综合");
        }
        if(checkUserReport(userNo))//如果数据库已经有了，让他移步去个人收藏
        {
            return ResponseData.successF("请移步去个人收藏！");
        }
        if(cRankList.isEmpty()&&wRankList.isEmpty()&&bRankList.isEmpty())//说明没有数据
        {
            results = getAllRanking(pNo, years, uRanking,planCate);
            old = uRanking;
            if(!results)
            {
                return ResponseData.successF("该省份无大学历史录取信息！");
            }
            //开始插入
            if(!insertUserRanking(userNo))//插入失败
            { 
                return ResponseData.successF("插入数据库失败，数据库中已经有该用户的志愿填报内容！");
            }
        }
        if(old!=0&&(long)uRanking!=(long)old)//要更新了
        {
            results = getAllRanking(pNo, years, uRanking,planCate);
            old = uRanking;
            if(!results)
            {
                return ResponseData.successF("该省份无大学历史录取信息！");
            }
            //开始插入
            if(!insertUserRanking(userNo))//插入失败
            { 
                return ResponseData.successF("插入数据库失败，数据库中已经有该用户的志愿填报内容！");
            }
        }
        return ResponseData.success(bRankList);
    }
    
    /**
     * 得到所有的录取概率
     * @param pNo
     * @param years
     * @param uRanking
     * @return
     */
    private Boolean getAllRanking(String pNo,Short years,Long uRanking,String planCate) {
        Short y = years;
        List<Integer> uList = dao.getUniversityList(pNo);//得到大学列表
        // log.info(uList);
        if(uList.isEmpty())//该省份无大学历史录取信息
        {
            return false;
        }
        for(Integer ID:uList){//遍历大学列表，计算学校录取概率
            EnrollRankingBean ranking = getAnRanking(ID,y,pNo,uRanking,planCate);
            if(null != ranking)//说明该大学有数据
            {
                if(ranking.getMark().equals("c"))//加到冲一冲列表
                {
                    cRankList.add(ranking);
                }
                else if(ranking.getMark().equals("w"))//稳一稳列表
                {
                    wRankList.add(ranking);
                }
                else if(ranking.getMark().equals("b"))//保底列表
                {
                    bRankList.add(ranking);
                }
            }
        }      
        return true;
    } 

    /**
     * 计算用户在该大学的录取概率
     * @param id
     * @param y
     * @param pNo
     * @param uRanking
     * @return
     */
    private EnrollRankingBean getAnRanking(Integer id,Short y,String pNo,Long uRanking,String planCate)
    {
        EnrollRankingBean results = new EnrollRankingBean();
        results.setUID(id);
        Long t1 = -1L;
        Long t2 = -1L;
        Long t3 = -1L;
        Long t4 = -1L;
        Long a1 = -1L;
        Long a2 = -1L;
        Long a3 = -1L;
        Long a4 = -1L;
        RankingBean r1 = dao.getRanking(y, pNo, id,planCate);
        RankingBean r2 = dao.getRanking((short)(y-1), pNo, id,planCate);
        RankingBean r3 = dao.getRanking((short)(y-2), pNo, id,planCate);
        RankingBean r4 = dao.getRanking((short)(y-3), pNo, id,planCate);
        if(null!=r1&&null!=r2&&null!=r3&&null!=r4)//四年都有数据
        {
            a1 = r1.getAvgRanking();
            t1 = r1.getMinRanking();
            a2 = r2.getAvgRanking();
            t2 = r2.getMinRanking();
            a3 = r3.getAvgRanking();
            t3 = r3.getMinRanking();
            a4 = r4.getAvgRanking();
            t4 = r4.getMinRanking();
        }
        else//有一年没有数据
        {
            return null;
        }
        //下面计算平均名次
        t = (t1+t2+t3+t4)/4;//最低录取分数线的平均名次
        a = (a1+a2+a3+a4)/4;//平均录取分数平均名次号
         //下面计算录取概率
        double ranking = 1;
        String mark = "";
        // log.info(t);
        // log.info(a);
        // log.info(uRanking);
        if(uRanking>t)//没戏
        {
            ranking = 0;
            mark = "m";
            results.setRanking(ranking);
            results.setMark(mark);
        }
        if(uRanking == t)//冲一冲
        {
            ranking = 0.5;
            mark = "c";
            results.setRanking(ranking);
            results.setMark(mark);
        }
         else if(uRanking < t && uRanking > a)//稳一稳
        {
            ranking = ((t-uRanking)/(t-a))*0.50+0.50;
            mark = "w";
            results.setRanking(ranking);
            results.setMark(mark);
        }
        else if(uRanking<=a)//保底
        {
            ranking = 1;
            mark = "b";
            results.setRanking(ranking);
            results.setMark(mark);
        }
        // log.info(mark);
        // log.info(ranking);
        return results;
        
    }

    /**
     * 将冲稳保数据插入到数据库
     * @param userNo
     * @return
     */
    private Boolean insertUserRanking(Long userNo)
    {
        if(checkUserReport(userNo))//如果数据库已经有了，那就不插入
        {
            return false;
        }
        else
        {
            int f = 0;
            for(EnrollRankingBean e:cRankList)//冲一冲列表插入
            {
                reportDao.insertReportCollect(userNo, e.getUID(), e.getRanking(), e.getMark());
                f=1;
            }
            for(EnrollRankingBean e:wRankList)//稳一稳列表插入
            {
                reportDao.insertReportCollect(userNo, e.getUID(), e.getRanking(), e.getMark());
                f=2;
            }
            for(EnrollRankingBean e:bRankList)//保底列表插入
            {
                reportDao.insertReportCollect(userNo, e.getUID(), e.getRanking(), e.getMark());
                f=3;
            }
            if(f==3)//证明有数据
            {
                return true;
            }
            else return false;
        }
    }
    /**
     * 判断数据库里是否有该用户的志愿填报信息
     * @param userNo
     * @return
     */
    private Boolean checkUserReport(Long userNo)
    {
        String checkUserReport = reportDao.CheckUserReport(userNo);
        if(null == checkUserReport)
        {
            return false;
        }
        return true;
    }

    /**
     * 判断用户是否存在
     * @param userNo
     * @return
     */
    private Boolean checkUser(Long userNo)
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
     * 判断输入的文理科参数对不对
     * @param p
     * @return
     */
    private Boolean checkPlanCate(String p)
    {
        if(p.equals("理科")||p.equals("文科")||p.equals("综合"))
        {
            return true;
        }
        else return false;
    }
}
