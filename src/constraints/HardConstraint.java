package constraints;

import entities.Match;
import entities.Table;

public abstract class HardConstraint{
    public final boolean evaluate(Table t) {
        return applyConstraint(t.getMatches());
    }

    public abstract boolean applyConstraint(Match[] matches);
}
