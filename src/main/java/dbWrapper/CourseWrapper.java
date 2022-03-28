
package dbWrapper;

import courseAllocation.Course;
import java.util.ArrayList;


public class CourseWrapper {
    
    private int lastCourseID;
    private ArrayList<Course> courses;
    
    
    public CourseWrapper(int lastCourseID,ArrayList<Course> courses){
    
    this.lastCourseID = lastCourseID;
    this.courses = courses;
    
    }

    public int getLastCourseID() {
        return lastCourseID;
    }

   
    public void setLastCourseID(int lastCourseID) {
        this.lastCourseID = lastCourseID;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
    
}
