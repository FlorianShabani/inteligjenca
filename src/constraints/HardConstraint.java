package constraints;

import entities.Match;

public abstract class HardConstraint{
    public final boolean evaluate(Match[] matches) {
        return applyConstraint(matches);
    }

    public abstract boolean applyConstraint(Match[] matches);
}
