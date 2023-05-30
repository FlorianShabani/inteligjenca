package constraints;

import entities.Match;

public class TimeConstraint extends SoftConstraint{

    @Override
    public double applyConstraint(Match[] matches) {
        double res = 0;
        for(Match match : matches) {
            if(match == null) continue;
            res += Math.abs(match.getStartTime() - 1440/2);
        }
        return res;
    }
}
