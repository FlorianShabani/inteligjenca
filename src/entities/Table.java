package entities;

import java.util.ArrayList;

public class Table {
    public double fitness;

    ArrayList<Match> matches = new ArrayList<>();
    
    public Match[] geMatches() {
        return (Match[]) matches.toArray();
    }

    public void applyFitness(Double fitness) {
        this.fitness += fitness;
    }
}
