package fr.esiea.ex4A.hello.data;

import fr.esiea.ex4A.data.UserInfo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserInfoTest {

    @Test
    public void userToStringTest() {
        String name = "test";
        String email = "test@test.fr";
        String twitter = "test";
        String country = "FR";
        String sex = "M";
        String sexPref = "O";
        UserInfo userInfo = new UserInfo(email, name, twitter, country, sex, sexPref);
        String expectedString = "{" +
            "email: " + email + "," +
            "name: " + name + "," +
            "twitter: " + twitter + "," +
            "country: " + country + "," +
            "sex: " + sex + "," +
            "sexPref: " + sexPref + "," +
            "}";
        assertEquals(expectedString, userInfo.toString());
    }

    @Test
    public void userEqualsTest() {
        UserInfo userInfo = new UserInfo("test@test.fr", "test", "test", "FR", "M", "O");
        UserInfo userInfo2 = new UserInfo("test@test.fr", "test", "test", "FR", "M", "O");
        UserInfo userInfo3 = new UserInfo("test@test.fr", "test2", "test", "FR", "M", "O");
        UserInfo userInfo4 = new UserInfo("test@test.fr", "test", "test", "US", "M", "O");

        assertEquals(userInfo, userInfo2);
        assertNotEquals(userInfo, userInfo3);
        assertNotEquals(userInfo, userInfo4);
    }

}
