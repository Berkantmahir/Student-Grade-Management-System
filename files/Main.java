package files;

import java.util.Scanner;

/**
 * Main class
 * @author Rıfat Arifoğlu
 */
public class Main{
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int choice = 0;
        String nextLine = "";

        do {

            System.out.print("1-Student Management\n2-Course Management\n3-Grade Management\n4-Exit\nChoice: ");
            choice = in.nextInt();
            nextLine = in.nextLine();

            System.out.println();

            switch (choice) {
                case 1:
                    int choiceA = 0;

                    System.out.print("1-Add Student\n2-Remove Student\n3-Enroll Student\n4-Return\nChoice: ");
                    choiceA = in.nextInt();
                    nextLine = in.nextLine();

                    System.out.println();

                    if(choiceA == 1){
                        StudentManager.addStudent();
                    }else if(choiceA == 2){
                        StudentManager.removeStudent();
                    }else if(choiceA == 3){
                        StudentManager.enrollStudent();
                    }else if(choiceA == 4){
                        System.out.println("Returning...");
                    }else{
                        System.out.println("Please enter a valid choice");
                    }

                    break;
                case 2:
                    int choiceB = 0;

                    System.out.print("1-Add Course\n2-Remove Course\n3-View Course Details\n4-Return\nChoice: ");
                    choiceB = in.nextInt();
                    nextLine = in.nextLine();

                    System.out.println();

                    if(choiceB == 1){
                        CourseManager.addCourse();
                    }else if(choiceB == 2){
                        CourseManager.removeCourse();
                    }else if(choiceB == 3){
                        CourseManager.viewCourseDetails();
                    }else if(choiceB == 4){
                        System.out.println("Returning...");
                    }else{
                        System.out.println("Please enter a valid choice");
                    }

                    break;
                case 3:
                    int choiceC = 0;

                    System.out.print("1-Record New Grade\n2-Update Grade\n3-View Grades\n4-View Avarage Grades\n5-Return\nChoice: ");
                    choiceC = in.nextInt();
                    nextLine = in.nextLine();

                    System.out.println();

                    if(choiceC == 1){
                        GradeManager.recordNewGrade();
                    }else if(choiceC == 2){
                        GradeManager.updateGrade();
                    }else if(choiceC == 3){
                        GradeManager.viewGrades();
                    }else if(choiceC == 4){
                        GradeManager.viewAvarageGrade();
                    }else if(choiceC == 5){
                        System.out.println("Returning...");
                    }else{
                        System.out.println("Please enter a valid choice");
                    }

                    break;
                case 4:
                    System.out.println("Exitting...");
                    break;
                default:
                    System.out.println("Please enter a valid choice");
                    break;
            }

            System.out.println();
            
        } while (choice != 4);
        
        //Close the Scanners of managers
        StudentManager.closeScanner();
        CourseManager.closeScanner();
        GradeManager.closeScanner();
    }
}