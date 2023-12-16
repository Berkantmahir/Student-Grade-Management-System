package files;

public class Main{
    public static void main(String[] args) {
        
        //Close the Scanners of managers
        StudentManager.closeScanner();
        CourseManager.closeScanner();
        GradeManager.closeScanner();
    }
}