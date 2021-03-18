package com.github.xiaotong.collegeselection.dao;

import java.util.List;

import com.github.xiaotong.collegeselection.dao.bean.ViewStrenthBean;
import com.github.xiaotong.collegeselection.dao.mapper.ViewStrenthDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ViewStrenthDaoTest {
    private @Autowired ViewStrenthDao dao;

    @Test
    public void testFindAll() {
        List<ViewStrenthBean> result = dao.selectAll();
        System.out.println(result);
    }
}
