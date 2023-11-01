package org.example.person;

public class SubjectGrades {
    private int physicsGrade;
    private int mathematicsGrade;
    private int rusGrade;
    private int literatureGrade;
    private int geometryGrade;
    private int informaticsGrade;

    public SubjectGrades(int physicsGrade, int mathematicsGrade, int rusGrade, int literatureGrade, int geometryGrade, int informaticsGrade) {
        this.physicsGrade = physicsGrade;
        this.mathematicsGrade = mathematicsGrade;
        this.rusGrade = rusGrade;
        this.literatureGrade = literatureGrade;
        this.geometryGrade = geometryGrade;
        this.informaticsGrade = informaticsGrade;
    }

    public int getPhysicsGrade() {
        return physicsGrade;
    }

    public int getMathematicsGrade() {
        return mathematicsGrade;
    }

    public int getRusGrade() {
        return rusGrade;
    }

    public int getLiteratureGrade() {
        return literatureGrade;
    }

    public int getGeometryGrade() {
        return geometryGrade;
    }
    public int getInformaticsGrade() {
        return informaticsGrade;
    }

    public void setPhysicsGrade(int physicsGrade) {
        this.physicsGrade = physicsGrade;
    }

    public void setMathematicsGrade(int mathematicsGrade) {
        this.mathematicsGrade = mathematicsGrade;
    }

    public void setRusGrade(int rusGrade) {
        this.rusGrade = rusGrade;
    }

    public void setLiteratureGrade(int literatureGrade) {
        this.literatureGrade = literatureGrade;
    }

    public void setGeometryGrade(int geometryGrade) {
        this.geometryGrade = geometryGrade;
    }

    public void setInformaticsGrade(int informaticsGrade) {
        this.informaticsGrade = informaticsGrade;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "physics=" + physicsGrade +
                ", mathematics=" + mathematicsGrade +
                ", rus=" + rusGrade +
                ", literature=" + literatureGrade +
                ", geometry=" + geometryGrade +
                ", informatics=" + informaticsGrade +
                '}';
    }
}
