package fr.esiea.ex4A.hello.repository;

import fr.esiea.ex4A.data.MatchInfo;
import fr.esiea.ex4A.data.UserInfo;
import fr.esiea.ex4A.repository.UserRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {

    private final UserRepository userRepository = new UserRepository();

    @Test
    public void getUserByNameTest() {
        String name = "toto";
        String email = "toto@toto.fr";
        String tweeter = "totolatomate";
        String country = "FR";
        String sex = "M";
        String sexPref = "F";
        UserInfo userExist = userRepository.getUserByName(name);
        assertNotNull(userExist);
        assertEquals(name, userExist.userName);
        assertEquals(email, userExist.userEmail);
        assertEquals(tweeter, userExist.userTweeter);
        assertEquals(country, userExist.userCountry);
        assertEquals(sex, userExist.userSex);
        assertEquals(sexPref, userExist.userSexPref);

        UserInfo userNull = userRepository.getUserByName("unknown");
        assertNull(userNull);
    }

    @Test
    public void addUserTest() {
        assertEquals(4, userRepository.userInfos.size());
        userRepository.addUser(new UserInfo("test@test.fr", "test", "test", "FR", "O", "O"));
        assertEquals(5, userRepository.userInfos.size());
    }

    @Test
    public void userMatchTest() {
        UserInfo userInfo = new UserInfo("test@test.fr", "test", "test", "FR", "O", "O");
        UserInfo userInfo2 = new UserInfo("test2@test.fr", "test2", "test2", "FR", "O", "M");
        UserInfo userInfo3 = new UserInfo("test3@test.fr", "test3", "test3", "FR", "O", "F");

        userRepository.addUser(userInfo);
        List<MatchInfo> matchInfoList = userRepository.userMatch(userInfo.userName);
        assertEquals(0, matchInfoList.size());

        matchInfoList.clear();
        userRepository.addUser(userInfo2);
        matchInfoList = userRepository.userMatch(userInfo2.userName);
        assertEquals(2, matchInfoList.size());

        matchInfoList.clear();
        userRepository.addUser(userInfo3);
        matchInfoList = userRepository.userMatch(userInfo3.userName);
        assertEquals(2, matchInfoList.size());
    }
}
