package cn.edu.hziee.service;

import cn.edu.hziee.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentService studentService = context.getBean("studentService",StudentService.class);

        Student student = new Student();
        student.setAge(123);
        student.setCode("123");
        student.setGender("男");
        student.setUsername("事务测试123");

        studentService.addStudent(student);
    }
}
