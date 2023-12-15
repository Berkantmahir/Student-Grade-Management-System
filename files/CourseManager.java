package files;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseManager {
    
    //Variables
    private static ArrayList<Course> courcesList = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    /**
     * Checks if this course is already created.
     * @param s Course that going to get checked
     * @return  Is this course exists
     */
    public static boolean isCourseExist(int ID){
        for (Course course : CourseManager.getCourseList()) {
            if(course.getCourseID() == ID){
                return true;
            }
        }
        return false;
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
