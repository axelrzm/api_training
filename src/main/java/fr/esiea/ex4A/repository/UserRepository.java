package fr.esiea.ex4A.repository;

import fr.esiea.ex4A.data.MatchInfo;
import fr.esiea.ex4A.data.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    public final List<UserInfo> userInfos;

    public UserRepository() {
        userInfos = new ArrayList<>();
        userInfos.add(new UserInfo("toto@toto.fr", "toto", "totolatomate", "FR", "M", "F"));
        userInfos.add(new UserInfo("titi@titi.fr", "titi", "titille", "FR", "M", "M"));
        userInfos.add(new UserInfo("tata@tata.fr", "tata", "tatache", "FR", "F", "M"));
        userInfos.add(new UserInfo("tete@tete.fr", "tete", "teteau", "FR", "F", "F"));
    }

    public UserInfo getUserByName(String name) {
        return userInfos.stream().filter(userInfo -> userInfo.userName.equals(name)).findAny().orElse(null);
    }

    public void addUser(UserInfo userInfo) {
        userInfos.add(userInfo);
    }

    public List<MatchInfo> userMatch(String name) {
        List<MatchInfo> matchInfos = new ArrayList<>();
        UserInfo user = getUserByName(name);
        List<UserInfo> userInfosFiltered = userInfos.stream().filter(userInfo -> userInfo.userSexPref.equals(user.userSexPref) && !userInfo.userName.equals(user.userName)).collect(Collectors.toList());
        userInfosFiltered.forEach(userInfo -> matchInfos.add(new MatchInfo(userInfo.userName, userInfo.userTweeter)));
        return matchInfos;
    }

}
