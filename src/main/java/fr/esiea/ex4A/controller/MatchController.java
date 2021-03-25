package fr.esiea.ex4A.controller;

import fr.esiea.ex4A.data.UserInfo;
import fr.esiea.ex4A.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatchController {

    private final UserService userService;

    public MatchController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/matches")
    public List<UserInfo> matches(@RequestParam String userName, @RequestParam String userCountry) {
        return userService.matches(userName, userCountry);
    }
}
