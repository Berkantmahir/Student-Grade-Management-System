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
     * @param studentID ID of the {@code Student}
     * @param name      Name of the {@code Student}
     * @param age       Age of the {@code Student}
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
     * @param o {@code Student} who is going compared
     * @return  Difference of two {@code Student}s' IDs
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
        output += "Name: " + this.getName() + "\n";
        output += "Age: " + this.getAge() + "\n";
        output += "Year: " + this.getYear();
        return output;
    }

    //Getters-Setters

    /**
     * @return Age of the {@code Student}
     */
    public int getAge() {
        return age;
    }

    /**
     * @return Name of the {@code Student}
     */
    public String getName() {
        return name;
    }

    /**
     * @return ID of the {@code Student}
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * @return The school year of the {@code Student}
     */
    public int getYear() {
        return year;
    }

    /**
     * @param age Age of the {@code Student}
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @param name Name of the {@code Student}
     */
    public void setName(String name) {
        this.name = name;
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
    public void setYear(int year) {
        this.year = year;
    }
}
