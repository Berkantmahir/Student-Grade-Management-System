package files;

public class Grade {
    
    //Variables
    private int gradeValue;
    private Student student;
    private Course course;

    /**
     * Constructor
     * @param student Student
     * @param course  Course
     */
    public Grade(Student student, Course course){
        this.gradeValue = 0;
        this.student = student;
        this.course = course;
    }

    /**
     * Default Constructor
     */
    public Grade(){
        this(null, null);
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
