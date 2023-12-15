package files;

/**
 * Student Class
 * @author Rıfat Arifoğlu
 */

public class Student {
    
    //Variables
    private int studentID;
    private String name;
    private int age;
    private int year;

    /**
     * Consturtor
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
        this.setStudentID(0);
        this.setName("");
        this.setAge(0);
        this.setYear(0);
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
