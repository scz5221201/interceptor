package hzy.life.interceptor.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TmpController {

    @GetMapping("/tmp")
    public String tmp(){
        return "tmp";
    }
}
