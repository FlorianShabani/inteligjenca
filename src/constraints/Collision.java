package constraints;

import entities.Match;

public class Collision extends HardConstraint {

    @Override
    public boolean applyConstraint(Match[] matches) {
        for (Match m1 : matches) {
            for (Match m2 : matches) {
                if (m1 == null || m2 == null)
                    continue;
                if (collide(m1, m2))
                    return false;
            }
        }
        return true;
    }

    public static boolean collide(Match m1, Match m2) {
        if (m1.day == m2.day && (m1.t1 == m2.t1 || m1.t1 == m2.t2)) {
            if (m1.getStartTime() > m2.getStartTime() && m1.getStartTime() < m2.getEndTime())
                return true;
            if (m2.getStartTime() > m1.getStartTime() && m2.getStartTime() < m1.getEndTime())
                return true;
        }
        return false;
    }
}
