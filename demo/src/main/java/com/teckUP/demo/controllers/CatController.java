package com.teckUP.demo.controllers;

import com.teckUP.demo.models.Adresse;
import com.teckUP.demo.models.User;
import com.teckUP.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(path = "/user")
public class  CatController {
    private final UserRepository userRepository;

    @Autowired
    public CatController(UserRepository userRepository) {

        this.userRepository = userRepository;
    }


    @PostMapping(path = "/add")
    @ResponseBody
    User addnewuser(@RequestParam String nom, @RequestParam String email) {
        User springuser = new User();

        springuser.setNom(nom);
        springuser.setEmail(email);


        userRepository.save(springuser);
        return springuser;


    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllusers() {
        return userRepository.findAll();


    }

    @DeleteMapping(path = "/delete")
    @ResponseBody
    public ResponseEntity<String> deleteUser(@RequestParam Integer id) {

        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.ok("User with id " + id + " has been deleted");
        }

        return null;
    }
    @PutMapping(path = "/update")
    @ResponseBody
    public ResponseEntity<String> updateUser(
            @RequestParam Integer id,
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) String email
    ) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + id);
        }

        User user = optionalUser.get();
        if (nom != null) user.setNom(nom);  // Assurez-vous que le setter est correct (setNom vs setMom)
        if (email != null) user.setEmail(email);

        userRepository.save(user);
        return ResponseEntity.ok("User with id " + id + " has been updated");
    }
























}






//    public String showHtmlPage() {
//        return "index"; // This should match the HTML filename without .html
//    }
