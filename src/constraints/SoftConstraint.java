package constraints;

import entities.Match;
import entities.Table;

public abstract class SoftConstraint {
    public final void evaluate(Table t) {
        t.applyFitness(applyConstraint(t.getMatches()));
    }

    public abstract double applyConstraint(Match[] matches);
}
