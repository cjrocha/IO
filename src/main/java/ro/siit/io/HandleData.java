package ro.siit.io;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HandleData {

/**    public static int handlePenalties() {
        ReadInput s = new ReadInput();
        int totalPenalty = 0;
        for (Athlete entry : s.readInputData()) {
            Character penalty = 'o';
            String firstMissed = entry.getFirstShootingRange();
            int fCount = 0;
            for (int i = 0; i < firstMissed.length(); i++) {
                if (firstMissed.charAt(i) == penalty) {
                    fCount++;
                }
            }
            int fPenalty = fCount * 10;
            String secondMissed = entry.getSecondShootingRange();
            int sCount = 0;
            for (int i = 0; i < firstMissed.length(); i++) {
                if (secondMissed.charAt(i) == penalty) {
                    sCount++;
                }
            }
            int sPenalty = sCount * 10;
            String thirdMissed = entry.getThirdShootingeRange();
            int tCount = 0;
            for (int i = 0; i < thirdMissed.length(); i++) {
                if (thirdMissed.charAt(i) == penalty) {
                    tCount++;
                }
            }
            int tPenalty = tCount * 10;
            totalPenalty = fPenalty + sPenalty + tPenalty;
        }
        return totalPenalty;
    }*/
}
