package entities;

import java.util.ArrayList;

public class Team {
    ArrayList<Match> matches = new ArrayList<>();
    public static int count = 0;

    String name;
    public int id;

    public Team(String name) {
        this.id = count++;
        this.name = name;
    }

    public void addMatch(Match match) {
        matches.add(match);
    }

    public Match[] geMatchs() {
        return (Match[]) matches.toArray();
    }

    public String toString() {
        return name;
    }
}
