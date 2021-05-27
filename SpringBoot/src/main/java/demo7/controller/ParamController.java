package demo7.controller;


import demo7.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;



@Controller
public class ParamController {
    //localhost:8080/user/3/grade/wang?age=18&inters=basketball&inters=game
    @GetMapping("/user/{id}/grade/{name}")
    public void getUser(
                        @PathVariable("id") Integer id,
                        @PathVariable("name") String name,
                        @PathVariable Map<String,String> user,
                        @RequestParam("age") Integer age,
                        @RequestParam("inters") List<String> inters,
                        @RequestParam Map<String,String> params,
                        @RequestHeader("User-Agent") String userAgent,
                        @RequestHeader Map<String,String> header,
                        @CookieValue("cookieconsent_status") String _ga,
                        @CookieValue("cookieconsent_status") Cookie cookie){
        System.out.println(id);
        System.out.println(name);
        System.out.println(user);
        System.out.println(age);
        System.out.println(inters);
        System.out.println(params);
        System.out.println(userAgent);
        System.out.println(header);
        System.out.println(_ga);
        System.out.println(cookie);
    }

    @PostMapping("/save")
    public void save(@RequestBody String content){
        System.out.println(content);
    }




    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg1","在goto页写入msg1");
        request.setAttribute("msg2","在goto页写入msg2");
        return "forward:/success";  //转发到  /success请求
    }

    @GetMapping("/success")
    public void success(@RequestAttribute(value = "msg",required = false) String msg,
                        HttpServletRequest request) {
        Object msg1 = request.getAttribute("msg1");
        Object msg2 = request.getAttribute("msg2");
        System.out.println(msg1);
        System.out.println(msg2);
    }

    @PostMapping("/savepojo")
    public void savePojo(User user){
        System.out.println(user);
    }
}
