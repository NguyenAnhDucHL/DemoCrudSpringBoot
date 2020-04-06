package com.studyonline.controller;


import com.studyonline.entity.User;
import com.studyonline.repository.UserRepository;
import com.studyonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import java.util.stream.Collectors;
import java.util.stream.IntStream;


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
    @RequestMapping(value = "/user-list", method = RequestMethod.GET)
    public String listBooks(
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<User> userPage = userService.findUser(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("userPage", userPage);

        int totalPages = userPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

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
