package com.jwh.controller;

import com.jwh.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Auther: 渣渣灰
 * @Date: 2020/4/3 20:50
 * @Description:页面跳转controller
 */
@Controller
public class PageController {
    /*
    * 页面跳转方法
    * th:text输出文本时一定要写成th:text="${'xxx'}"不加''可能引起
    * org.thymeleaf.exceptions.TemplateProcessingException: Could not parse as 。。。错误
    * th:text输出的是变量时写成th:text="${xxx}"
    *
    * */
    @GetMapping("/show")
    public String showPage(Model model){
        model.addAttribute("msg","Thymeleaf 第一个案例") ;
        return "index" ;
    }


    @GetMapping("/{page}")
    public String numShow(Model model,@PathVariable String page){
        Double[] arr = new Double[]{10.51, 10.2};
        List list = Arrays.asList(arr) ;
        Set set = new HashSet(list) ;
        model.addAttribute("arr",arr) ;
        model.addAttribute("list",list) ;
        model.addAttribute("set",set) ;
        return page ;
    }
    @GetMapping("/dates/{date}")
    public String dateShow( Model model,@PathVariable String date){
        model.addAttribute("date",new Date()) ;
        return date ;
    }
    @GetMapping("/showPages")
    public String showPages(Model model){
        model.addAttribute("sex","女") ;
        model.addAttribute("id","2") ;
        return "ifs" ;
    }
    @GetMapping("/iter")
    public String iter(Model model){
        List<User> list = new ArrayList<User>();
        list.add(new User("1","admin",12)) ;
        list.add(new User("2","admin2",13)) ;
        list.add(new User("3","admin3",14)) ;
        list.add(new User("4","admin4",15)) ;
        Map<String,User> map = new HashMap<>() ;
        map.put("user1",new User("1","admin",12)) ;
        map.put("user2",new User("2","admin2",13)) ;
        map.put("user3",new User("3","admin3",14)) ;
        map.put("user4",new User("4","admin4",15)) ;
        model.addAttribute("list",list) ;
        model.addAttribute("map",map) ;
        return "iter" ;
    }
    @GetMapping("/showServlet")
    public String showServlet(Model model, HttpServletRequest request, HttpSession session){

        request.setAttribute("req",new User("1","zhagnsan",12));
        session.setAttribute("ses","123");
        request.getServletContext().setAttribute("app","123");

        return "servlet" ;
    }

    @GetMapping("/show2")
    public String show2(String id ,String name){
        System.out.println("id="+id+"name="+name);

        return "index2" ;
    }
    @GetMapping("/show3/{id}/{name}")
    public String show3(@PathVariable String id ,@PathVariable String name){
        System.out.println("id="+id+"name="+name);

        return "index2" ;
    }
    @GetMapping("/show4/{id}")
    public String show4(@PathVariable String id ,String name){
        System.out.println("id="+id+"name="+name);

        return "index2" ;
    }
    @GetMapping("/thurl")
    public String url(Model model){
        model.addAttribute("id","1001") ;
        model.addAttribute("name","oldlu") ;
        return "thurl";
    }
}