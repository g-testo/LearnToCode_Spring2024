package com.ps.DAO.interfaces;

import com.ps.models.Ticket;
import java.util.List;

public interface TicketInt {
    List<Ticket> getAllTickets();
    Ticket getOneTicket(int id);
    int createTicket(Ticket ticket);
    void updateTicket(int id, Ticket ticket);
    void deleteTicket(int id);
    List<Ticket> filterTicketsByNameAndPrice(String name, float price);
}
