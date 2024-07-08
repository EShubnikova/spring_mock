package eshubnikova.spring_mock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.Random;

@RestController
public class Controller {

    @GetMapping("/login")
    public Login login()  {
        try {
            Random random = new Random();
            Thread.sleep((long) ((random.nextDouble() + 1) * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Login("username","password");
    }

    @PostMapping("/login-date")
    public LoginDate loginDate() {
        Login login = new Login("request","request");
        try {
            Random random = new Random();
            Thread.sleep((long) ((random.nextDouble() + 1) * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        return new LoginDate(login.getLogin(), login.getPassword(), LocalDate.now());
    }
}
