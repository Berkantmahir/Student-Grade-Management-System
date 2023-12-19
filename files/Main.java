package files;

import java.util.Scanner;

/**
 * Main class
 * @author Rıfat Arifoğlu
 */
public class Main{
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int firstChoice = 0;
        int secondChoice = 0;
        String nextLine = "";

        do {

            System.out.print("1-Student Login\n2-Instructor Login\n3-Admin Login\n4-Exit\nChoice: ");
            firstChoice = in.nextInt();
            nextLine = in.nextLine();

            System.out.println();

            if(firstChoice == 1){
                int studentID = 0;
                Student currentStudent = null;

                System.out.print("Please enter your ID: ");
                studentID = in.nextInt();
                nextLine = in.nextLine();

                currentStudent = StudentManager.findStudent(studentID, true);
                if(currentStudent == null){
                    continue;
                }
                
                System.out.print("1-Enroll Course\n2-View Personal Informations\n3-View Courses\n4-View Grades\n5-Log out\nChoice: ");
                secondChoice = in.nextInt();
                nextLine = in.nextLine();

                switch (secondChoice) {
                    case 1:
                        StudentManager.enrollStudent(currentStudent);
                        break;
                    case 2:
                        System.out.println(currentStudent);
                        break;
                    case 3:
                        StudentManager.viewCourses(currentStudent);
                        break;
                    case 4:
                        GradeManager.viewStudentGrades(currentStudent);
                        break;
                    case 5:
                        System.out.println("Logging out...");
                        break;
                    default:
                        break;
                }
            }else if(firstChoice == 2){
                int instructorID = 0;
                Instructor currentInstructor = null;

                System.out.print("Please enter your ID: ");
                instructorID = in.nextInt();
                nextLine = in.nextLine();

                currentInstructor = InstructorManager.findInstructor(instructorID, true);          
                if(currentInstructor == null){
                    continue;
                }

                System.out.print("1-Give Course\n2-View Personal Informations\n3-View Courses\n4-Record New Grade\n5-Update Grade\n6-View Grade\n7-Log out\nChoice: ");
                secondChoice = in.nextInt();
                nextLine = in.nextLine();

                switch (secondChoice) {
                    case 1:
                        InstructorManager.giveCourse(currentInstructor);
                        break;
                    case 2:
                        System.out.println(currentInstructor);
                        break;
                    case 3:
                        InstructorManager.viewCourses(currentInstructor);
                        break;
                    case 4:
                        GradeManager.recordNewGrade();
                        break;
                    case 5:
                        GradeManager.updateGrade();
                        break;
                    case 6:
                        GradeManager.viewGrades();
                        break;
                    case 7:
                        System.out.println("Logging out...");
                        break;
                    default:
                        break;
                }
            }else if(firstChoice == 3){
                System.out.print("1-Create Student\n2-Remove Student\n3-Create Instructor\n4-Remove Instructor\n5-Create Course\n6-Remove Course\nChoice: ");
                secondChoice = in.nextInt();
                nextLine = in.nextLine();

                switch (secondChoice) {
                    case 1:
                        StudentManager.createStudent();
                        break;
                    case 2:
                        StudentManager.removeStudent();
                        break;
                    case 3:
                        InstructorManager.createInstructor();
                        break;
                    case 4:
                        InstructorManager.removeInstructor();
                        break;
                    case 5:
                        CourseManager.createCourse();
                        break;
                    case 6:
                        CourseManager.removeCourse();
                        break;
                    default:
                        break;
                }
            }else if(firstChoice == 4){
                System.out.println("Exitting...");
            }else{
                System.out.println("Please enter a valid input!");
            }

            System.out.println();
            
        } while (firstChoice != 4);
        
        //Close the Scanners of managers
        StudentManager.closeScanner();
        InstructorManager.closeScanner();
        CourseManager.closeScanner();
        GradeManager.closeScanner();
    }
}