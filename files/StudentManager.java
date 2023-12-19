package files;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * StudentManager Class
 * @author Rıfat Arifoğlu
 */
public class StudentManager {

    //Variables
    private static ArrayList<Student> studentsList = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);
    
    /**
     * Creates a {@code Student}
     * @return Is the {@code Student} created
     */
    public static boolean createStudent(){
        int studentID = 0;
        String name = "";
        int age = 0;
        int year = 0;
        
        String nextLine = "";
        String format = "%-10s: ";

        System.out.print(String.format(format, "ID"));
        studentID = in.nextInt();
        nextLine = in.nextLine();

        if(StudentManager.findStudent(studentID, false) != null){
            System.out.println("This ID already exists!");
            return false;
        }

        System.out.print(String.format(format, "Name"));
        name = in.nextLine();

        System.out.print(String.format(format, "Age"));
        age = in.nextInt();
        nextLine = in.nextLine();

        System.out.print(String.format(format, "Year"));
        year = in.nextInt();
        nextLine = in.nextLine();
        
        StudentManager.getStudentsList().add(new Student(studentID, name, age, year));

        return true;
    }

    /**
     * Removes {@code Student} with given ID
     * @return Is {@code Student} is removed
     */
    public static boolean removeStudent(){
        int studentID = 0;
        Student studentRemoved = null;
        String nextLine = "";

        System.out.print("ID of the student going to remove: ");
        studentID = in.nextInt();
        nextLine = in.nextLine();
        
        studentRemoved = StudentManager.findStudent(studentID, true);

        if(studentRemoved != null){
            StudentManager.getStudentsList().remove(studentRemoved);
            return true;
        }else{
            return false;
        }

    }

    /**
     * Enroll {@code Student} to a {@code Course}
     * @return Is {@code Student} has enrolled
     */
    public static boolean enrollStudent(){
        int courseID = 0;
        int studentID = 0;
        Course currentCourse = null;
        Student currentStudent = null;

        String nextLine = "";

        System.out.print("ID of the course going to enrolled: ");
        courseID = in.nextInt();
        nextLine = in.nextLine();

        currentCourse = CourseManager.findCourse(courseID, true);

        if(currentCourse == null){
            return false;
        }

        System.out.print("ID of the student going to enrolled: ");
        studentID = in.nextInt();
        nextLine = in.nextLine();

        currentStudent = StudentManager.findStudent(studentID, true);

        if(currentStudent != null){
            return currentCourse.addStudent(currentStudent);
        }else{
            return false;
        }

    }

    /**
     * Enroll {@code Student} to a {@code Course}
     * @param  student {@code Student} that going to enrolled
     * @return         Is {@code Student} has enrolled
     */
    public static boolean enrollStudent(Student student){
        int courseID = 0;
        Course currentCourse = null;

        String nextLine = "";

        System.out.print("ID of the course going to enrolled: ");
        courseID = in.nextInt();
        nextLine = in.nextLine();

        currentCourse = CourseManager.findCourse(courseID, true);

        if(currentCourse == null){
            return false;
        }
        
        return currentCourse.addStudent(student);

    }

    /**
     * Finds {@code Student} with studentID.
     * @param studentID ID of the {@code Student} that going to get checked
     * @param isPrinted Whether find massage printed or not
     * @return          {@code Student} with gicen ID. If student doesn't exist returns null.
     */
    public static Student findStudent(int studentID, boolean isPrinted){

        for(Student student : StudentManager.getStudentsList()){
            if(student.getStudentID() == studentID){
                return student;
            }
        }

        if(isPrinted){
            System.out.println("There isn't any student that have " + studentID + " as ID.");
        }

        return null;
    }

    /**
     * View the {@code Course}s that {@code Student} has enrolled
     * @param student {@code Student} that going to showed
     */
    public static void viewCourses(Student student){
        if(student.getCourses() == null){
            System.out.println("Student has not enrolled to any course currently.");
        }else{
            System.out.println("Courses that student enrolled:");
            for (Course course : student.getCourses()) {
                String output = "\nID: " + course.getCourseID() + "\n";
                output += "Course name: " + course.getCourseName();
                System.out.println(output);
            }
        }
    }

    /**
     * @return {@code ArrayList<Student>} of the students
     */
    public static ArrayList<Student> getStudentsList() {
        return StudentManager.studentsList;
    }

    /**
     * Closes the {@code Scanner} object of the {@link files.StudentManager} class
     */
    public static void closeScanner(){
        try {
            StudentManager.in.close();
        } catch (Exception e) {
            System.out.println("Scanner already closed!");
        }
    }
}
