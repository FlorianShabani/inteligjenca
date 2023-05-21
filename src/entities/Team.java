package entities;

import java.util.ArrayList;

public class Team {
    ArrayList<Match> matches = new ArrayList<>();

    public void addMatch(Match match) {
        matches.add(match);
    }

    public Match[] geMatchs() {
        return (Match[]) matches.toArray();
    }
}
