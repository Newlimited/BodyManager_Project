package com.groupd.bodymanager.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupd.bodymanager.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{

    public boolean existsByUserEmail(String email);
    public boolean existsByUserNickname(String nickName);
    public boolean existsByUserPhoneNumber(String phoneNumber);

    public UserEntity findByUserEmail(String email);
    public UserEntity findByUserCode(int userCode);
}
