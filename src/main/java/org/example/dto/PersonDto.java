package org.example.dto;

import org.example.person.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonDto {

    public static List<Map<Integer, Double>> avgGradeInSubjects = new ArrayList<>();
    private double avg;
    private Person person;

    public PersonDto(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "person=" + person +
                '}';
    }
}
