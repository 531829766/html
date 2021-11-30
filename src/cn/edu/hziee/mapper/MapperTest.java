package cn.edu.hziee.mapper;

import cn.edu.hziee.dao.StudentDao;
import cn.edu.hziee.model.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MapperTest {
    @Test
    public void findById(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentMapper studentMapper =   context.getBean("studentMapper",StudentMapper.class);

        Student student = studentMapper.findById(1);
        System.out.println(student);
    }

    @Test
    public void findByName(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentMapper studentMapper =   context.getBean("studentMapper",StudentMapper.class);

        List<Student> list = studentMapper.findByName("李");
        System.out.println(list);
    }
}
