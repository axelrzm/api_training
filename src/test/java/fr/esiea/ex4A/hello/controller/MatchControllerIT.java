package fr.esiea.ex4A.hello.controller;

import fr.esiea.ex4A.data.MatchInfo;
import fr.esiea.ex4A.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class MatchControllerIT {

    private final MockMvc mockMvc;

    @MockBean
    private UserRepository repository;

    public MatchControllerIT(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void matchesThenReturnsListOfUsers() throws Exception {

        when(repository.userMatch(any())).thenReturn(List.of(new MatchInfo("toto", "toto")));

        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/matches?userName=toto&userCountry=FR"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].name").value("toto"))
            .andExpect(jsonPath("$[0].twitter").value("toto"));

        verify(repository).userMatch("toto");
    }

}
