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

        if(!CourseManager.isCourseExist(courseID)){
            System.out.println("There isn't any course that have " + courseID + " ID.");
            return false;
        }

        for(Course course : CourseManager.getCourseList()){
            if(course.getCourseID() == courseID){
                currentCourse = course;
            }
        }

        System.out.print("ID of the student going to graded: ");
        studentID = in.nextInt();
        nextLine = in.nextLine();

        if(!StudentManager.isStudentExist(studentID)){
            System.out.println("There isn't any student that have " + studentID + " ID.");
            return false;
        }

        for(Student student : StudentManager.getStudentsList()){
            if(student.getStudentID() == studentID){
                currentStudent = student;
            }
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

        String nextLine = "";

        System.out.print("ID of the course that student going to graded: ");
        courseID = in.nextInt();
        nextLine = in.nextLine();

        if(!CourseManager.isCourseExist(courseID)){
            System.out.println("There isn't any course that have " + courseID + " ID.");
            return false;
        }

        for(Course course : CourseManager.getCourseList()){
            if(course.getCourseID() == courseID){
                currentCourse = course;
            }
        }

        System.out.print("ID of the student going to graded: ");
        studentID = in.nextInt();
        nextLine = in.nextLine();

        if(!StudentManager.isStudentExist(studentID)){
            System.out.println("There isn't any student that have " + studentID + " ID.");
            return false;
        }

        for(Student student : StudentManager.getStudentsList()){
            if(student.getStudentID() == studentID){
                currentStudent = student;
            }
        }

        if(!isGradeExists(currentStudent, currentCourse)){
            System.out.println("There isn't any grade of student with " + studentID + " ID of course with " + courseID + " ID.");
            return false;
        }

        System.out.print("Value of the new grade: ");
        gradeValue = in.nextDouble();
        nextLine = in.nextLine();
        
        for (Grade grade : GradeManager.getGradesList()) {
            if(grade.getCourse() == currentCourse && grade.getStudent() == currentStudent){
                grade.setGradeValue(gradeValue);
            }
        }

        return true;
    }

    /**
     * Prints out {@code Grade}s
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
                Course currentCourse = null;
                
                System.out.print("ID of the course: ");
                courceID = in.nextInt();
                nextLine = in.nextLine();

                if(isGradeExists(courceID, 2)){
                    for (Grade grade : GradeManager.getGradesList()) {
                        if(grade.getCourse().getCourseID() == courceID){
                            currentCourse = grade.getCourse();
                        }
                    }
                    viewGrades(currentCourse);
                }else{
                    System.out.println("There isn't any course that have " + courceID + " ID graded.");
                }
                break;
            case 3:
                int studentID = 0;
                Student currentStudent = null;
                
                System.out.print("ID of the student: ");
                studentID = in.nextInt();
                nextLine = in.nextLine();

                if(isGradeExists(studentID, 2)){
                    for (Grade grade : GradeManager.getGradesList()) {
                        if(grade.getStudent().getStudentID() == studentID){
                            currentStudent = grade.getStudent();
                        }
                    }
                    viewGrades(currentStudent);
                }else{
                    System.out.println("There isn't any student that have " + studentID + " ID graded.");
                }
                break;
            default:
                break;
        }
    }

    /**
     * Prints spesific {@code Student}'s {@code Grade}s
     * @param student {@code Student} that going to showed
     */
    public static void viewGrades(Student student){
        for(Grade grade : GradeManager.getGradesList()){
            if(grade.getStudent() == student){
                String output = "";
                output += "ID of Course: " + grade.getCourse().getCourseID() + "\n";
                output += "Grade: " + grade.getGradeValue() + "\n";
                System.out.println(output + "\n");
            }
        }
    }

    /**
     * Prints spesific {@code Course}'s {@code Grade}s
     * @param course {@code Course} that going to showed
     */
    public static void viewGrades(Course course){
        for(Grade grade : GradeManager.getGradesList()){
            if(grade.getCourse() == course){
                String output = "";
                output += "ID of Student: " + grade.getStudent().getStudentID() + "\n";
                output += "Grade: " + grade.getGradeValue() + "\n";
                System.out.println(output + "\n");
            }
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
            Student currentStudent = null;
                
            System.out.print("ID of the student: ");
            studentID = in.nextInt();
            nextLine = in.nextLine();

            if(isGradeExists(studentID, 1)){
                for (Grade grade : GradeManager.getGradesList()) {
                    if(grade.getStudent().getStudentID() == studentID){
                        currentStudent = grade.getStudent();
                    }
                }
                System.out.println("Avarage: " + calculateAverageGrade(currentStudent));
            }else{
                System.out.println("There isn't any student that have " + studentID + " ID graded.");
            }
        }else if(choice == 2){
            int courceID = 0;
            Course currentCourse = null;
                
            System.out.print("ID of the course: ");
            courceID = in.nextInt();
            nextLine = in.nextLine();

            if(isGradeExists(courceID, 2)){
                for (Grade grade : GradeManager.getGradesList()) {
                    if(grade.getCourse().getCourseID() == courceID){
                        currentCourse = grade.getCourse();
                    }
                }
                System.out.println("Avarage: " + calculateAverageGrade(currentCourse));
            }else{
                System.out.println("There isn't any course that have " + courceID + " ID graded.");
            }
        }else{
            System.out.println("Please choose 1 or 2!");
        }
    }

    /**
     * Avarage calculator
     * @param student {@code Student} going to take {@code Grades}
     * @return        Avarage of grade values
     */
    public static double calculateAverageGrade(Student student){
        double sumOfGrades = 0.0;
        int count = 0;
        for(Grade grade : GradeManager.getGradesList()){
            if(grade.getStudent() == student){
                sumOfGrades += grade.getGradeValue();
                count++;
            }
        }
        return sumOfGrades / count;
    }

    /**
     * Avarage calculator
     * @param course {@code Course} going to take {@code Grades}
     * @return        Avarage of grade values
     */
    public static double calculateAverageGrade(Course course){
        double sumOfGrades = 0.0;
        int count = 0;
        for(Grade grade : GradeManager.getGradesList()){
            if(grade.getCourse() == course){
                sumOfGrades += grade.getGradeValue();
                count++;
            }
        }
        return sumOfGrades / count;
    }

    /**
     * Checks if this {@code Grade} is already created.
     * @param student {@code Student} going to checked
     * @param course  {@code Course} going to checked
     * @return        Is this {@code Grade} exists
     */
    public static boolean isGradeExists(Student student, Course course){
        boolean isExist = false;
        for (Grade grade : GradeManager.getGradesList()) {
            if(grade.getCourse() == course && grade.getStudent() == student){
                isExist = true;
            }
        }
        return isExist;
    }

    /**
     * Checks the grades existence according to ID
     * @param ID     ID of {@code Student} or {@code Course}
     * @param choice Determine {@code Student}(1) or {@code Course}(2)
     * @return       Is grade exists
     */
    public static boolean isGradeExists(int ID, int choice){
        boolean isExist = false;
        switch (choice) {
            case 1:
                for (Grade grade : GradeManager.getGradesList()) {
                    if(grade.getStudent().getStudentID() == ID){
                        isExist = true;
                    }
                }
                break;
            case 2:
                for (Grade grade : GradeManager.getGradesList()) {
                    if(grade.getCourse().getCourseID() == ID){
                        isExist = true;
                    }
                }
                break;
        }
        return isExist;
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
