package com.akinnova.basicweb.controller;

import com.akinnova.basicweb.model.Users;
import com.akinnova.basicweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/users/view")
    public String getAllUsers(){
        System.out.println("Getting all users");
        // TODO: 19/11/2023 Initialize a list of users here
        List<Users> userList = new ArrayList<>();
//        userList.add(new Users("Ade", "1234", 18));
//        userList.add(new Users("Nosa", "1890", 17));
//        userList.add(new Users("Christa", "1209", 18));
//        userList.add(new Users("Bode", "1774", 17));

        //model.attribute("us", userList);

        return "users/showAll";
    }

    @PostMapping("/users/add")
    public String addusers(){
        for(int i = 0; i < 5; i++){
            Users users = new Users();

            users.setAge(i);
            users.setName("Adex"+1);
            users.setPassword("12"+i);

            userRepository.save(users);
        }

        return "users all saved!!";
    }

    @GetMapping("/userByName/{name}/{password}")
    public List<Users> fetUser (@Param("name") String name, @Param("password") String password){
        List<Users> userList = userRepository.findByNameAndPassword(name, password);

        return userList;
    }

    @GetMapping("/allUsers")
    public List<Users> allUsers(){
        List<Users> userList = userRepository.findAll();

        return userList;
    }

    @GetMapping("/justGreeting")
    public String sayHello(){
        return "Hello there!!";
    }
}
