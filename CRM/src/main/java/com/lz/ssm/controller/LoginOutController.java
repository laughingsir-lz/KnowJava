package com.lz.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginOutController {
    @RequestMapping("/loginout")
    public String loginOut(HttpSession session) {
        session.invalidate();
        return "redirect:/login.html";

    }
}
