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

    int mutateMatchCount;
    double mutateStrength = 0.1;

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
        Table t = new Table(m1, t1);
        //System.out.println(t1 + " " + t2);
        return t;
    }

    public boolean checkHardConstraints(Match[] matches) {
        for (HardConstraint hardConstraint : hardConstraints) {
            if (!hardConstraint.evaluate(matches)) {
                return false;
            }
        }
        return true;
    }
    
    public void mutate(Table table, int gen) {
        Match[] matches = table.getMatches();
        //Simulated annealing
        mutateMatchCount =  (int) (1.0 / (gen + 5) * matches.length) + 1;
        v: for (int i = 0; i < mutateMatchCount; i++) {
            for (int j = 0; j < 10; j++) {
                int randomIndex = (int) (Math.random() * matches.length);
                
                Match mut = mutateMatch(matches[randomIndex]);
                Match old = matches[randomIndex];

                table.setMatch(mut, randomIndex);
                matches[randomIndex] = mut;

                if (!checkHardConstraints(matches)) {
                    matches[randomIndex] = old;
                    table.setMatch(old, randomIndex);
                    continue;
                } else {
                    continue v;
                }
            }
        }
    }

    public void evaluate(Table table) {
        table.fitness = 0; // Starting eval
        table.sortMatches();
        for (SoftConstraint constraint : softConstraints) {
            table.applyFitness(constraint.evaluate(table.getMatches()));
        }
    }

    public Match mutateMatch(Match m) {
        Match match = m.clone();
        match.setStartTime(
                (match.getStartTime() + (int) ((Math.random() * 1440)* mutateStrength)) % 1440);

        match.setDay(
                (match.getDay() + (int) ((Math.random() * days) * mutateStrength)) % days);
        return match;
    }

    public void addHardConstraint(HardConstraint hardConstraint) {
        hardConstraints.add(hardConstraint);
    }

    public void addSoftConstraint(SoftConstraint softConstraint) {
        softConstraints.add(softConstraint);
    }
}
