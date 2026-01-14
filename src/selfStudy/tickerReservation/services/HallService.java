package selfStudy.tickerReservation.services;

import selfStudy.tickerReservation.clases.Hall;
import selfStudy.tickerReservation.repositories.HallRepository;

import java.util.List;
import java.util.Optional;

public class HallService {

    private HallRepository hallRepository;

    public HallService(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    public void addHall(Hall hall) {
        hallRepository.save(hall);
    }

    public Optional<Hall> getHallById(int id) {
        return hallRepository.findByID(id);
    }

    public List<Hall> getAllHall() {
        return hallRepository.findAll();
    }

    public void reserveSeats(int hallId, int seatCount) {
        Hall hall = getHallById(hallId)
                .orElseThrow(() -> new IllegalArgumentException("Hall not found"));

        hall.reserveSeats(seatCount);
    }

    public void releaseSeats(int hallId, int seatCount) {
        Hall hall = getHallById(hallId)
                .orElseThrow(() -> new IllegalArgumentException("Hall not found"));

        hall.releaseSeats(seatCount);
    }

}
