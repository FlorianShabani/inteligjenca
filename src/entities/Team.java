package entities;

import java.util.ArrayList;

public class Team {
    ArrayList<Match> matches = new ArrayList<>();

    

    public void addMatch(Match match) {
        matches.add(match);
    }
}
