package utilities;

import java.util.ArrayList;

import constraints.HardConstraint;
import constraints.SoftConstraint;
import entities.Match;
import entities.Table;

public class Genetic {

    int weeks;

    ArrayList<HardConstraint> hardConstraints = new ArrayList<>();
    ArrayList<SoftConstraint> softConstraints = new ArrayList<>();
    

    public Genetic(int weeks) {
        this.weeks = weeks;
    }

    public void addHardConstraint(HardConstraint hardConstraint) {
        hardConstraints.add(hardConstraint);
    }

    public void addSoftConstraint(SoftConstraint softConstraint) {
        softConstraints.add(softConstraint);
    }

    public static Table crossOver(Table table) {
        return null;
    }

    public static Table mutate(Table table) {

        return null;
    }

    public static Table evaluate(Table table) {
        return null;
    }

    public Match mutateMatch(Match m) {

        // TODO Simulated Annealing

        Match match = m.clone();
        match.setStartTime(
            ((match.getStartTime() + (int)(Math.random() * 1440)) % 1440)
        );

        match.setWeek(
            ((match.getWeek() + (int)(Math.random() * weeks)) % weeks)
        );

        return match;
    }
}






