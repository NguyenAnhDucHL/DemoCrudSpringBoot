package com.studyonline.controller;


import com.studyonline.entity.User;
import com.studyonline.repository.UserRepository;
import com.studyonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("/saveUser")
    public String saveUser(Model model, @ModelAttribute("user")User user, @RequestParam("avatar")MultipartFile avatar) {
    	try {
			user.setImage(avatar.getBytes());
			userService.saveUser(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return "redirect:/user-list";
    }
    @RequestMapping("/user-list")
    public String userList(Model model,  @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                           @RequestParam(name = "size", required = false, defaultValue = "5") Integer size){
        Pageable pageable = PageRequest.of(page,size);
        model.addAttribute("user_list",userService.findUser(pageable));
        return "CMS/user-list";
    }

    @RequestMapping("/user-details")
    public String addUser(Model model)
    {
       model.addAttribute("user", new User());
       return "CMS/user-details";
    }

    @GetMapping("/block-user/{userId}")
    public String blockUser(Model model, @PathVariable("userId") int id) {
        userService.blockUser(id);

        return "redirect:/user-list";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Model model, User user) {
        userService.saveUser(user);
        return "redirect:/user-list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editUser(@RequestParam("id") Integer userId, Model model) {
        Optional<User> userEdit = userService.findUserById(userId);
        userEdit.ifPresent(user -> model.addAttribute("user", user));
        return "CMS/user-details";
    }

//        @GetMapping(path = "/user-list")
//        public JSONObject userList() {
//        return new JSONObject("{'id':'abc' }");
//    }
    @RequestMapping("/post-list")
    public String postList(){

        return "CMS/post-list";
    }
    @RequestMapping("/slide-list")
    public String slideList(){

        return "CMS/slide-list";
    }
    @RequestMapping("/exams-list")
    public String examsList(){

        return "CMS/exams-list";
    }
    @RequestMapping("/subject-list")
    public String subjectList(){

        return "CMS/subject-list";
    }
    @RequestMapping("/test-list")
    public String testList(){

        return "CMS/test-list";
    }
    @RequestMapping("/settings-list")
    public String settingsList(){

        return "CMS/settings-list";
    }
    @RequestMapping("/menu-list")
    public String menuList(){

        return "CMS/menu-list";
    }
    @RequestMapping("/permissions-list")
    public String permissionsList(){

        return "CMS/permissions-list";
    }
    @RequestMapping("/roles-menu")
    public String rolesMenu(){

        return "CMS/roles-menu";
    }
    @RequestMapping("/roles-permission")
    public String rolesPermission(){

        return "CMS/roles-permission";
    }
    @RequestMapping("/registrations-list")
    public String registrationList(){

        return "CMS/registrations-list";
    }
    @RequestMapping("/course-list")
    public String courseList(){

        return "CMS/course-list";
    }
    @RequestMapping("/course-works")
    public String courseWorks(){

        return "CMS/course-works";
    }
    @RequestMapping("/pratice-result")
    public String praticeResult(){

        return "CMS/pratice-result";
    }
    @RequestMapping("/")
    public String homePage(){
        return "CMS/index";
    }
}
