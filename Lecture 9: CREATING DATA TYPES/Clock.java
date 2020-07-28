/**
 * Clock data type.
 * Write a data type Clock.java that represents time on a 24-hour clock, such as 00:00, 13:30, or 23:59.
 * Time is measured in hours (00–23) and minutes (00–59).
 */

public class Clock {
    
    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;

    private int hours;
    private int minutes;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if ((h < 0 || h >= HOURS_PER_DAY) || (m < 0 || m >= MINUTES_PER_HOUR)) {
            throw new IllegalArgumentException("Not a valid time");
        }
        hours = h;
        minutes = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (s.length() != 5) {
            throw new IllegalArgumentException("Time string is not in correct length");
        }

        String delimiter = s.substring(2, 3);
        if (!delimiter.equals(":")) {
            throw new IllegalArgumentException("No hour and minute delimiter found");
        }
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        if ((h < 0 || h >= HOURS_PER_DAY) || (m < 0 || m >= MINUTES_PER_HOUR)) {
            throw new IllegalArgumentException("Not a valid time");
        }
        hours = h;
        minutes = m;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String hourStr;
        String minuteStr;

        if (hours < 10) hourStr = "0" + hours;
        else hourStr = String.valueOf(hours);

        if (minutes < 10) minuteStr = "0" + minutes;
        else minuteStr = String.valueOf(minutes);

        return hourStr + ":" + minuteStr;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (this.hours < that.hours) {
            return true;
        } else if (this.hours == that.hours && this.minutes < that.minutes) {
            return true;
        }
        return false;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        minutes++;
        if (minutes == MINUTES_PER_HOUR) {
            minutes = 0;
            hours++;
            if (hours == HOURS_PER_DAY) hours = 0;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException();
        }

        if (minutes + delta >= MINUTES_PER_HOUR) {
            hours = (hours + (minutes + delta) / MINUTES_PER_HOUR) % HOURS_PER_DAY;
            minutes = (minutes + delta) % MINUTES_PER_HOUR;
        } else {
            minutes += delta;
        }
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock time = new Clock(18, 2);
        System.out.println(time);
        Clock time1 = new Clock("07:25");
        System.out.println(time1);
        System.out.println(time.isEarlierThan(time1));
        time.tic();
        System.out.println(time);
        time1.toc(20);
        System.out.println(time1);
        time.toc(750);
        System.out.println(time);
    }
}