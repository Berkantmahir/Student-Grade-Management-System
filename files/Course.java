package files;

import java.util.ArrayList;

/**
 * Course Class
 * @see Comparable
 * @author Rıfat Arifoğlu
 */

public class Course implements Comparable<Course>{
    
    //Variables
    private int courseID;
    private String courseName;
    private int quota;
    private ArrayList<Student> enrolledStudents;

    /**
     * Constructor
     * @param courseID   ID of the course
     * @param courseName Name of the course
     */
    public Course(int courseID, String courseName, int quota){
        setCourseID(courseID);
        setCourseName(courseName);
        enrolledStudents = new ArrayList<>();
    }

    /**
     * Add student to the course
     * @param student Student that going to add to the course
     * @return        If student has been enrolled
     */
    public boolean addStudent(Student student){
        if(quota > this.getEnrolledStudents().size()){
            this.getEnrolledStudents().add(student);
            return true;
        }else{
            System.out.println("Quota has reached.");
            return false;
        }
    }

    /**
     * Compare to interface
     * @param o Course who is going compared
     * @return  Difference of two courses' IDs
     */
    @Override
    public int compareTo(Course o) {
        return this.getCourseID() - o.getCourseID();
    }

    /**
     * To String method
     * @return String version of this object
     */
    @Override
    public String toString() {
        String output = "";
        output += "ID: " + this.getCourseID() + "\n";
        output += "Name: " + this.getCourseName();

        if(!this.getEnrolledStudents().isEmpty()){
            output += "\nStudents:";
            for (Student student : this.getEnrolledStudents()) {
                output += "\n" + student;
            }
        }

        return output;
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
     * @return Quota of the course
     */
    public int getQuota() {
        return quota;
    }

    /**
     * @return {@code ArrayList} of the enrolled students
     */
    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
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

    /**
     * @param quota Quota of the course
     */
    public void setQuota(int quota) {
        this.quota = quota;
    }
}
