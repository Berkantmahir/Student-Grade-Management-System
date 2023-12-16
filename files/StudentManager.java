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
     * Create a {@code Student}
     * @return Is the {@code Student} created
     */
    public static boolean addStudent(){
        int studentID = 0;
        String name = "";
        int age = 0;
        int year = 0;
        
        String nextLine = "";
        String format = "%-10s: ";

        System.out.print(String.format(format, "ID"));
        studentID = in.nextInt();
        nextLine = in.nextLine();

        if(StudentManager.isStudentExist(studentID)){
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

        System.out.println("ID of the student going to remove: ");
        
        if(!StudentManager.isStudentExist(studentID)){
            System.out.println("There isn't any student that have " + studentID + " ID.");
            return false;
        }

        for(Student student : StudentManager.getStudentsList()){
            if(student.getStudentID() == studentID){
                StudentManager.studentsList.remove(student);
            }
        }

        return true;
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

        if(!CourseManager.isCourseExist(0)){
            System.out.println("There isn't any course that have " + courseID + " ID.");
            return false;
        }

        for(Course course : CourseManager.getCourseList()){
            if(course.getCourseID() == courseID){
                currentCourse = course;
            }
        }

        System.out.print("ID of the student going to enrolled: ");
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

        return currentCourse.addStudent(currentStudent);
    }

    /**
     * Checks if this {@code Student} is already created.
     * @param ID ID of the {@code Student} that going to get checked
     * @return   Is this {@code Student} exists
     */
    public static boolean isStudentExist(int ID){
        for (Student student : StudentManager.getStudentsList()) {
            if(student.getStudentID() == ID){
                return true;
            }
        }
        return false;
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
