package constraints;

import entities.Match;

public class ConcurrentGames extends SoftConstraint {

    @Override
    public double applyConstraint(Match[] matches) {
        double res = 0;
            for (Match m1 : matches) {
                for (Match m2 : matches) {
                    if (m1 == null || m2 == null)
                        continue;
                    if (collide(m1, m2))
                        res -= 500;
                }
            }
            return res;
        }
    
        public static boolean collide(Match m1, Match m2) {
            if (m1.day == m2.day) {
                if (m1.getStartTime() > m2.getStartTime() && m1.getStartTime() < m2.getEndTime())
                    return true;
                if (m2.getStartTime() > m1.getStartTime() && m2.getStartTime() < m1.getEndTime())
                    return true;
            }
            return false;        
    }
    
}
