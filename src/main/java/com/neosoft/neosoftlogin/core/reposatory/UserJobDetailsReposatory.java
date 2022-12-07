package com.neosoft.neosoftlogin.core.reposatory;

import com.neosoft.neosoftlogin.core.entity.UserJobDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserJobDetailsReposatory extends JpaRepository<UserJobDetails, Long> {
    UserJobDetails findByUserDetailsId(Long userId);
    List<UserJobDetails> findByUserIdAndActiveStatus(Long userId, boolean flag);
}
