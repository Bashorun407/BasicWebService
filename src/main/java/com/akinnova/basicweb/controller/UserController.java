package com.akinnova.basicweb.controller;

import com.akinnova.basicweb.model.User;
import com.akinnova.basicweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        List<User> userList = new ArrayList<>();
//        userList.add(new User("Ade", "1234", 18));
//        userList.add(new User("Nosa", "1890", 17));
//        userList.add(new User("Christa", "1209", 18));
//        userList.add(new User("Bode", "1774", 17));

        //model.attribute("us", userList);

        return "users/showAll";
    }

    @PostMapping("/users/add")
    public String addusers(){
        for(int i = 0; i < 5; i++){
            User user = new User();
            user.setAge(i);
            user.setName("Adex"+1);
            user.setPassword("12"+i);

            userRepository.save(user);
        }

        return "users all saved!!";
    }

    @GetMapping("/userByName/{name}/{password}")
    public List<User> fetUser (@Param("name") String name, @Param("password") String password){
        List<User> userList = userRepository.findByNameAndPassword(name, password);

        return userList;
    }
}
