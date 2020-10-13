package com.home.test.Controller;

import com.home.test.Dto.UserDto;
import com.home.test.Repository.UserRepository;
import com.home.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository UserRepo;

    @GetMapping("/users")
    public List<User> getUsers()
    {
        return this.UserRepo.findAll();
    }
    @PostMapping("/users")
    public String createUser(@RequestBody UserDto userdto){
        User user=new User();
        user.setAddress(userdto.getAddress());
        user.setId(userdto.getId());
         this.UserRepo.save(user);

         return "Successfully added !!";






    }
}
