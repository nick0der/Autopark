package edu.nick.cursach.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class StarterController {

    @RequestMapping("")
    public String returnHome(){
        return "index.html";
    }
}
