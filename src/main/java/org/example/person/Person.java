package org.example.person;

public class Person{
    private final String FAMILY;
    private final String NAME;
    private final int AGE;
    private final int GROUP;
    private final SubjectGrades SUBJECT_GRADES;

    public Person(String family, String name, int age, int group, SubjectGrades subjectGrades) {
        this.FAMILY = family;
        this.NAME = name;
        this.AGE = age;
        this.GROUP = group;
        this.SUBJECT_GRADES = subjectGrades;
    }

    public String getFAMILY() {
        return FAMILY;
    }

    public String getNAME() {
        return NAME;
    }

    public int getAGE() {
        return AGE;
    }

    public int getGROUP() {
        return GROUP;
    }

    public SubjectGrades getSUBJECT_GRADES() {
        return SUBJECT_GRADES;
    }

    @Override
    public String toString() {
        return "Person{" +
                "family='" + FAMILY + '\'' +
                ", name='" + NAME + '\'' +
                ", age=" + AGE +
                ", group=" + GROUP +
                '}' + "\n";
    }
}
