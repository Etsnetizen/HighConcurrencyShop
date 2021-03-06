package com.imooc.service.impl;

import com.imooc.service.StuService;
import com.imooc.mapper.StuMapper;
import com.imooc.pojo.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Stu getStuInfo(int id) {
        return stuMapper.selectByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void saveStu() {
        Stu stu = new Stu();
        stu.setAge(19);
        stu.setName("jack");
        stuMapper.insertSelective(stu);

    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void updateStu(int id) {
        Stu stu = new Stu();
        stu.setId(id);
        stu.setAge(19);
        stu.setName("jack");
        stuMapper.updateByPrimaryKey(stu);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void deleteStu(int id) {
        stuMapper.deleteByPrimaryKey(id);
    }


    // 事务测试

    @Override
    public void saveParent() {
        Stu stu = new Stu();
        stu.setName("parent");
        stu.setAge(19);
        stuMapper.insertSelective(stu);
    }
    @Transactional(propagation = Propagation.NESTED)
    @Override
    public void saveChildren() {
        saveChild1();
        // 这里会暴异常，用来测试事务
        int a = 1 / 0;
        saveChild2();
    }
    public void saveChild1() {
        Stu stu1 = new Stu();
        stu1.setName("child - 1");
        stu1.setAge(11);
        stuMapper.insertSelective(stu1);
    }
    public void saveChild2() {
        Stu stu2 = new Stu();
        stu2.setName("child - 2");
        stu2.setAge(11);
        stuMapper.insertSelective(stu2);
    }
}
