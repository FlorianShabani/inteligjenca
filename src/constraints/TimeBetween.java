package constraints;

import entities.Match;

public class TimeBetween extends SoftConstraint{

    // Table is sorted before evaluation
    // If matches are on the same day, favor those that do not have time in between;
    @Override
    public double applyConstraint(Match[] matches) {
        double res = 0;
        Match prev = matches[0];
        for(int i = 1; i < matches.length; i++) {
            Match match = matches[i];
            if(match.day == prev.day) {
                res -= Math.abs(match.getStartTime() - prev.getStartTime());
            }
            prev = match;
        }
        return res;
    }

}
