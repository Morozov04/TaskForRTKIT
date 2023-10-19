package org.example.person;

import org.example.dataGroups.ClassroomDataGroups;
import org.example.dataGroups.PersonAgeDataGroups;

public class Methods {
    public static double calculateAverageGrade(ClassroomDataGroups classroomDataGroups){

        double physicsGrade = 0.0;
        double mathematicsGrade = 0.0;
        double rusGrade = 0.0;
        double literatureGrade = 0.0;
        double geometryGrade = 0.0;
        double informaticsGrade = 0.0;

        int count = 0;

        for(int i = 10; i <= 11; i++){
            for (int j = 0; j < classroomDataGroups.getPersons(i).size(); j++){
                physicsGrade += classroomDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getPHYSICS_GRADE();
                mathematicsGrade += classroomDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getMATHEMATICS_GRADE();
                rusGrade += classroomDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getRUS_GRADE();
                literatureGrade += classroomDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getLITERATURE_GRADE();
                geometryGrade += classroomDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getGEOMETRY_GRADE();
                informaticsGrade += classroomDataGroups.getPersons(i).get(j).getSUBJECT_GRADES().getINFORMATICS_GRADE();

                count++;
            }
        }
        return ((physicsGrade/count) + (mathematicsGrade/count) + (rusGrade/count)+ (literatureGrade/count) +(geometryGrade/count)+ (informaticsGrade/count))/6;
    }

    public static int findExcellentStudents(PersonAgeDataGroups personAgeDataGroups){
        return 1 ;
    }
}
