package entities;

import java.util.ArrayList;

public class Table {
    public double fitness;

    ArrayList<Team> teams = new ArrayList<>();
    ArrayList<Match> matches = new ArrayList<>();
    
    public Table() {

    }

    public Match[] getMatches() {
        return (Match[]) matches.toArray();
    }

    public void applyFitness(Double fitness) {
        this.fitness += fitness;
    }
}
