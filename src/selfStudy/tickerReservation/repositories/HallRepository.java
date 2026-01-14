package selfStudy.tickerReservation.repositories;

import selfStudy.tickerReservation.clases.Hall;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HallRepository {
    List<Hall> hallList;

    public HallRepository() {
        this.hallList = new ArrayList<>();
    }


    public void save(Hall hall) {
        hallList.add(hall);
    }

    public Optional<Hall> findByID(int id) {
        return hallList.stream().filter(hall -> hall.getId()==id)
                .findFirst();
    }

    public List<Hall> findAll() {
        return hallList;
    }

}
