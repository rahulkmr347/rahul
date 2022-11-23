package com.neosoft.neosoftlogin.core.reposatory;

import com.neosoft.neosoftlogin.core.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJobDetailsReposatory extends JpaRepository<UserDetails, Long> {
}
