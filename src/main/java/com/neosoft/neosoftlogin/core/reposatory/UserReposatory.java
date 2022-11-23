package com.neosoft.neosoftlogin.core.reposatory;

import com.neosoft.neosoftlogin.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposatory extends JpaRepository<User, Long> {

    User findByMobileNo(String mobileNo);
    User findByMobileNoAndEmailId(String mobileNo, String emailId);
    User findByEmailId(String emailId);
    User findByEmailIdAndPassword(String emailId, String password);
    User findByMobileNoAndPassword(String mobileNo, String password);
    User findByUserId(Long userId);
}
