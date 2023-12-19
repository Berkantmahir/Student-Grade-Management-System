package files;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * GradeManager class
 * @author Rıfat Arifoğlu
 */
public class GradeManager {
    //Variables
    private static ArrayList<Grade> gradesList = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    /**
     * Records a new {@code Grade}
     * @return Is {@code Grade} created
     */
    public static boolean recordNewGrade(){
        int courseID = 0;
        int studentID = 0;
        double gradeValue = 0;
        Course currentCourse = null;
        Student currentStudent = null;

        String nextLine = "";

        System.out.print("ID of the course that student going to graded: ");
        courseID = in.nextInt();
        nextLine = in.nextLine();

        currentCourse = CourseManager.findCourse(courseID, true);

        if(currentCourse == null){
            return false;
        }

        System.out.print("ID of the student going to graded: ");
        studentID = in.nextInt();
        nextLine = in.nextLine();

        currentStudent = StudentManager.findStudent(studentID, true);

        if(currentStudent == null){
            return false;
        }

        if(GradeManager.findGrade(currentStudent, currentCourse, false) != null){
            System.out.println("This grade already exists!");
            return false;
        }

        System.out.print("Value of the grade: ");
        gradeValue = in.nextDouble();
        nextLine = in.nextLine();
        
        GradeManager.getGradesList().add(new Grade(currentStudent, currentCourse, gradeValue));

        return true;
    }

    /**
     * Updates grade value of existing {@code Grade}
     * @return Is value updated
     */
    public static boolean updateGrade(){
        int courseID = 0;
        int studentID = 0;
        double gradeValue = 0;
        Course currentCourse = null;
        Student currentStudent = null;
        Grade currentGrade = null;

        String nextLine = "";

        System.out.print("ID of the course that student going to graded: ");
        courseID = in.nextInt();
        nextLine = in.nextLine();

        currentCourse = CourseManager.findCourse(courseID, true);

        if(currentCourse == null){
            return false;
        }

        System.out.print("ID of the student going to graded: ");
        studentID = in.nextInt();
        nextLine = in.nextLine();

        currentStudent = StudentManager.findStudent(studentID, true);

        if(currentStudent == null){
            return false;
        }

        currentGrade = GradeManager.findGrade(currentStudent, currentCourse, true);

        if(currentGrade == null){
            return false;
        }

        System.out.print("Value of the new grade: ");
        gradeValue = in.nextDouble();
        nextLine = in.nextLine();
        
        currentGrade.setGradeValue(gradeValue);

        return true;
    }

    /**
     * Prints out {@code Grade}s details
     */
    public static void viewGrades(){
        int choice = 0;
        String nextLine = "";

        System.out.print("1-Full grades\n2-Grades of certain course\n3-Grades of certain student\nChoice: ");
        choice = in.nextInt();
        nextLine = in.nextLine();

        System.out.println();

        switch (choice) {
            case 1:
                for(Grade grade : GradeManager.getGradesList()){
                    System.out.println(grade + "\n");
                }
                break;
            case 2:
                int courceID = 0;
                ArrayList<Grade> gradesOfCourse = null;
                
                System.out.print("ID of the course: ");
                courceID = in.nextInt();
                nextLine = in.nextLine();

                gradesOfCourse = GradeManager.findGrades(courceID, 2);

                for (Grade grade : gradesOfCourse) {
                    viewGrades(grade, 2);
                }
                
                break;
            case 3:
                int studentID = 0;
                ArrayList<Grade> gradesOfStudent = null;
                
                System.out.print("ID of the student: ");
                studentID = in.nextInt();
                nextLine = in.nextLine();

                gradesOfStudent = GradeManager.findGrades(studentID, 1);

                for (Grade grade : gradesOfStudent) {
                    viewGrades(grade, 1);
                }

                break;
            default:
                break;
        }
    }

    /**
     * Prints spesific {@code Student}'s or {@code Course}'s {@code Grade}s
     * @param grade  {@code Grade} that going to printed
     * @param choice Specifies for {@code Student}-1 or {@code Course}-2
     */
    public static void viewGrades(Grade grade, int choice){
        String output = "";
        
        if(choice == 1){
            output += "\nID of Student: " + grade.getStudent().getStudentID() + "\n";
            output += "Grade: " + grade.getGradeValue() + "\n";
            System.out.println(output);
        }else if(choice == 2){
            output += "\nID of Course: " + grade.getCourse().getCourseID() + "\n";
            output += "Grade: " + grade.getGradeValue() + "\n";
            System.out.println(output);
        }

    }

    /**
     * Print out a {@code Student}'s grades
     * @param student
     */
    public static void viewStudentGrades(Student student){
        System.out.println("Grades of student:\n");

        ArrayList<Grade> gradesOfStudent = GradeManager.findGrades(student.getStudentID(), 1);

        for (Grade grade : gradesOfStudent) {
            viewGrades(grade, 1);
        }

    }

    /**
     * Shows the avarage of grades
     */
    public static void viewAvarageGrade(){
        int choice = 0;
        String nextLine = "";

        System.out.print("Choose Student(1) or Course(2): ");
        choice = in.nextInt();
        nextLine = in.nextLine();

        System.out.println();

        if(choice == 1){
            int studentID = 0;
            ArrayList<Grade> gradesOfStudent = null;
                
            System.out.print("ID of the student: ");
            studentID = in.nextInt();
            nextLine = in.nextLine();

            gradesOfStudent = GradeManager.findGrades(studentID, 1);

            System.out.println("Avarage: " + calculateAverageGrade(gradesOfStudent));
        }else if(choice == 2){
            int courceID = 0;
            ArrayList<Grade> gradesOfCourse = null;
                
            System.out.print("ID of the course: ");
            courceID = in.nextInt();
            nextLine = in.nextLine();

            gradesOfCourse = GradeManager.findGrades(courceID, 2);

            System.out.println("Avarage: " + calculateAverageGrade(gradesOfCourse));
        }else{
            System.out.println("Please choose 1 or 2!");
        }
    }

    /**
     * Avarage calculator
     * @param grades {@code Grade}s of {@code Student} or {@code Course} that going to take avarage.
     * @return        Avarage of grade values
     */
    public static double calculateAverageGrade(ArrayList<Grade> grades){
        double sumOfGrades = 0.0;
        int count = 0;
        for(Grade grade : grades){
            sumOfGrades += grade.getGradeValue();
            count++;
        }
        return sumOfGrades / count;
    }

    /**
     * Checks if this {@code Grade} is already created.
     * @param student {@code Student} going to checked
     * @param course  {@code Course} going to checked
     * @return        Is this {@code Grade} exists
     */
    public static Grade findGrade(Student student, Course course, boolean isPrinted){
        for (Grade grade : GradeManager.getGradesList()) {
            if(grade.getCourse() == course && grade.getStudent() == student){
                return grade;
            }
        }

        if(isPrinted){
            System.out.println("There isn't any grade of student with " + student.getStudentID() + " as ID of course with " + course.getCourseID() + " as ID.");
        }

        return null;
    }

    /**
     * Finds {@code Grade}s according to courseID or studentID
     * @param ID     ID of {@code Student} or {@code Course}
     * @param choice Determine {@code Student}-1 or {@code Course}-2
     * @return       Is grade exists
     */
    public static ArrayList<Grade> findGrades(int ID, int choice){
        ArrayList<Grade> output = new ArrayList<>();

        if(choice == 1){

            for (Grade grade : GradeManager.getGradesList()) {
                if(grade.getStudent().getStudentID() == ID){
                    output.add(grade);
                }
            }

            if(output.isEmpty()){
                System.out.println("There isn't any course that have " + ID + " ID graded.");
                return null;
            }
            
        }else if(choice == 2){

            for (Grade grade : GradeManager.getGradesList()) {
                if(grade.getCourse().getCourseID() == ID){
                    output.add(grade);
                }
            }
            
            if(output.isEmpty()){
                System.out.println("There isn't any student that have " + ID + " ID graded.");
                return null;
            }
            
        }
        
        return output;
    }

    /**
     * @return {@code ArrayList<Grade>} of the grades
     */
    public static ArrayList<Grade> getGradesList() {
        return gradesList;
    }

    /**
     * Closes the {@code Scanner} object of the {@link files.GradeManager} class
     */
    public static void closeScanner(){
        try {
            GradeManager.in.close();
        } catch (Exception e) {
            System.out.println("Scanner already closed!");
        }
    }
}
