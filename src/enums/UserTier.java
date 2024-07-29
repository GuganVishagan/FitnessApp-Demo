package enums;

public enum UserTier {
    PLATINUM(10),
    GOLD(5),
    SILVER(3);

    private int bookingLimit;

    UserTier(int bookingLimit) {
        this.bookingLimit = bookingLimit;
    }

    public int getBookingLimit() {
        return bookingLimit;
    }
}