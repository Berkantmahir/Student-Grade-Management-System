package files;

/**
 * Grade Class
 * @see Comparable
 * @author Rıfat Arifoğlu
 */
public class Grade implements Comparable<Grade>{
    
    //Variables
    private double gradeValue;
    private Student student;
    private Course course;

    /**
     * Constructor
     * @param student {@code Student}
     * @param course  {@code Course}
     */
    public Grade(Student student, Course course, double gradeValue){
        this.gradeValue = gradeValue;
        this.student = student;
        this.course = course;
    }

    /**
     * Default Constructor
     */
    public Grade(){
        this(null, null, 0.0);
    }

    /**
     * Compare to interface
     * @param o {@code Grade} who is going compared
     * @return  Difference of two {@code Grade}s' values
     */
    @Override
    public int compareTo(Grade o) {
        return (int)(this.getGradeValue() - o.getGradeValue());
    }

    /**
     * To String method
     * @return {@code String} version of this object
     */
    @Override
    public String toString() {
        String output = "";
        output += "ID of Student: " + this.getStudent().getStudentID() + "\n";
        output += "ID of Course: " + this.getCourse().getCourseID() + "\n";
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
    public double getGradeValue() {
        return gradeValue;
    }

    /**
     * @param gradeValue Value of grade
     */
    public void setGradeValue(double gradeValue) {
        this.gradeValue = gradeValue;
    }
}
