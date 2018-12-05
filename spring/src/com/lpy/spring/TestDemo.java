package com.lpy.spring;

import com.lpy.spring.dao.Student;
import org.aspectj.weaver.ast.Var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:aopdemo.xml", "classpath:jdbcdemo.xml"})
public class TestDemo {
    @Resource(name = "product")
    private ProductDao productDao;

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testProduct() {
        productDao.save();
        productDao.update();
        productDao.delete();
        productDao.find();


    }

    @Test
    public void demo1() {
      /*  DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/store_db?useSSL=false&amp;serverTimezone=GMT");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("123");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource);*/
        String sql = "insert into student values (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, null, "张三", 18, "100", "man", "三三");
    }

    @Test
    public void demo2() {
        String sql = "update student set name =?,age=?,score=?,sex=?,clazz=? where id = ?";
        jdbcTemplate.update(sql, "李四", 20, "100", "男", "五年级", 3);
    }

    @Test
    public void demo3() {
        String sql = "delete from student where id = ?";
        jdbcTemplate.update(sql, 1);
    }

    @Test
    public void demo4() {
        String sql = "select * from student";
        List<Student> query = jdbcTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                return getStudent(resultSet);
            }
        });
        System.out.println(query.toString());
    }

    @Test
    public void demo5() {
        String sql = "select * from student where id = ?";
        Student student = jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                return getStudent(resultSet);
            }
        }, 2);
        System.out.println(student.toString());
    }

    private Student getStudent(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setAge(resultSet.getInt("age"));
        student.setScore(resultSet.getString("score"));
        student.setClazz(resultSet.getString("clazz"));
        return student;
    }
}
