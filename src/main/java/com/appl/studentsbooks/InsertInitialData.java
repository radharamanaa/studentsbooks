package com.appl.studentsbooks;


import com.appl.entities.LoginUser;
import com.appl.repos.LoginUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InsertInitialData{

    LoginUserRepo userRepo;
    @Autowired
    public void setUserRepo(LoginUserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Value("administrator")
    String defUserName;
    @Value("administrator")//need to get these from resources
    String defPassword;
    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationEvent() {
        if(userRepo.findByUsername(defUserName)==null){
            System.out.println("Default Data inserted :"+defUserName);
            userRepo.save(new LoginUser(defUserName,defPassword));
        }
    }
}
