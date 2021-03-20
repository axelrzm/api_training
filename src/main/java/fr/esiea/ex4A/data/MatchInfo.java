package fr.esiea.ex4A.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MatchInfo {

    public final String name;
    public final String twitter;

    public MatchInfo(@JsonProperty("name") String name,
                     @JsonProperty("twitter") String twitter) {
        this.name = name;
        this.twitter = twitter;
    }

}
