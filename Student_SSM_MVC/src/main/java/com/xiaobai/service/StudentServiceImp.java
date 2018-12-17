package com.xiaobai.service;

import com.google.gson.Gson;
import com.xiaobai.dao.StudentDAO;
import com.xiaobai.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public List<Student> selectAll(){
        List <Student> studentList = studentDAO.selectAll();
        return studentList;
    }

}
