package constraints;

import entities.Match;

public abstract class SoftConstraint {
    public final double evaluate(Match[] matches) {
        return applyConstraint(matches);
    }

    public abstract double applyConstraint(Match[] matches);
}
