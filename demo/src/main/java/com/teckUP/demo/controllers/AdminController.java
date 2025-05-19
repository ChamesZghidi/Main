package com.teckUP.demo.controllers;

import com.teckUP.demo.models.Admin;
import com.teckUP.demo.models.User;
import com.teckUP.demo.repository.AdminRepository;
import com.teckUP.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;

    }

    @PatchMapping(path = "/add")
    @ResponseBody
    Admin addnewadmin(@RequestParam String nom, @RequestParam String email) {
        Admin springadmin = new Admin();

        springadmin.setNom(nom);
        springadmin.setEmail(email);


        adminRepository.save(springadmin);
        return springadmin;


    }
}
