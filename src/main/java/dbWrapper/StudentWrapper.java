
package dbWrapper;

import java.io.Serializable;
import java.util.ArrayList;
import tartlabs.counseling.Model.Student;

public class StudentWrapper implements Serializable{
    
    private int lastStudentRegNo;
    private ArrayList<Student>students;
    private int lastStudentRank;
        
    public StudentWrapper(Integer lastStudentRegNo,ArrayList<Student> students){
        this.lastStudentRegNo = lastStudentRegNo;
        //this.lastStudentRank = lastStudentRank;
        this.students = students;
    
    
    
    }

  
    public ArrayList<Student> getStudents() {
        return students;
    }

   
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

   
    public int getLastStudentRegNo() {
        return lastStudentRegNo;
    }

   
    public void setLastStudentRegNo(int lastRegNo) {
        this.lastStudentRegNo = lastRegNo;
    }


  
    
}
