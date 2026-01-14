package selfStudy.tickerReservation.clases;

import java.time.LocalDateTime;

public class Movie {
    private final int id;
    private String title;
    private int duration;
    private int price;
    private LocalDateTime createdAt;


    public Movie(int id, String title, int duration, int price) {
        if (duration<0){
            throw new IllegalArgumentException("duration must be greater than zero");
        }
        if (price<0){
            throw new IllegalArgumentException("price must be greater than zero");
        }
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.price = price;
        this.createdAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
            this.duration = duration;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
            this.price = price;

    }

}
