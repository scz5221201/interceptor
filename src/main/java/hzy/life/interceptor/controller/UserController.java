package hzy.life.interceptor.controller;

import hzy.life.interceptor.model.User;
import hzy.life.interceptor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, Model model)
    public String login(User user, HttpServletRequest request, HttpSession session, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        user.setPassword(password);
        user.setUsername(username);
        user = userService.loginUser(user);
        session.setAttribute("user", user);
        if (user != null) {
            model.addAttribute("msg", "登录成功");
            return "status";
        } else {
            model.addAttribute("msg", "账户或密码错误");
            return "status";
        }

//        if (userService.loginUser(username,password) != null) {
//            model.addAttribute("msg", "登录成功");
//            return "status";
//        } else {
//            model.addAttribute("msg", "账户或密码错误");
//            return "status";
//        }
    }

    @PostMapping("/reg")
    public String reg(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        if (userService.regUser(username, password) != 0) {
            model.addAttribute("msg", "注册成功");
            return "status";
        } else {
            model.addAttribute("msg", "注册失败");
            return "status";
        }
    }


}
