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
     * @param student Student
     * @param course  Course
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
     * @param o Grade who is going compared
     * @return  Difference of two grades' values
     */
    @Override
    public int compareTo(Grade o) {
        return this.getGradeValue() - o.getGradeValue();
    }

    /**
     * @return Course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * @return Student
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
