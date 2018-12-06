package com.lpy.spring.mybatis;

import com.lpy.spring.dao.Student;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    Student getStudent(int id);
}
