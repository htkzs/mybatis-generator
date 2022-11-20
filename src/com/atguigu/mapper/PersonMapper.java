package com.atguigu.mapper;

import com.atguigu.domain.Person;
import com.atguigu.domain.PersonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonMapper {
    long countByExample(PersonExample example);

    int deleteByExample(PersonExample example);

    int deleteByPrimaryKey(Integer no);

    int insert(Person record);

    int insertSelective(Person record);

    List<Person> selectByExampleWithBLOBs(PersonExample example);

    List<Person> selectByExample(PersonExample example);

    Person selectByPrimaryKey(Integer no);

    int updateByExampleSelective(@Param("record") Person record, @Param("example") PersonExample example);

    int updateByExampleWithBLOBs(@Param("record") Person record, @Param("example") PersonExample example);

    int updateByExample(@Param("record") Person record, @Param("example") PersonExample example);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKeyWithBLOBs(Person record);

    int updateByPrimaryKey(Person record);
}