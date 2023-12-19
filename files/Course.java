package files;

import java.util.ArrayList;

/**
 * Course Class
 * @see Comparable
 * @author Rıfat Arifoğlu
 */
public class Course implements Comparable<Course> {

    // Variables
    private int courseID;
    private String courseName;
    private int quota;
    private Instructor instructor;
    private ArrayList<Student> enrolledStudents;

    /**
     * Constructor
     * @param courseID   ID of the {@code Course}
     * @param courseName Name of the {@code Course}
     */
    public Course(int courseID, String courseName, int quota) {
        setCourseID(courseID);
        setCourseName(courseName);
        setQuota(quota);
        setInstructor(null);
        enrolledStudents = new ArrayList<>();
    }

    /**
     * Default Constructor
     */
    public Course() {
        this(0, "", 0);
    }

    /**
     * Add {@code Student} to the {@code Course}
     * @param student {@code Student} that going to add to the {@code Course}
     * @return Is {@code Student} has been enrolled
     */
    public boolean addStudent(Student student) {
        for (Student enrolled : this.getEnrolledStudents()) {
            if (student == enrolled) {
                System.out.println("This student already enrolled.");
                return false;
            }
        }
        if (quota > this.getEnrolledStudents().size()) {
            this.getEnrolledStudents().add(student);
            student.addCourse(this);
            return true;
        } else {
            System.out.println("Quota has reached.");
            return false;
        }
    }

    /**
     * Compare to interface
     * @param o {@code Course} who is going compared
     * @return Difference of two {@code Course}s' IDs
     */
    @Override
    public int compareTo(Course o) {
        return this.getCourseID() - o.getCourseID();
    }

    /**
     * To String method
     * @return {@code String} version of this object
     */
    @Override
    public String toString() {
        String output = "";
        output += "ID: " + this.getCourseID() + "\n";
        output += "Name: " + this.getCourseName();

        if (!this.getEnrolledStudents().isEmpty()) {
            output += "\nStudents:\n";
            for (Student student : this.getEnrolledStudents()) {
                output += "\n" + student + "\n";
            }
        } else {
            output += "\nThere isn't any student currently enrolled to this course";
        }

        return output;
    }

    /**
     * @return ID of the {@code Course}
     */
    public int getCourseID() {
        return courseID;
    }

    /**
     * @return Name of the {@code Course}
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @return Quota of the {@code Course}
     */
    public int getQuota() {
        return quota;
    }

    /**
     * @return {@code ArrayList} of the enrolled {@code Student}s
     */
    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    /**
     * @return {@code Instructor} of the {@code Course}
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * @param courseID ID of the {@code Course}
     */
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    /**
     * @param courseName Name of the {@code Course}
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @param quota Quota of the {@code Course}
     */
    public void setQuota(int quota) {
        this.quota = quota;
    }

    /**
     * @param instructor {@code Instructor} of the {@code Course}
     */
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
