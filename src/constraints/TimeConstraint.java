package constraints;

import entities.Match;

public class TimeConstraint extends SoftConstraint{

    @Override
    public double applyConstraint(Match[] matches) {
        double res = (840) * matches.length;
        for(Match match : matches) {
            if(match == null) continue;
            res -= Math.abs(match.getStartTime() - 840); // max = 720
        }
        return res;
    }
}
