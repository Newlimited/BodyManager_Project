package com.groupd.bodymanager.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupd.bodymanager.entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{

    public boolean existsByEmail(String email);
    public boolean existsByNickname(String nickName);
    public boolean existsByPhoneNumber(String phoneNumber);

    public UserEntity findByEmail(String email);
    public UserEntity findByUserCode(int userCode);
}
