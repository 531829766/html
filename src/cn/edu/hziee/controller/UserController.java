package cn.edu.hziee.controller;

import cn.edu.hziee.model.Consumer;
import cn.edu.hziee.service.ConsumerService;
import cn.edu.hziee.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private ConsumerService studentService;

}
