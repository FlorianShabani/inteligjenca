package constraints;

import entities.Match;

public class Collision extends HardConstraint {

    @Override
    public boolean applyConstraint(Match[] matches) {
        boolean collision = false;
        for (Match m1 : matches) {
            for (Match m2 : matches) {
                if(collide(m1, m2)) collision = true;
            }
        }
        return collision;
    }

    public static boolean collide(Match m1, Match m2) {
        if (m1.getStartTime() > m2.getStartTime() && m1.getStartTime() < m2.getEndTime())
            return true;
        if (m2.getStartTime() > m1.getStartTime() && m2.getStartTime() < m1.getEndTime())
            return true;
        return false;
    }
}
