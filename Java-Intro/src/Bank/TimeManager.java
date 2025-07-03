package Bank;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Manages bank operating hours and time-related operations.
 */
public class TimeManager {
    private LocalDateTime endtime;
    private static final int Bankhours = 15;

    /**
     * Initializes time manager with bank closing time.
     */
    public TimeManager() {
        this.endtime = LocalDateTime.now().plus(Bankhours, ChronoUnit.MINUTES);
    }

    /**
     * Checks if the bank is still open.
     * 
     * @return boolean indicating if bank is open
     */
    public boolean isBankOpen() {
        return LocalDateTime.now().isBefore(endtime);
    }

    /**
     * Displays bank closing message.
     */
    public void displayClosingMessage() {
        System.out.println("\n Its 5:00 PM. The bank is closed.");
    }

}
