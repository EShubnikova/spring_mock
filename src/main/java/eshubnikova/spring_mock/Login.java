package eshubnikova.spring_mock;

public record Login(String username, String password) {
public String getLogin() {
    return this.username;
}
public String getPassword() {
    return this.password;
}
}


