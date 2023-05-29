package utilities;

import java.util.ArrayList;

import constraints.HardConstraint;
import constraints.SoftConstraint;
import entities.Match;
import entities.Table;

public class Genetic {

    int days;

    ArrayList<HardConstraint> hardConstraints = new ArrayList<>();
    ArrayList<SoftConstraint> softConstraints = new ArrayList<>();

    int mutateMatchCount = 1;
    double mutateStrength = 1;

    public Genetic(int days) {
        this.days = days;
    }

    public Table crossOver(Table t1, Table t2) {
        t1.sortMatches();
        t2.sortMatches();
        Match[] m1 = t1.getMatches();
        Match[] m2 = t2.getMatches();

        int n = m1.length;
        for (int i = 0; i < 10; i++) {
            int k = (int) (Math.random() * n);
            Match[] new1 = new Match[n];

            for (int j = 0; j < k; j++) {
                new1[j] = m1[j];
            }
            for (int j = k; j < n; j++) {
                new1[j] = m2[j];
            }

            if (!checkHardConstraints(new1)) {
                continue;
            }
            m1 = new1;
        }

        return new Table(m1, t1);
    }

    public boolean checkHardConstraints(Match[] matches) {
        for (HardConstraint hardConstraint : hardConstraints) {
            if (!hardConstraint.evaluate(matches))
                return false;
        }
        return true;
    }

    public void mutate(Table table) {
        // TODO Simulated Annealing
        v: for (int i = 0; i < mutateMatchCount; i++) {
            for (int j = 0; j < 10; j++) {
                Match[] matches = table.getMatches();
                int randomIndex = (int) (Math.random() * matches.length);

                Match mut = mutateMatch(matches[randomIndex]);
                Match old = matches[randomIndex];

                table.setMatch(mut, randomIndex);

                if (!checkHardConstraints(matches)) {
                    table.setMatch(old, randomIndex);
                    continue;
                } else {
                    continue v;
                }
            }
        }
    }

    public void evaluate(Table table) {
        for (SoftConstraint constraint : softConstraints) {
            table.applyFitness(constraint.evaluate(table.getMatches()));
        }
    }

    public Match mutateMatch(Match m) {
        Match match = m.clone();
        match.setStartTime(
                (match.getStartTime() + (int) (((Math.random() * 1440) % 1440) * mutateStrength)));

        match.setDay(
                (match.getDay() + (int) (((Math.random() * days) % days) * mutateStrength)));
        return match;
    }

    public void addHardConstraint(HardConstraint hardConstraint) {
        hardConstraints.add(hardConstraint);
    }

    public void addSoftConstraint(SoftConstraint softConstraint) {
        softConstraints.add(softConstraint);
    }
}
