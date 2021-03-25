package fr.esiea.ex4A.controller;

import fr.esiea.ex4A.data.UserInfo;
import fr.esiea.ex4A.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class InscriptionController {

    private final UserService userService;

    public InscriptionController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/inscription")
    public void inscription(@RequestBody UserInfo userInfo) throws IOException {
        userService.registerUser(userInfo);
    }

}
