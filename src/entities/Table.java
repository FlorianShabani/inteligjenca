package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import utilities.Genetic;

public class Table {
    public double fitness;

    public ArrayList<Team> teams = new ArrayList<>();
    public ArrayList<Match> matches = new ArrayList<>();

    public Table(Match[] matches, Table table) {
        this.matches = new ArrayList<>(Arrays.asList(matches));
        this.teams = table.teams;
    }

    public Table(Match[] matches, ArrayList<Team> teams) {
        this.matches = new ArrayList<>(Arrays.asList(matches));
        this.teams = teams;
    }

    public Table(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public void setMatch(Match match, int i) {
        matches.set(i, match);
    }

    public Match[] getMatches() {
        Match[] res = new Match[matches.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = matches.get(i);
        }
        return res;
    }

    public void applyFitness(double fitness) {
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

    @Override
    public String toString() {
        String s = "";
        for (Match m : matches) {
            s += m.startTime + " " + m.endTime + " " + m.day + " " + fitness +  "|";
        }
        return s;
    }

    public void generateMatches(Genetic g) {
        Match[] matches = new Match[teams.size() * teams.size()];
        for (int i = 0; i < teams.size(); i++) {
            for (int j = 0; j < teams.size(); j++) {
                while (true) {
                    int randomDay = (int) (Math.random() * Population.days);
                    int randomStart = (int) (Math.random() * 1440);
                    Match m = new Match(randomStart, randomDay, teams.get(i), teams.get(j));
                    matches[i * teams.size() + j] = m;
                    if (g.checkHardConstraints(matches)) {
                        break;
                    }
                    else {
                        matches[i * teams.size() + j] = null;
                    }
                }
            }
        }
        System.out.println(g.checkHardConstraints(matches));
        this.matches = new ArrayList<>(Arrays.asList(matches));
        g.evaluate(this);
    }
}
