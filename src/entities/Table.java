package entities;

import java.util.ArrayList;

public class Table {
    public double fitness;

    ArrayList<Team> teams = new ArrayList<>();
    public ArrayList<Match> matches = new ArrayList<>();
    
    public Table() {

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

    public Match getRandomMatch () {
        return matches.get((int)(Math.random() * matches.size()));
    }
}
