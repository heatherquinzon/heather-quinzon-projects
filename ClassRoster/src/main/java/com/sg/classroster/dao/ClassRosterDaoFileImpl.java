//THIS IS DAO (implementation)
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author heath
 */
public class ClassRosterDaoFileImpl implements ClassRosterDao {

    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";

    private Map<String, Student> students = new HashMap<>();

    @Override
    public Student addStudent(String studentId, Student student) 
        throws ClassRosterPersistenceException {
        Student newStudent = students.put(studentId, student);
        writeRoster();
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() 
        throws ClassRosterPersistenceException{
        loadRoster();
        //gets all student obj out of the students by calling values()
        return new ArrayList<Student>(students.values());
    }
    

    @Override
    public Student getStudent(String studentId) 
        throws ClassRosterPersistenceException{
        loadRoster();
        return students.get(studentId);
    }
    

    @Override
    public Student removeStudent(String studentId) 
        throws ClassRosterPersistenceException{
        Student removedStudent = students.remove(studentId);
        writeRoster();
        return removedStudent;
    }
    

    public void loadRoster() throws ClassRosterPersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(
                    new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new ClassRosterPersistenceException(
                    "-_- Could not load roster into memory.", e);
        }
        
        String currentLine;
        
        String[] currentTokens;
        
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            
            currentTokens = currentLine.split(DELIMITER);
            
            Student currentStudent = new Student(currentTokens[0]);
            
            currentStudent.setFirstName(currentTokens[1]);
            currentStudent.setLastName(currentTokens[2]);
            currentStudent.setCohort(currentTokens[3]);
            
            students.put(currentStudent.getStudentId(), currentStudent);
            
        }
        
        scanner.close();
    }
    
    private void writeRoster() throws ClassRosterPersistenceException{
        
        PrintWriter out;
        
        try{
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        }catch(IOException e){
            throw new ClassRosterPersistenceException(
            "Could not save student data.", e);
        }
        
        List<Student> studentList = this.getAllStudents();
        for(Student currentStudent : studentList){
            out.println(currentStudent.getStudentId() + DELIMITER
            + currentStudent.getFirstName() + DELIMITER
            + currentStudent.getLastName() + DELIMITER
            + currentStudent.getCohort());
            
            out.flush();
        }
        out.close();
    }
    
    

}
