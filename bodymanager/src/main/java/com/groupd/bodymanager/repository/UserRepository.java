package com.groupd.bodymanager.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.groupd.bodymanager.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{

    public boolean existsByEmail(String email);
    public boolean existsByNickname(String nickName);
    public boolean existsByPhoneNumber(String phoneNumber);

    public UserEntity findByEmail(String email);
}
