package com.wambuguobed.user_service.repository;

import com.wambuguobed.user_service.entity.DepartmentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<DepartmentUser, Long> {

    DepartmentUser findByUserId(Long userId);
}
