package files;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseManager {
    
    //Variables
    private static ArrayList<Course> courcesList = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    /**
     * Create a {@code Course}
     * @return Is the course created
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

        if(StudentManagement.isStudentExist(courseID)){
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

    public boolean removeCourse(){
        //TO-DO
        return true;
    }

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
