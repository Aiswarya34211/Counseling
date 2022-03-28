package courseAllocation;

import java.io.Serializable;


public class Course implements Serializable {
   

    public String courseName;
    public int courseID;
    public int maxSeat;
    public int allocatedSeat = 0;
    public int collegeType;
    public int totalSeat;
    
    
   

    public Course(String courseName, int maxSeats, int courseID) {
        this.courseName = courseName;
        this.maxSeat = maxSeats;
        this.courseID = courseID;
        this.totalSeat = generateSeat1();
        
    }
    
    public  int  generateSeat1() {
      maxSeat = (maxSeat + allocatedSeat);
        return maxSeat;

    }
  
    
   
    public int getCourseID() {
        return courseID;
    }

  
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

   
  
    public int getMaxSeat() {
        return maxSeat;
    }

    public void setMaxSeat(int maxSeat) {
        this.maxSeat = maxSeat;
    }
    
}
