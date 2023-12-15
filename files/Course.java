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
        setCourseID(courseID);
        setCourseName(courseName);
    }

    /**
     * Default Constructor
     */
    public Course(){
        setCourseID(0);
        setCourseName("");
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
