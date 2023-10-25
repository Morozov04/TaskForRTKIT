package org.example.command.commands;

import org.example.command.ICommand;
import org.example.command.StudentService;
import org.example.dataGroups.DataGroup;
import org.example.dataGroups.IGroupCriterion;
import org.example.methods.Methods;

public class Command2 implements ICommand {
    private final StudentService STUDENT_SERVICE;

    public Command2(StudentService studentService) {
        this.STUDENT_SERVICE = studentService;
    }

    @Override
    public void execute() {
        IGroupCriterion ageCriterion = person -> String.valueOf(person.getAGE());
        DataGroup ageGroup = new DataGroup(ageCriterion);
        StudentService.toDataGroup(ageGroup, STUDENT_SERVICE);
        Methods.searchPersonByAssessment(ageGroup, 14, 18, 5);
    }
}
