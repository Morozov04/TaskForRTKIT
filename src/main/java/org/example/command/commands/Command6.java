package org.example.command.commands;

import org.example.command.ICommand;

import java.util.Scanner;

public class Command6 implements ICommand {
    @Override
    public void execute() {
        Scanner in = new Scanner(System.in);

        System.out.print("\nВведите фамилию ученика: ");

       // SQLMethods.searchPersonAverageGradeBySurname(in.nextLine());
    }
}
