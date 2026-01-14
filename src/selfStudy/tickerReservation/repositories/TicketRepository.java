package selfStudy.tickerReservation.repositories;

import selfStudy.tickerReservation.clases.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketRepository {
    List<Ticket> ticketList;

    public TicketRepository() {
        this.ticketList = new ArrayList<>();
    }

    public void save(Ticket ticket){
        ticketList.add(ticket);
    }

    public Optional<Ticket> findById(int id){
        return ticketList.stream().filter(ticket -> ticket.getId()==id)
                .findFirst();
    }

    public List<Ticket> findAll(){
        return ticketList;
    }

    public void delete(int id){
        ticketList.removeIf(ticket1 -> ticket1.getId()==id);
    }
}
