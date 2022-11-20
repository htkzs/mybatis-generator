package com.atguigu.test;

import com.atguigu.domain.Person;
import com.atguigu.domain.PersonExample;
import com.atguigu.domain.User;
import com.atguigu.mapper.PersonMapper;
import com.atguigu.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import sun.misc.Resource;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class MyBatisGeneratorTest {
    /*
     * @Author GhostGalaxy
     * @Description 简单版的逆向工程SQL测试
     * @Date 15:50:32 2022/11/20
     * @Param []
     * @return void
     **/
    @Test
    public void getUserById(){
        SqlSession sqlSession = null;
        try {
            Reader reader = Resources.getResourceAsReader("config/mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession(true);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.selectByPrimaryKey(1);
            System.out.println(user);


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }

        }


    }
    /*
     * @Author GhostGalaxy
     * @Description 封装条件查询 QBC方式
     * @Date 15:52:08 2022/11/20
     * @Param []
     * @return void
     **/
    @Test
    public void getPersonByCondition(){
        SqlSession sqlSession = null;
        try {
            Reader reader = Resources.getResourceAsReader("config/mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession(true);
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            PersonExample personExample = new PersonExample();
            PersonExample.Criteria criteria = personExample.createCriteria();
            //查询年龄等于23 name中包含 ‘a’ 字符的人 or  height>170
            criteria.andAgeEqualTo(23).andNameLike("%a%");
            PersonExample.Criteria criteria2 = personExample.createCriteria();
            List<Integer> list = new ArrayList<>();
            list.add(1);
            criteria2.andAddressIdIn(list);
            personExample.or(criteria2);
            List<Person> people = personMapper.selectByExample(personExample);

            System.out.println(people);


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }

        }


    }
    
    
}
