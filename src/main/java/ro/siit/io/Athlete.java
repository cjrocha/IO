package ro.siit.io;


import java.util.logging.Logger;

public class Athlete {
    int AthleteNumber;
    String AthleteName;
    String CountryCode;
    String SkiTimeResult;
    String FirstShootingRange;
    String SecondShootingRange;
    String ThirdShootingeRange;
    Integer totalTime;

    private static Logger logger = Logger.getLogger("log.txt");
    /**
     * Athlete object constructor that requires:
     * @param athleteNumber - competition number
     * @param athleteName - The name of athlete
     * @param countryCode - country code of athlete
     * @param skiTimeResult - ski time result mm:ss
     * @param firstShootingRange - shooting range composed of x and o
     * @param secondShootingRange- shooting range composed of x and o
     * @param thirdShootingeRange- shooting range composed of x and o
     * Adds a total time of competitor = skiTime + penalties at shooting.
     */
    public Athlete(int athleteNumber, String athleteName, String countryCode, String skiTimeResult, String firstShootingRange, String secondShootingRange, String thirdShootingeRange) {

        AthleteNumber = athleteNumber;
        AthleteName = athleteName;
        CountryCode = countryCode;
        SkiTimeResult = skiTimeResult;
        FirstShootingRange = firstShootingRange;
        SecondShootingRange = secondShootingRange;
        ThirdShootingeRange = thirdShootingeRange;
        //HandleData k = new HandleData();
        totalTime = getSeconds(skiTimeResult) + getPenalties();
    }


    /**
     * Tranforms the ski time of an athlete into seconds
     * @param skiTimeResult - ski time mm:ss
     * @return - total no of seconds
     */
    public static int getSeconds(String skiTimeResult) {
        String[] parts = skiTimeResult.split(":");
        int n = parts.length;
        int formatedTime = 0;
        if(n == 2) {
            int toSeconds = Integer.parseInt(parts[0]) * 60;
            formatedTime = toSeconds + Integer.parseInt(parts[1]);
        }
        if(n == 3){
            int hoursToSeconds = Integer.parseInt(parts[0]) * 60 * 60;
            int minToSeconds = Integer.parseInt(parts[1]) * 60;
            formatedTime = hoursToSeconds + minToSeconds + Integer.parseInt(parts[1]);
        }
        logger.info("Athlete time in seconds is: " + formatedTime);
        return formatedTime;
    }

    /**
     * Transforms all missed targets from the 3 shooting stages
     * into panlty time. One miss equals 10 sec.
     * @return
     */
    public int getPenalties(){
        int totalPenalty = 0;
        int count = 0;
        Character penalty = 'o';
        for (int i=0; i<4; i++) {
            if (this.getFirstShootingRange().charAt(i) == penalty) {
                count++;
            }
            if (this.getSecondShootingRange().charAt(i) == penalty) {
                count++;
            }
            if (this.getThirdShootingeRange().charAt(i) == penalty) {
                count++;
            }
        }
        totalPenalty = count*10;
        logger.info("Athlete penalties are:  " + totalPenalty);
        return totalPenalty;
    }

    /**
     * Getters for Athlete data
     * @return - values of the athlete data
     */
    public int getAthleteNumber() {
        return AthleteNumber;
    }

    public String getAthleteName() {
        return AthleteName;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public String getSkiTimeResult() {
        return SkiTimeResult;
    }

    public String getFirstShootingRange() {
        return FirstShootingRange;
    }

    public String getSecondShootingRange() {
        return SecondShootingRange;
    }

    public String getThirdShootingeRange() {
        return ThirdShootingeRange;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    /**
     * gets the athlete data into readable format
     * @return
     */
    @Override
    public String toString() {
        return  "AthleteNumber=" + AthleteNumber +
                ", AthleteName='" + AthleteName + '\'' +
                ", CountryCode='" + CountryCode + '\'' +
                ", SkiTimeResult=" + SkiTimeResult +
                ", FirstShootingRange='" + FirstShootingRange + '\'' +
                ", SecondShootingRange='" + SecondShootingRange + '\'' +
                ", ThirdShootingeRange='" + ThirdShootingeRange + '\'' +
                ", Total Time after Penalties=" + totalTime +
                "}\n";
    }
}
