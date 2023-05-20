package constraints;

import entities.Match;
import entities.Table;

public abstract class Constraint {
    public final void evaluate(Table t) {
        t.applyFitness(applyConstraint(t.geMatches()));
    }

    public abstract double applyConstraint(Match[] matches);
}
