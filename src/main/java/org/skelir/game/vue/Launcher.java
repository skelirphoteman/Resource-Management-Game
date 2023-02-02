package org.skelir.game.vue;

import org.skelir.game.controller.PlayerController;
import org.skelir.game.exception.InvalidSelectableChoiceException;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author julien
 */
public class Launcher{

    private PlayerController playerController;

    private ViewInterface view;

    private boolean running;
    public static void main(String[] args)
    {
        Launcher launcher = new Launcher();

        launcher.start();
    }

    public Launcher()
    {
        playerController = PlayerController.getInstance();
        view = new MenuView();
        running = true;
    }

    public void start()
    {
        StringBuilder message = new StringBuilder();
        message.append("Welcome to Resource Management Game created by Skelir Inc.");
        message.append("\n");
        message.append("You will start with 50 or and you must to extract and collect many resources to level up.");
        message.append("\n");
        message.append("Are you ready ? GO !");

        System.out.println(message);

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean correctChoice = false;
        while (running) {
            view.render();

            correctChoice = false;

            while (!correctChoice) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    view = view.update(choice);
                    correctChoice = true;

                } catch (InvalidSelectableChoiceException e) {
                    System.out.println(e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid insertion. Please Try again");
                }
            }
        }
        scanner.close();
        System.out.println("Good Bye !");
    }
}
