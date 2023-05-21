package utilities;

import java.util.ArrayList;
import java.util.Arrays;

import constraints.HardConstraint;
import constraints.SoftConstraint;
import entities.Match;
import entities.Population;
import entities.Table;

public class Genetic {

    int weeks;

    ArrayList<HardConstraint> hardConstraints = new ArrayList<>();
    ArrayList<SoftConstraint> softConstraints = new ArrayList<>();

    Population population = new Population();

    int mutateMatchCount = 1;
    int mutateTableCount = 1;

    public Genetic(int weeks) {
        this.weeks = weeks;
    }

    public Table crossOver(Table t1, Table t2) {
        Match[] m1 = t1.getMatches();
        Match[] m2 = t2.getMatches();

        

        return null;
    }

    public boolean checkHardConstraints(Match[] matches) {
        for (HardConstraint hardConstraint : hardConstraints) {
            if (!hardConstraint.evaluate(matches))
                return false;
        }
        return true;
    }

    public Table mutate(Table table) {
        // TODO Simulated Annealing
        for (int i = 0; i < mutateMatchCount; i++) {
            for (int j = 0; j < 10; j++) {
                Match[] matches = table.getMatches();
                int randomIndex = (int) (Math.random() * matches.length);

                Match mut = mutateMatch(matches[randomIndex]);
                Match old = matches[randomIndex];

                matches[randomIndex] = mut;
                if (!checkHardConstraints(matches)) {
                    matches[randomIndex] = old;
                    continue;
                } else {
                    table.matches = new ArrayList<>(Arrays.asList(matches));
                }
            }
        }
        return null;
    }

    public void evaluate(Table table) {
        for (SoftConstraint constraint : softConstraints) {
            table.applyFitness(constraint.evaluate(table.getMatches()));
        }
    }

    public Match mutateMatch(Match m) {
        Match match = m.clone();
        match.setStartTime(
                ((match.getStartTime() + (int) (Math.random() * 1440)) % 1440));

        match.setWeek(
                ((match.getWeek() + (int) (Math.random() * weeks)) % weeks));

        return match;
    }

    public void addHardConstraint(HardConstraint hardConstraint) {
        hardConstraints.add(hardConstraint);
    }

    public void addSoftConstraint(SoftConstraint softConstraint) {
        softConstraints.add(softConstraint);
    }
}
