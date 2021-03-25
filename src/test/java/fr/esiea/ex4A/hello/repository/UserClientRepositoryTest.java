package fr.esiea.ex4A.hello.repository;

import fr.esiea.ex4A.data.UserInfo;
import fr.esiea.ex4A.repository.UserRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserClientRepositoryTest {

    private final UserRepository userRepository = new UserRepository();

    @Test
    public void getUserTest() {
        String name = "toto";
        String email = "toto@toto.fr";
        String tweeter = "totolatomate";
        String country = "FR";
        String sex = "M";
        String sexPref = "F";
        userRepository.addUser(new UserInfo(email, name, tweeter, country, sex, sexPref));
        UserInfo userExist = userRepository.getUser(name, country);
        assertEquals(name, userExist.name);
        assertEquals(email, userExist.email);
        assertEquals(tweeter, userExist.twitter);
        assertEquals(country, userExist.country);
        assertEquals(sex, userExist.sex);
        assertEquals(sexPref, userExist.sexPref);

        UserInfo userNull = userRepository.getUser("unknown", "F");
        assertNull(userNull);
    }

    @Test
    public void addUserTest() {
        assertEquals(0, userRepository.userInfos.size());
        userRepository.addUser(new UserInfo("test@test.fr", "test", "test", "FR", "O", "O"));
        assertEquals(1, userRepository.userInfos.size());
    }

    @Test
    public void userMatchTest() {
        UserInfo userInfo = new UserInfo("test@test.fr", "test", "test", "FR", "M", "O");
        UserInfo userInfo2 = new UserInfo("test2@test.fr", "test2", "test2", "FR", "O", "M");
        UserInfo userInfo3 = new UserInfo("test3@test.fr", "test3", "test3", "FR", "O", "F");

        userRepository.addUser(userInfo);
        userRepository.cacheData.put(userInfo, 25);
        List<UserInfo> matchInfoList = userRepository.userMatch(userInfo);
        assertEquals(0, matchInfoList.size());

        matchInfoList.clear();
        userRepository.addUser(userInfo2);
        userRepository.cacheData.put(userInfo2, 29);
        matchInfoList = userRepository.userMatch(userInfo2);
        assertEquals(1, matchInfoList.size());

        matchInfoList.clear();
        userRepository.addUser(userInfo3);
        userRepository.cacheData.put(userInfo3, 26);
        matchInfoList = userRepository.userMatch(userInfo3);
        assertEquals(0, matchInfoList.size());
    }
}
