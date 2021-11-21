package com.example.records.demo.DemoApplication.controller;

import com.example.records.demo.DemoApplication.service.CClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CClassController
{
    @Autowired
    CClassService classService;
}
