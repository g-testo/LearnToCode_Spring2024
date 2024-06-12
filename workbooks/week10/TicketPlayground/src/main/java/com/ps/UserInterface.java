package com.ps;

import com.ps.DAO.TicketDAO;
import com.ps.DAO.UserDAO;
import com.ps.models.Ticket;
import com.ps.models.User;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static UserDAO userDAO;
    private static TicketDAO ticketDAO;
    private static Scanner scanner = new Scanner(System.in);

    public static void init(String[] args){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/ticket_playground_db");
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(args[0]);
        basicDataSource.setPassword(args[1]);
        userDAO = new UserDAO(basicDataSource);
        ticketDAO = new TicketDAO(basicDataSource);
    }

    public static void display(String[] args){
        init(args);

        System.out.println("What would you like to do?");
        System.out.println("1) Select User");
        System.out.println("2) Register");
        System.out.println("3) Admin");
        System.out.println("0) Exit");

        int command = scanner.nextInt();

        do{
            switch (command){
                case 1:
                    List<User> users = userDAO.getAllUsers();
                    for(User user: users){
                        System.out.printf("%s) %s\n", user.getId(), user.getFirstName());
                    }
                    System.out.println("Choose a user...");
                    int chosenId = scanner.nextInt();

                    User chosenUser = userDAO.getOneUser(chosenId);
                    System.out.println("You chose:");
                    System.out.println(chosenUser);
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("First Name:");
                    String firstName = scanner.nextLine();
                    System.out.print("Last Name:");
                    String lastName = scanner.nextLine();

                    int createdUserId = userDAO.createUser(firstName, lastName);

                    System.out.println(userDAO.getOneUser(createdUserId));
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Command not found");
            }
        } while(command != 0);

    }
}
