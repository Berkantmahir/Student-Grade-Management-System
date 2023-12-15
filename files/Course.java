package files;

public class Course {
    
    //Variables
    private int courseID;
    private String courseName;

    /**
     * Constructor
     * @param courseID   ID of the course
     * @param courseName Name of the course
     */
    public Course(int courseID, String courseName){
        this.courseID = courseID;
        this.courseName = courseName;
    }

    /**
     * Default Constructor
     */
    public Course(){
        this.courseID = 0;
        this.courseName = "";
    }

    /**
     * @return ID of the course
     */
    public int getCourseID() {
        return courseID;
    }

    /**
     * @return Name of the course
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseID ID of the course
     */
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    /**
     * @param courseName Name of the course
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
