package selfStudy.tickerReservation.clases;

import java.time.LocalDateTime;

public class Ticket {
    private int id;
    private Movie movie;
    private Hall hall;
    private Customer customer;
    private int seatCount;
    private TicketStatus status;
    private LocalDateTime createdAt;

    public Ticket(int id, Movie movie, Hall hall, Customer customer, int seatCount) {
        if (seatCount <= 0) {
            throw new IllegalArgumentException("seatCount must be greater than 0");
        }

        this.id = id;
        this.movie = movie;
        this.hall = hall;
        this.customer = customer;
        this.seatCount = seatCount;
        this.status = TicketStatus.RESERVED;
        this.createdAt = LocalDateTime.now();
    }

    public int getTotalPrice() {
        return seatCount * movie.getPrice();
    }

    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;

    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
