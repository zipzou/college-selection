package com.github.xiaotong.collegeselection.dao;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.EmployRateBean;
import com.github.xiaotong.collegeselection.dao.mapper.EmployRateDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployRateDaoTest {

    private @Autowired EmployRateDao dao;

    @Test
    public void testFindAll() {
        List<EmployRateBean> result = dao.selectAll();
        System.out.println(result);
    }

}
