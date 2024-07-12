package eshubnikova.spring_mock.controller;

import eshubnikova.spring_mock.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.Random;

@RestController
public class Controller {

    @GetMapping("/user")
    public ResponseEntity<?> handleGetRequest() {
        try {
            Random random = new Random();
            Thread.sleep((long) ((random.nextDouble() + 1) * 1000));
            return new ResponseEntity(new User("username", "password"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/user-date")
    public ResponseEntity<?> handlePostRequest(@RequestBody User user) {
        if (!user.usernameExists() || !user.passwordExists() || user.dateExists()) {
            throw new HttpMessageNotReadableException("wrong JSON format"); }
        try {
            Random random = new Random();
            Thread.sleep((long) ((random.nextDouble() + 1) * 1000));
            return ResponseEntity.ok(new User(user.getUsername(), user.getPassword(), LocalDate.now()));
        } catch (HttpMessageNotReadableException hmnre) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
