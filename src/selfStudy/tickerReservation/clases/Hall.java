package selfStudy.tickerReservation.clases;

public class Hall {
    private int id;
    private String name;
    private int totalSeats;
    private int availableSeats;

    public Hall(int id, String name, int totalSeats, int availableSeats) {
        if (totalSeats <= 0) {
            throw new IllegalArgumentException("totalSeats must be greater than 0");
        }
        this.id = id;
        this.name = name;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        if (totalSeats >= availableSeats) {
            this.totalSeats = totalSeats;
        }
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
    public void reserveSeats(int seatCount) {
        if (seatCount <= 0) {
            throw new IllegalArgumentException("Seat count must be greater than 0");
        }
        if (availableSeats < seatCount) {
            throw new IllegalStateException("Not enough available seats");
        }
        this.availableSeats -= seatCount;
    }

    public void releaseSeats(int seatCount) {
        if (seatCount <= 0) {
            throw new IllegalArgumentException("Seat count must be greater than 0");
        }
        this.availableSeats += seatCount;
    }
}
