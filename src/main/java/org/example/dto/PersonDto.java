package org.example.dto;

public class PersonDto {
    private String family;
    private String name;
    private int age;
    private int group;
    private double avg;

    public PersonDto(String family, String name, int age, int group) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public PersonDto(String family, String name, int age, int group, double avg) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.group = group;
        this.avg = avg;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
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
                "family='" + family + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", group=" + group +
                '}';
    }

    public String ToStringAVG(){
        return "PersonDto{" +
                "family='" + family + '\'' +
                ", name='" + name + '\'' +
                ", group=" + group +
                ", avg=" + avg +
                '}';
    }
}
