package selfStudy.tickerReservation.clases;

import java.time.LocalDateTime;

public class Customer {
    private int id ;
    private String name;
    private LocalDateTime createAt;

    public Customer(int id, String name, LocalDateTime createAt) {
        this.id = id;
        this.name = name;
        this.createAt = createAt;
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

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
