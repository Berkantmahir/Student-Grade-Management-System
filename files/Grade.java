package files;

/**
 * Grade Class
 * @see Comparable
 * @author Rıfat Arifoğlu
 */
public class Grade implements Comparable<Grade>{
    
    //Variables
    private int gradeValue;
    private Student student;
    private Course course;

    /**
     * Constructor
     * @param student {@code Student}
     * @param course  {@code Course}
     */
    public Grade(Student student, Course course, int gradeValue){
        this.gradeValue = gradeValue;
        this.student = student;
        this.course = course;
    }

    /**
     * Default Constructor
     */
    public Grade(){
        this(null, null, 0);
    }

    /**
     * Compare to interface
     * @param o {@code Grade} who is going compared
     * @return  Difference of two {@code Grade}s' values
     */
    @Override
    public int compareTo(Grade o) {
        return this.getGradeValue() - o.getGradeValue();
    }

    /**
     * To String method
     * @return {@code String} version of this object
     */
    @Override
    public String toString() {
        String output = "";
        output += "ID of Student: " + this.getStudent().getStudentID();
        output += "ID of Course: " + this.getCourse().getCourseID();
        output += "Grade: " + this.getGradeValue();
        return output;
    }

    /**
     * @return {@code Course}
     */
    public Course getCourse() {
        return course;
    }

    /**
     * @return {@code Student}
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @return Grade value
     */
    public int getGradeValue() {
        return gradeValue;
    }

    /**
     * @param gradeValue Value of grade
     */
    public void setGradeValue(int gradeValue) {
        this.gradeValue = gradeValue;
    }
}
