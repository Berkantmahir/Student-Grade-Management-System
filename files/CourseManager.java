package files;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * CourseManager Class
 * @author Rıfat Arifoğlu
 */
public class CourseManager {
    
    //Variables
    private static ArrayList<Course> courcesList = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    /**
     * Create a {@code Course}
     * @return Is the {@code Course} created
     */
    public static boolean addCourse(){
        int courseID = 0;
        String name = "";
        int quota = 0;
        
        String nextLine = "";
        String format = "%-10s: ";

        System.out.print(String.format(format, "ID"));
        courseID = in.nextInt();
        nextLine = in.nextLine();

        if(CourseManager.findCourse(courseID, false) != null){//
            System.out.println("This ID already exists!");
            return false;
        }

        System.out.print(String.format(format, "Name"));
        name = in.nextLine();

        System.out.print(String.format(format, "Quota"));
        quota = in.nextInt();
        nextLine = in.nextLine();
        
        CourseManager.getCourseList().add(new Course(courseID, name, quota));

        return true;
    }

    /**
     * Removes {@code Course} with given ID
     * @return Is {@code Course} is removed
     */
    public static boolean removeCourse(){
        int courseID = 0;
        Course courseRemoved = null;
        String nextLine = "";

        System.out.print("ID of the course going to remove: ");
        courseID = in.nextInt();
        nextLine = in.nextLine();
        
        courseRemoved = CourseManager.findCourse(courseID, true);

        if(courseRemoved != null){
            CourseManager.getCourseList().remove(courseRemoved);
            return true;
        }else{
            return false;
        }

    }

    /**
     * Prints out {@code Course} details with given ID
     */
    public static void viewCourseDetails(){
        int courseID = 0;
        Course course;
        String nextLine = "";

        System.out.print("ID of the course going to view: ");
        courseID = in.nextInt();
        nextLine = in.nextLine();

        System.out.println();
        
        course = CourseManager.findCourse(courseID, true);

        if(course != null){
            System.out.print(course);
        }

    }

    /**
     * Checks if this {@code Course} is already created.
     * @param ID ID of the {@code Course} that going to get checked
     * @return  Is this {@code Course} exists
     */
    public static Course findCourse(int courseID, boolean isPrinted){
        for(Course course : CourseManager.getCourseList()){
            if(course.getCourseID() == courseID){
                return course;
            }
        }

        if(isPrinted){
            System.out.println("There isn't any course that have " + courseID + " as ID.");
        }

        return null;
    }

    /**
     * @return {@code ArrayList<Course>} of the students
     */
    public static ArrayList<Course> getCourseList() {
        return CourseManager.courcesList;
    }

    /**
     * Closes the {@code Scanner} object of the {@link files.CourseManagement} class
     */
    public static void closeScanner(){
        try {
            CourseManager.in.close();
        } catch (Exception e) {
            System.out.println("Scanner already closed!");
        }
    }
}
