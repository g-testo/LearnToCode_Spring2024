package com.ps;

import com.ps.DAO.OrderDetailsDAO;
import com.ps.DAO.TicketDAO;
import com.ps.DAO.UserDAO;
import com.ps.models.OrderDetails;
import com.ps.models.Ticket;
import com.ps.models.User;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static UserDAO userDAO;
    private static TicketDAO ticketDAO;
    private static OrderDetailsDAO orderDetailsDAO;

    private static User currentUser;
    private static Scanner scanner = new Scanner(System.in);

    public static void init(String[] args){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/ticket_playground_db");
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(args[0]);
        basicDataSource.setPassword(args[1]);
        userDAO = new UserDAO(basicDataSource);
        ticketDAO = new TicketDAO(basicDataSource);
        orderDetailsDAO = new OrderDetailsDAO(basicDataSource);
    }

    public static void display(String[] args){
        init(args);

        // Register - Create a new account
            // What's your first name?
            // What's your last name?
            // Save user
            // Set current user
        // Find account
            // Choose a user
            // Set current user

            // My Space
                // Purchase a ticket
                    // Choose what ticket you would like to purchase
                    // How many?
                    // Are you at the event?
                    // Save order_detail
                // Show our details
                // View all our orders
                // Change our first or last name
                // Delete our account
        // Admin
            // CRUD on user
            // CRUD on ticket
            // CRUD on order_details



        int command;

        do{
            System.out.println("What would you like to do?");
            System.out.println("1) Register");
            System.out.println("2) Select User");
            System.out.println("3) My Space");
            System.out.println("4) Admin");

            System.out.println("0) Exit");
            command = scanner.nextInt();
            switch (command){
                case 1:
                    scanner.nextLine(); // Consume carriage
                    System.out.print("First Name:");
                    String firstName = scanner.nextLine();
                    System.out.print("Last Name:");
                    String lastName = scanner.nextLine();

                    User user = new User(firstName, lastName);
                    int id = userDAO.createUser(user);
                    currentUser = userDAO.getOneUser(id);
                    break;
                case 2:
                    List<User> users = userDAO.getAllUsers();
                    for(User userEl: users){
                        System.out.printf("%s) %s\n", userEl.getId(), userEl.getFirstName());
                    }
                    System.out.printf("99) Go back\n");
                    System.out.println("Choose a user...");
                    int chosenId = scanner.nextInt();

                    if(chosenId == 99){
                        break;
                    }
                    currentUser = userDAO.getOneUser(chosenId);
                    break;
                case 3:
                    // My Space
                    displayMySpaceMenu();
                    break;
                case 4:
                    // Admin
                    break;
                default:
                    System.out.println("Command not found");
            }
        } while(command != 0);
    }

    public static void displayMySpaceMenu(){
        System.out.println("Welcome to My Space...");

        if(currentUser == null){
            System.out.println("Sorry, you must be logged in...");
            return;
        }

        int command;

        do{
            System.out.println("What would you like to do?");
            System.out.println("1) Purchase a ticket");

            System.out.println("2) Show my details");
            System.out.println("3) Show my orders");
            System.out.println("4) Change first/last name");
            System.out.println("5) Delete account");
            System.out.println("99) Go back");

            command = scanner.nextInt();

            switch (command){
                case 1:
                    System.out.println("What ticket would you like to purchase?");
                    List<Ticket> tickets =  ticketDAO.getAllTickets();
                    for(Ticket ticket: tickets){
                        System.out.printf("%d) %s\n", ticket.getId(), ticket.getEventName());
                    }
                    System.out.println("99) Go Back");

                    int ticketChoice = scanner.nextInt();
                    if(ticketChoice == 99){
                        System.out.println("Going back...");
                        break;
                    }

                    Ticket chosenTicket = ticketDAO.getOneTicket(ticketChoice);
                    if(chosenTicket.equals(null)){
                        System.out.println("Event not found");
                    }

                    System.out.println("How many would tickets would you like to purchase?");
                    int quantity = scanner.nextInt();

                    System.out.println("Would you like to redeem now? (y)es (N)o");

                    String redeemNowInput = scanner.nextLine();
                    boolean shouldRedeemNow = redeemNowInput.toLowerCase().contains("y");


                    int newId = orderDetailsDAO.createOrderDetails(new OrderDetails(
                            currentUser.getId(),
                            chosenTicket.getId(),
                            quantity,
                            shouldRedeemNow
                    ));

                    System.out.println("Purchase successful: ");
                    System.out.println(orderDetailsDAO.getOneOrderDetails(newId));
                    break;
                case 2:
                    System.out.printf("First Name: %s\n Last Name: %s\n",
                            currentUser.getFirstName(),
                            currentUser.getLastName()
                    );
                    break;
                case 3:
                    List<String> orderDetailsStrings = orderDetailsDAO.getOrdersDetailsJoinTicket(currentUser.getId());
                    for(String order: orderDetailsStrings){
                        System.out.println(order);
                    }
                    break;
                case 4:
                    scanner.nextLine(); // Consume carriage
                    System.out.print("New First Name:");
                    String firstName = scanner.nextLine();
                    System.out.print("New Last Name:");
                    String lastName = scanner.nextLine();

                    userDAO.updateUser(currentUser.getId(), new User(firstName, lastName));
                    currentUser = userDAO.getOneUser(currentUser.getId());// Refresh current user
                    break;
                case 5:
                    userDAO.deleteUser(currentUser.getId());
                    System.out.println("Your account has been removed");
                    currentUser = null;
                    break;
                case 99:
                    break;
                default:
                    System.out.println("Command not found");
            }


        } while(command != 99);

        // My Space

            // Show our details
            // View all our orders
            // Change our first or last name
            // Delete our account
    }
}
