package files;

import java.util.ArrayList;

/**
 * Student Class
 * @see Comparable
 * @author Rıfat Arifoğlu
 */
public class Student implements Comparable<Student> {

    // Variables
    public static final int COURSE_LIMIT = 6;

    private int studentID;
    private String studentName;
    private int studentAge;
    private int studentYear;
    private ArrayList<Course> courses;

    /**
     * Constructor
     * @param studentID ID of the {@code Student}
     * @param name      Name of the {@code Student}
     * @param age       Age of the {@code Student}
     * @param year      Which year of the school
     */
    public Student(int studentID, String studentName, int studentAge, int studentYear) {
        this.setStudentID(studentID);
        this.setStudentName(studentName);
        this.setStudentAge(studentAge);
        this.setStudentYear(studentYear);
        this.courses = new ArrayList<>();
    }

    /**
     * Default Constuctor
     */
    public Student() {
        this(0, "", 0, 0);
    }

    /**
     * Enroll {@code Student} to a {@code Course}
     * @param course {@code Course} that going to enroll
     * @return Is {@code Student} enrolled
     */
    public boolean addCourse(Course course) {
        if (this.getCourses().size() == COURSE_LIMIT) {
            System.out.println("Student has reached the course limit.");
            return false;
        } else {
            this.getCourses().add(course);
            return true;
        }
    }

    /**
     * Compare to interface
     * @param o {@code Student} who is going compared
     * @return Difference of two {@code Student}s' IDs
     */
    @Override
    public int compareTo(Student o) {
        return this.getStudentID() - o.getStudentID();
    }

    /**
     * To String method
     * @return {@code String} version of this object
     */
    @Override
    public String toString() {
        String output = "";
        output += "ID: " + this.getStudentID() + "\n";
        output += "Name: " + this.getStudentName() + "\n";
        output += "Age: " + this.getStudentAge() + "\n";
        output += "Year: " + this.getStudentYear();
        return output;
    }

    // Getters-Setters

    /**
     * @return Age of the {@code Student}
     */
    public int getStudentAge() {
        return this.studentAge;
    }

    /**
     * @return Name of the {@code Student}
     */
    public String getStudentName() {
        return this.studentName;
    }

    /**
     * @return ID of the {@code Student}
     */
    public int getStudentID() {
        return this.studentID;
    }

    /**
     * @return The school year of the {@code Student}
     */
    public int getStudentYear() {
        return this.studentYear;
    }

    /**
     * @return {@code Course}s that {@code Student} enrolled
     */
    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    /**
     * @param studentAge Age of the {@code Student}
     */
    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    /**
     * @param studentName Name of the {@code Student}
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @param studentID ID of the {@code Student}
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * @param year The school year of the {@code Student}
     */
    public void setStudentYear(int studentYear) {
        this.studentYear = studentYear;
    }
}
