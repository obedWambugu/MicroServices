package com.wambuguobed.user_service.controller;
import com.wambuguobed.user_service.VO.ResponseTemplateVO;
import com.wambuguobed.user_service.service.UserService;
import com.wambuguobed.user_service.entity.DepartmentUser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public DepartmentUser saveUser(@RequestBody DepartmentUser departmentUser) {
        log.info("Inside saveUser method of UserController");
        return userService.saveUser(departmentUser);
    }
    /*@GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long departmentId) {
        log.info("Inside findUserById method of UserController");
        return userService.findUserById(departmentId);
    }*/
    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside getUserWithDepartment method of UserController");
        return userService.getUserWithDepartment(userId);
    }

}
