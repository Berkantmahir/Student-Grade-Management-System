package files;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * InstructorManager Class
 * @author Rıfat Arifoğlu
 */
public class InstructorManager {
    
    //Variables
    private static ArrayList<Instructor> instructorsList = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    /**
     * Creates a {@code Instructor}
     * @return Is the {@code Instructor} created
     */
    public static boolean createInstructor(){
        int instructorID = 0;
        String name = "";
        int age = 0;
        
        String nextLine = "";
        String format = "%-10s: ";

        System.out.print(String.format(format, "ID"));
        instructorID = in.nextInt();
        nextLine = in.nextLine();

        if(InstructorManager.findInstructor(instructorID, false) != null){
            System.out.println("This ID already exists!");
            return false;
        }

        System.out.print(String.format(format, "Name"));
        name = in.nextLine();

        System.out.print(String.format(format, "Age"));
        age = in.nextInt();
        nextLine = in.nextLine();
        
        InstructorManager.getInstructorsList().add(new Instructor(instructorID, name, instructorID));

        return true;
    }

    /**
     * Removes {@code Student} with given ID
     * @return Is {@code Student} is removed
     */
    public static boolean removeInstructor(){
        int instructorID = 0;
        Instructor instructorRemoved = null;
        String nextLine = "";

        System.out.print("ID of the student going to remove: ");
        instructorID = in.nextInt();
        nextLine = in.nextLine();
        
        instructorRemoved = InstructorManager.findInstructor(instructorID, true);

        if(instructorRemoved != null){
            InstructorManager.getInstructorsList().remove(instructorRemoved);
            return true;
        }else{
            return false;
        }
    }

    public static boolean giveCourse(Instructor instructor){
        int courseID = 0;
        Course currentCourse = null;
        String nextLine = "";

        System.out.print("ID of the course: ");
        courseID = in.nextInt();
        nextLine = in.nextLine();

        currentCourse = CourseManager.findCourse(courseID, true);
        if(currentCourse == null){
            return false;
        }

        instructor.addCourse(currentCourse);

        return true;
    }

    /**
     * Finds {@code Instructor} with instructorID.
     * @param instructorID ID of the {@code Instructor} that going to get checked
     * @param isPrinted    Whether find massage printed or not
     * @return             {@code Instructor} with gicen ID. If instructor doesn't exist returns null.
     */
    public static Instructor findInstructor(int instructorID, boolean isPrinted){

        for(Instructor instructor : InstructorManager.getInstructorsList()){
            if(instructor.getInstructorID() == instructorID){
                return instructor;
            }
        }

        if(isPrinted){
            System.out.println("There isn't any instructor that have " + instructorID + " as ID.");
        }

        return null;
    }

    /**
     * View the {@code Course}s that {@code Instructor} has giving
     * @param instructor {@code Instructor} that going to showed
     */
    public static void viewCourses(Instructor instructor){
        if(instructor.getCourses() == null){
            System.out.println("Instructor is not giving to any course currently.");
        }else{
            System.out.println("Courses that instructor giving:");
            for (Course course : instructor.getCourses()) {
                String output = "\nID: " + course.getCourseID() + "\n";
                output += "Course name: " + course.getCourseName();
                System.out.println(output);
            }
        }
    }

    /**
     * @return {@code ArrayList<Instructor>} of the {@code Instructor}s
     */
    public static ArrayList<Instructor> getInstructorsList() {
        return InstructorManager.instructorsList;
    }

    /**
     * Closes the {@code Scanner} object of the {@link files.InstructorManager} class
     */
    public static void closeScanner(){
        try {
            InstructorManager.in.close();
        } catch (Exception e) {
            System.out.println("Scanner already closed!");
        }
    }
}
