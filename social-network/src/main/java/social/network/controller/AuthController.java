package social.network.controller;


import social.network.model.User;
import social.network.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password) {
        return authService.login(username, password);
    }
}
