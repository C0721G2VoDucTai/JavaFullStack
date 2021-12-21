package _04_class_and_object.excercise;

import java.util.Date;

public class BuildingStopWatch {
    private long startTime, endTime;

    public BuildingStopWatch() {
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        long elapsed;
        elapsed = (this.endTime - this.startTime);
        return elapsed;
    }
}
