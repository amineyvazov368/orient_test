package selfStudy.tickerReservation.clases;

import selfStudy.tickerReservation.repositories.CustomerRepository;
import selfStudy.tickerReservation.repositories.HallRepository;
import selfStudy.tickerReservation.repositories.MovieRepository;
import selfStudy.tickerReservation.repositories.TicketRepository;
import selfStudy.tickerReservation.services.CustomerService;
import selfStudy.tickerReservation.services.HallService;
import selfStudy.tickerReservation.services.MovieServices;
import selfStudy.tickerReservation.services.TicketService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        MovieRepository movieRepository = new MovieRepository();
        HallRepository hallRepository = new HallRepository();
        CustomerRepository customerRepository = new CustomerRepository();
        TicketRepository ticketRepository = new TicketRepository();

        MovieServices movieServices = new MovieServices(movieRepository);
        HallService hallService = new HallService(hallRepository);
        CustomerService customerService = new CustomerService(customerRepository);
        TicketService ticketService = new TicketService(ticketRepository,hallService);

        Movie movie1 = new Movie(1, "Inception", 120, 15);
        Movie movie2 = new Movie(2, "Avatar", 150, 20);
        movieServices.addMovie(movie1);
        movieServices.addMovie(movie2);

        Hall hall1 = new Hall(1, "Hall A", 100, 100);
        Hall hall2 = new Hall(2, "Hall B", 50, 50);
        hallService.addHall(hall1);
        hallService.addHall(hall2);

        Customer customer1 = new Customer(1, "Amin", LocalDateTime.now());
        Customer customer2 = new Customer(2, "Leyla", LocalDateTime.now());
        customerService.addCustomer(customer1);
        customerService.addCustomer(customer2);

        Ticket ticket1 = new Ticket(1, movie1, hall1, customer1, 2);
        Ticket ticket2 = new Ticket(2, movie2, hall2, customer2, 3);
        ticketService.reverseTicket(ticket1);
        ticketService.reverseTicket(ticket2);

        System.out.println("Tickets reserved successfully!");

        System.out.println("Hall A available seats: " + hall1.getAvailableSeats());
        System.out.println("Hall B available seats: " + hall2.getAvailableSeats());

        ticketService.cancelTicket(1); // ticket1 ləğv edildi
        System.out.println("Ticket 1 cancelled");

        ticketService.cancelTicket(2); // ticket1 ləğv edildi
        System.out.println("Ticket 2 cancelled");

        System.out.println("Hall A available seats after cancel: " + hall1.getAvailableSeats());

        System.out.println("All remaining tickets:");
        for (Ticket t : ticketService.getAllTickets()) {
            System.out.println("Ticket ID: " + t.getId() +
                    ", Movie: " + t.getMovie().getTitle() +
                    ", Customer: " + t.getCustomer().getName() +
                    ", Seats: " + t.getSeatCount());
        }
    }
}
