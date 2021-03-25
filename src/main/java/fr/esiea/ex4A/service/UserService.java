package fr.esiea.ex4A.service;

import fr.esiea.ex4A.data.UserClient;
import fr.esiea.ex4A.data.UserInfo;
import fr.esiea.ex4A.repository.UserRepository;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AgifyClient agifyClient;

    public UserService(UserRepository userRepository, AgifyClient agifyClient) {
        this.userRepository = userRepository;
        this.agifyClient = agifyClient;
    }

    public void registerUser(UserInfo userInfo) throws IOException {
        if (userRepository.getUser(userInfo.name, userInfo.country) == null) {
            UserClient userClient = getUserClient(userInfo.name, userInfo.country);
            userRepository.cacheData.put(userInfo, userClient.age);
            userRepository.addUser(userInfo);
        }
    }

    public List<UserInfo> matches(String name, String country) {
        UserInfo userInfo = userRepository.getUser(name, country);
        return userRepository.userMatch(userInfo);
    }

    public UserClient getUserClient(String name, String country) throws IOException {
        Call<ResponseBody> call = agifyClient.getUser(name, country);
        Response<ResponseBody> response = call.execute();
        JSONObject jsonObject = new JSONObject(response.body().string());
        return new UserClient(jsonObject.getString("name"), jsonObject.getInt("age"), jsonObject.getInt("count"), jsonObject.getString("country_id"));
    }

}
