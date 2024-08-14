package com.wambuguobed.user_service.service;

import com.wambuguobed.user_service.VO.Department;
import com.wambuguobed.user_service.VO.ResponseTemplateVO;
import com.wambuguobed.user_service.entity.DepartmentUser;
import com.wambuguobed.user_service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public DepartmentUser saveUser(DepartmentUser departmentUser) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(departmentUser);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        DepartmentUser departmentUser = userRepository.findByUserId(userId);
        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + departmentUser.getDepartmentId(), Department.class);

        vo.setDepartmentUser(departmentUser);
        vo.setDepartment(department);

        return vo;
    }
}
