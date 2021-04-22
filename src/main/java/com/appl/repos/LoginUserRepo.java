package com.appl.repos;

import com.appl.entities.LoginUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUserRepo extends CrudRepository<LoginUser,Integer> {

    LoginUser findByUsername(String username);
}
