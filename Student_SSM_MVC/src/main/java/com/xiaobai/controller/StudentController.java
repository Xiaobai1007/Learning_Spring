package com.xiaobai.controller;

import com.google.gson.Gson;
import com.xiaobai.dao.StudentDAO;
import com.xiaobai.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/selectAll", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String selectAll(){
        return new Gson().toJson(studentService.selectAll());
    }

}
