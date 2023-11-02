package org.example.command.commands;

import org.example.command.ICommand;
import org.example.methods.SQLMethods;

public class Command5 implements ICommand {
    @Override
    public void execute() {
        SQLMethods.searchPersonByAssessment("14","18","5");
    }
}
