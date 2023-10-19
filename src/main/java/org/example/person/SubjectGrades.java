package org.example.person;

public class SubjectGrades {
    private final int PHYSICS_GRADE;
    private final int MATHEMATICS_GRADE;
    private final int RUS_GRADE;
    private final int LITERATURE_GRADE;
    private final int GEOMETRY_GRADE;
    private final int INFORMATICS_GRADE;

    public SubjectGrades(int physicsGrade, int mathematicsGrade, int rusGrade, int literatureGrade, int geometryGrade, int informaticsGrade) {
        this.PHYSICS_GRADE = physicsGrade;
        this.MATHEMATICS_GRADE = mathematicsGrade;
        this.RUS_GRADE = rusGrade;
        this.LITERATURE_GRADE = literatureGrade;
        this.GEOMETRY_GRADE = geometryGrade;
        this.INFORMATICS_GRADE = informaticsGrade;
    }

    public int getPHYSICS_GRADE() {
        return PHYSICS_GRADE;
    }

    public int getMATHEMATICS_GRADE() {
        return MATHEMATICS_GRADE;
    }

    public int getRUS_GRADE() {
        return RUS_GRADE;
    }

    public int getLITERATURE_GRADE() {
        return LITERATURE_GRADE;
    }

    public int getGEOMETRY_GRADE() {
        return GEOMETRY_GRADE;
    }

    public int getINFORMATICS_GRADE() {
        return INFORMATICS_GRADE;
    }

    @Override
    public String toString() {
        return "SubjectGrades{" +
                "physicsGrade=" + PHYSICS_GRADE +
                ", mathematicsGrade=" + MATHEMATICS_GRADE +
                ", rusGrade=" + RUS_GRADE +
                ", literatureGrade=" + LITERATURE_GRADE +
                ", geometryGrade=" + GEOMETRY_GRADE +
                ", informaticsGrade=" + INFORMATICS_GRADE +
                '}';
    }
}
