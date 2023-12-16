package files;

/**
 * Student Class
 * @see Comparable
 * @author Rıfat Arifoğlu
 */

public class Student implements Comparable<Student>{
    
    //Variables
    private int studentID;
    private String name;
    private int age;
    private int year;

    /**
     * Constructor
     * @param studentID ID of the student
     * @param name      Name of the student
     * @param age       Age of the student
     * @param year      Which year of the school 
     */
    public Student(int studentID, String name, int age, int year){
        this.setStudentID(studentID);
        this.setName(name);
        this.setAge(age);
        this.setYear(year);
    }

    /**
     * Default Consturctor
     */
    public Student(){
        this(0, "", 0, 0);
    }

    /**
     * Compare to interface
     * @param o Student who is going compared
     * @return  Difference of two students' IDs
     */
    @Override
    public int compareTo(Student o) {
        return this.getStudentID() - o.getStudentID();
    }

    /**
     * To String method
     * @return String version of this object
     */
    @Override
    public String toString() {
        String output = "";
        output += "ID: " + this.getStudentID() + "\n";
        output += "Name: " + this.getName() + "\n";
        output += "Age: " + this.getAge() + "\n";
        output += "Year: " + this.getYear();
        return output;
    }

    //Getters-Setters

    /**
     * @return Age of the student
     */
    public int getAge() {
        return age;
    }

    /**
     * @return Name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * @return ID of the student
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * @return The school year of the student
     */
    public int getYear() {
        return year;
    }

    /**
     * @param age Age of the student
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @param name Name of the student
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param studentID ID of the student
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * @param year The school year of the student
     */
    public void setYear(int year) {
        this.year = year;
    }
}
