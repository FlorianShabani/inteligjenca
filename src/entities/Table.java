package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Table {
    public double fitness;

    public ArrayList<Team> teams = new ArrayList<>();
    public ArrayList<Match> matches = new ArrayList<>();

    public Table(Match[] matches, Table table) {
        this.matches = new ArrayList<>(Arrays.asList(matches));
        this.teams = table.teams;
    }

    public Match[] getMatches() {
        return (Match[]) matches.toArray();
    }

    public void applyFitness(Double fitness) {
        this.fitness += fitness;
    }

    public double getFitness() {
        return fitness;
    }

    public Match getRandomMatch() {
        return matches.get((int) (Math.random() * matches.size()));
    }

    public void sortMatches() {
        Collections.sort(matches, (m1, m2) -> {
            if (m1.day < m2.day)
                return -1;
            if (m1.day > m2.day)
                return 1;
            if (m1.getStartTime() < m2.getStartTime())
                return -1;
            return 0;
        });
    }
}
