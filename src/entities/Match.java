package entities;

public class Match{
    // TIME AS INT 00_00 - 1440 (1h = 60)

    public static final int LEN = 180; // Per arsye te TV (pregame, postgame interviews etc...)

    int startTime;
    int endTime;
    int day;


    public Match(int startTime, int day) {
        this.startTime = startTime;
        this.day = day;
        this.endTime = startTime + LEN;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
        endTime = startTime + LEN;
    }

    public int getEndTime() {
        return endTime;
    }
    
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Match clone() {
        return new Match(this.startTime, this.day);
    }
}
