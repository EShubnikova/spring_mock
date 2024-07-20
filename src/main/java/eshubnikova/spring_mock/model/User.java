package eshubnikova.spring_mock.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class User {
    @NotBlank(message = "username must not be blank")
    private String username;
    @NotBlank(message = "password must not be blank")
    private String password;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDate date;

    public User() { }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(String username, String password, LocalDate date) {
        this(username, password);
        this.date = date;
    }
    
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public LocalDate getDate() {
        return date;
    }
    public boolean usernameExists() {
        return username != null;
    }
    public boolean passwordExists() {
        return password != null;
    }
    public boolean dateExists() {
        return date != null;
    }
}
