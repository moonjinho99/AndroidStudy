package com.example.springEx.controller;

import com.example.springEx.dto.ListItem;
import com.example.springEx.dto.User;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestController
public class JoinController {
    @GetMapping(value="/user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User userData(){
        User user = new User("hello",20);

        return user;
    }
    @PostMapping(value = "/save-user", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String saveUser(@RequestBody User user){

        System.out.println("이름 : "+user.getUsername());
        System.out.println("나이 : "+user.getAge());

        if(user.getUsername().equals("mmm") && user.getAge() == 25)
        {
            return "success";
        }

        else{
            return "fail";
        }
    }


    @GetMapping("/test")
    public String mainPage()
    {
        return "/test/test";
    }


    @PostMapping(value = "/finduser", produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<User> findUser(@RequestBody String username){

        User user = new User("aaa",22);

        List<User> userList = new ArrayList<>();
        userList.add(user);

        return userList;
    }


    @GetMapping(value="/find_list" , produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<ListItem> findList(){

        System.out.println("통신 성공");
        ListItem list;
        List<ListItem> listItems = new ArrayList<>();
        for(int i=0; i<10; i++)
        {
            list = new ListItem("a"+i,"200"+i);
            listItems.add(list);
        }
       return listItems;
    }


}
