package fr.esiea.ex4A.controller;

import fr.esiea.ex4A.data.UserInfo;
import fr.esiea.ex4A.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class InscriptionController {

    private final UserRepository userRepository;

    public InscriptionController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/api/inscription")
    public void inscription(@RequestBody UserInfo userInfo) {
        userRepository.addUser(userInfo);
    }

}
