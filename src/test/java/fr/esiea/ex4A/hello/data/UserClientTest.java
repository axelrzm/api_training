package fr.esiea.ex4A.hello.data;

import fr.esiea.ex4A.data.UserClient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserClientTest {

    @Test
    public void createUserClientTest() {
        UserClient userClient = new UserClient("test", 20, 1000, "FR");
        assertEquals("test", userClient.name);
        assertEquals(20, userClient.age);
        assertEquals(1000, userClient.count);
        assertEquals("FR", userClient.country_id);
    }

}
