package selfStudy.tickerReservation.services;

import selfStudy.tickerReservation.clases.Ticket;
import selfStudy.tickerReservation.clases.TicketStatus;
import selfStudy.tickerReservation.repositories.TicketRepository;

import java.util.List;

public class TicketService {
    private TicketRepository ticketRepository;
    private HallService hallService;

    public TicketService(TicketRepository ticketRepository, HallService hallService) {
        this.ticketRepository = ticketRepository;
        this.hallService = hallService;
    }

    public Ticket reverseTicket(Ticket ticket) {
        hallService.reserveSeats(ticket.getHall().getId(),ticket.getSeatCount());

        ticketRepository.save(ticket);
        return ticket;
    }

    public void cancelTicket(int ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found"));

        hallService.releaseSeats(ticket.getHall().getId(),ticket.getSeatCount());

        ticket.setStatus(TicketStatus.CANCELLED);

        ticketRepository.delete(ticketId);


    }
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }


}
