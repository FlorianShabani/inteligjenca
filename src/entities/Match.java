package entities;

public class Match{
    // TIME AS INT 00_00 - 1440 (1h = 60)

    public static final int LEN = 180; // Per arsye te TV (pregame, postgame interviews etc...)

    int startTime;
    int endTime;
    int week;


    public Match(int startTime, int week) {
        this.startTime = startTime;
        this.week = week;
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

    public Match clone() {
        return new Match(this.startTime, this.week);
    }
}
