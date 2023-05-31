package constraints;

import java.util.HashSet;

import entities.Match;
import entities.Team;

public class SameDayConstraint extends HardConstraint {
    // Matches sorted before constrained
    @Override
    public boolean applyConstraint(Match[] matches) {
        int day;
        HashSet<Team> teamsOnDay = new HashSet<Team>();
        l: for (int i = 0; i < matches.length; i++) {
            if (matches[i] == null)
                continue l;

            day = matches[i].day;
            teamsOnDay.clear();
            while (true) {
                if (i >= matches.length)
                    break;
                if (matches[i] == null) {
                    i++;
                    continue;
                }
                if (matches[i].day != day)
                    break;

                if (teamsOnDay.contains(matches[i].t1) | teamsOnDay.contains(matches[i].t2)) {
                    return false;
                }
                teamsOnDay.add(matches[i].t1);
                teamsOnDay.add(matches[i].t2);
                i++;
            }
        }
        return true;
    }

}
