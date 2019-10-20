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
    public String userList(Model model, @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                           @RequestParam(name = "size", required = false, defaultValue = "50") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        model.addAttribute("user_list", userService.findUser(pageable));
        return "CMS/user-list";
    }

    @GetMapping("/block-user/{userId}")
    public String blockUser(Model model, @PathVariable("userId") int id) {
        userService.blockUser(id);

        return "redirect:/user-list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editUser(@RequestParam("id") Integer userId, Model model) {
        if (userId == -1) {
            model.addAttribute("user", new User());
        } else {
            Optional<User> userEdit = userService.findUserById(userId);
            userEdit.ifPresent(user -> model.addAttribute("user", user));
        }
        return "CMS/user-details";
    }

    @RequestMapping("/")
    public String homePage() {
        return "CMS/index";
    }
}
