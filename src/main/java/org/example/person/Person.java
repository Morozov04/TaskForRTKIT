package org.example.person;

public class Person {
    private String family;
    private String name;
    private int age;
    private int group;
    private SubjectGrades subjectGrades;

    public Person(String family, String name, int age, int group, SubjectGrades subjectGrades) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.group = group;
        this.subjectGrades = subjectGrades;
    }

    public String getFamily() {
        return family;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getGroup() {
        return group;
    }

    public SubjectGrades getSubjectGrades() {
        return subjectGrades;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setSubjectGrades(SubjectGrades subjectGrades) {
        this.subjectGrades = subjectGrades;
    }

    @Override
    public String toString() {
        return "Person{" +
                "family='" + family + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", group=" + group +
                '}';
    }
}
