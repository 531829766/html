package cn.edu.hziee.dao;

import cn.edu.hziee.model.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DaoTest {
    @Test
    public void findById(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentDao studentDao =  (StudentDao) context.getBean("studentDao");

        Student student = studentDao.findById(1);
        System.out.println(student);
    }

    @Test
    public void findByName(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentDao studentDao =   context.getBean("studentDao",StudentDao.class);

        List<Student> list = studentDao.findByName("李");
        System.out.println(list);
    }
}
