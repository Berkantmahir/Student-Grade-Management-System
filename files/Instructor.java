package files;

import java.util.ArrayList;

/**
 * Instructor Class
 * @see Comparable
 * @author Rıfat Arifoğlu
 */
public class Instructor implements Comparable<Instructor> {

    // Variables
    private int instructorID;
    private String instructorName;
    private int instructorAge;
    private ArrayList<Course> courses;

    /**
     * Constructor
     * @param instructorID   ID of the {@code Instructor}
     * @param instructorName Name of the {@code Instructor}
     * @param instructorAge  Age of the {@code Instructor}
     */
    public Instructor(int instructorID, String instructorName, int instructorAge) {
        this.setInstructorID(instructorID);
        this.setInstructorName(instructorName);
        this.setInstructorAge(instructorAge);
        this.courses = new ArrayList<>();
    }

    /**
     * Default Consturctor
     */
    public Instructor() {
        this(0, "", 0);
    }

    /**
     * Compare to interface
     * @param o {@code Instructor} who is going compared
     * @return Difference of two {@code Intructor}s' IDs
     */
    @Override
    public int compareTo(Instructor o) {
        return this.getInstructorID() - o.getInstructorID();
    }

    /**
     * To String method
     * @return {@code String} version of this object
     */
    @Override
    public String toString() {
        String output = "";
        output += "ID: " + this.getInstructorID() + "\n";
        output += "Name: " + this.getInstructorName() + "\n";
        output += "Age: " + this.getInstructorAge() + "\n";
        return output;
    }

    /**
     * Add {@code Course} to the {@code Instructor}
     * @param course {@code Course} that going to add to the {@code Instructor}
     * @return Is {@code Course} has been added
     */
    public boolean addCourse(Course course) {
        course.setInstructor(this);
        this.getCourses().add(course);
        return true;
    }

    /**
     * Removing the course registered to a instructor.To prevent misundertoodments.
     * @param course the course that previous instructor gives.
     * @return Is{@code Course} has been removed.
     */
    public boolean removeCourse(Course course) {
        this.courses.remove(course);
        return true;
    }

    /**
     * @return Age of the {@code Instructor}
     */
    public int getInstructorAge() {
        return this.instructorAge;
    }

    /**
     * @return ID of the {@code Instructor}
     */
    public int getInstructorID() {
        return this.instructorID;
    }

    /**
     * @return Name of the {@code Instructor}
     */
    public String getInstructorName() {
        return this.instructorName;
    }

    /**
     * @return {@code Course}s that {@code Instructor} gives
     */
    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    /**
     * @param instructorAge Age of the {@code Instructor}
     */
    public void setInstructorAge(int instructorAge) {
        this.instructorAge = instructorAge;
    }

    /**
     * @param instructorID ID of the {@code Instructor}
     */
    public void setInstructorID(int instructorID) {
        this.instructorID = instructorID;
    }

    /**
     * @param instructorName Name of the {@code Instructor}
     */
    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }
}
