package fr.esiea.ex4A.controller;

import fr.esiea.ex4A.data.MatchInfo;
import fr.esiea.ex4A.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class MatchController {

    private final UserRepository userRepository;

    public MatchController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/api/matches")
    public List<MatchInfo> matches(@RequestParam String userName, @RequestParam String userCountry) {
        return userRepository.userMatch(userName);
    }
}
