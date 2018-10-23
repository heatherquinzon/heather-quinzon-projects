//THIS IS VIEW
package com.sg.classroster.ui;

import com.sg.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author heath
 */
public class ClassRosterView {

    private UserIO io; //= new UserIOConsoleImpl();
    
    public ClassRosterView(UserIO io){
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        io.print("\nMain Menu");
        io.print("1. List Student IDs");
        io.print("2. Create New Student");
        io.print("3. View a Student");
        io.print("4. Remove a student");
        io.print("5. Exit");

        return io.readInt("Please select from above: ");
    }

    public Student getNewStudentInfo() {
        String studentId = io.readString("Enter Student ID: ");
        String firstName = io.readString("Enter student's first name: ");
        String lastName = io.readString("Enter student's last name: ");
        String cohort = io.readString("Enter cohort: ");

        Student currentStudent = new Student(studentId);

        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        currentStudent.setCohort(cohort);

        return currentStudent;
    }

    public void displayCreateStudentBanner() {
        io.print("=== Create Student ===");
    }

    public void displayCreateSuccessBanner() {
        io.print("Student succesfully create."
                + " Please hit enter to continue.");
    }

    public void displayStudentList(List<Student> studentList) {
        for (Student currentStudent : studentList) {
            io.print("" + currentStudent.getStudentId() + ": "
                    + currentStudent.getFirstName()
                    + currentStudent.getLastName());
        }
        io.readString("Please hit enter to continue");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Students ===");
    }
    
    public void displayDisplayStudentBanner(){
        io.print("=== Display Student ===");
    }
    
    public String getStudentIdChoice(){
        return io.readString("Please enter the student ID.");
    }
    
    public void displayStudent(Student student){
        if(student != null){
            io.print(student.getStudentId());
            io.print(student.getFirstName()
            + " " + student.getLastName());
            io.print(student.getCohort());
            io.print("");
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue");
    }
    
    public void displayRemoveStudentBanner(){
        io.print("=== Remove Student ===");
    }
    
    public void displayRemoveSuccessBanner(){
        io.readString("Student succesfully removed."
                + " Please hit enter to continue");
    }
    
    public void displayExitBanner(){
        io.print("GOOD BYE!!!");
    }
    
    public void displayUnknownCommandBanner(){
        io.print("UNKNOWN COMMAD");
    }
    
    public void displayErrorMessage(String errorMsg){
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
