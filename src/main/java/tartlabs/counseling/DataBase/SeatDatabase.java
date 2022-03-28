package tartlabs.counseling.DataBase;

import courseAllocation.Course;
import java.io.IOException;
import java.util.ArrayList;
import static tartlabs.counseling.DataBase.CollegeDatabase.getColleges;
import static tartlabs.counseling.DataBase.StudentDatabase.getStudents;
import tartlabs.counseling.Model.College;
import tartlabs.counseling.Model.Seat;
import tartlabs.counseling.Model.Student;
import util.AppUtil;
import util.FileUtil;
import util.LogUtil1;

public class SeatDatabase {
    
    private static ArrayList<Seat> seats = FileUtil.seatDeserialize();
    
    public static void seatAllocation() throws IOException {
        
        int regNo = AppUtil.getRegNo();
        
        for (Student s : getStudents()) {
            if (s.getRegNo() != regNo) {
                continue;
            }
            
            for (Seat seat : getSeats()) {
                if (seat.regNo == regNo) {
                    LogUtil1.log("Already Seat "
                            + "Allocated for this register number!!");
                    return;
                    
                }
            }
            
            int choice = AppUtil.getIntegerformatFromUser
        (1, 2, new String[]{"Do you want Seat Allocate "
                + "Collegewise or Coursewise",
                "1.College", "2.Course"},
                    "Please enter the correct choice*");
            
            if (choice == 1) {
                SeatDatabase.collegeWise(regNo);
                
            } else if (choice == 2) {
                SeatDatabase.courseWise(regNo);
                
            }
            
        }
        FileUtil.collegeSerialize(getColleges());
        FileUtil.seatSerialize(getSeats());
    }
    
    public static void collegeWise(int regNo) {
 
        FileUtil.collegeDeserialize();
        CollegeDatabase.printSeatCollegeDetails();
        
        int collegeID = AppUtil.getCollegeID();
        
        for (College c : getColleges()) {
            if (c.collegeID == collegeID) {
                for (Course course : c.getCourses()) {
                    if (course.getMaxSeat() != 0) {
                        LogUtil1.log("-------------------------------");
                        LogUtil1.log("courseID:" + course.courseID);
                        LogUtil1.log("collegName:" + c.collegeName);
                        LogUtil1.log("courseName:" + course.courseName);
                        LogUtil1.log("Seat count:" + course.getMaxSeat());
                        LogUtil1.log("------------------------------");
                    }
                }
            }
        }
        
        
     
        LogUtil1.log("Go Back to Previous CLICK(0)");
      
        int courseID = AppUtil.getDBCourseID(collegeID);
        
        

        int menu = AppUtil.getIntegerformatFromUser(1, 2,
                new String[]{"Are You Sure Confirm Your Seat!"
                    + " allocate", "1.Yes", "2.No"},
                "Please enter the correct choice");
        
        if (menu == 1) {
            for (College c : getColleges()) {
                if (c.collegeID == collegeID) {
                    for (Course course : c.getCourses()) {
                        if (course.courseID == courseID) {
                            
                            if (course.getMaxSeat() > course.allocatedSeat) {
                                //course.setMaxSeat(course.getMaxSeat() - 1);
                                course.maxSeat--;
                                course.allocatedSeat--;
                                LogUtil1.log("SEAT BOOKED IN ->"
                                        + '\n' + "CollegeName:" + c.collegeName
                                        + '\n' + "CourseName:" + course.courseName);
                                break;
                            } else if (course.getMaxSeat() == 0) {
                                LogUtil1.log("No seats availabe to allocate");
                                break;
                            } else {
                                LogUtil1.log("Seats are filled");
                                break;
                            }
                        }
                    }
                }
                
            }
            Seat seat2 = new Seat(regNo, collegeID, courseID);
            seats.add(seat2);
            
        } else if (menu == 2) {
            return;
            
        }
        
    }
    
    public static void courseWise(int regNo) {
        FileUtil.collegeDeserialize();
        CollegeDatabase.printCourseDetails1();
        
        String courseName = AppUtil.getCouresName();
        
        for (College c : getColleges()) {
            for (Course course : c.getCourses()) {
                
                if (courseName.equals(course.courseName)) {
                    if (course.getMaxSeat() != 0) {
                        LogUtil1.log("====================================");
                        LogUtil1.log("collegeID:" + c.collegeID);
                        LogUtil1.log("collegeName:" + c.collegeName);
                        LogUtil1.log("collegeCode:" + c.collegeCode);
                        LogUtil1.log("courseName:" + course.courseName);
                        LogUtil1.log("Seat Count:" + course.getMaxSeat());
                        LogUtil1.log("====================================");
                    }
                }
            }
        }
        
        LogUtil1.log("Go Back to Previous CLICK(0)");
        AppUtil.previousMenuCourseWise(regNo);
        int collegeID
                = AppUtil.printDBCollegeID(courseName);
        
        int menu = AppUtil.
                getIntegerformatFromUser(1, 2, new String[]{"Are You Sure "
                        + "confirm your seat",
            "1.Yes", "2.No"},
                        "Please enter the correct choice");
        if (menu == 1) {
            for (College c : getColleges()) {
                if (c.collegeID == collegeID) {
                    for (Course course : c.getCourses()) {
                        
                        if (courseName.equals(course.courseName)) {
                            
                            if (course.getMaxSeat() > course.allocatedSeat) {
                                //course.setMaxSeat(course.getMaxSeat() - 1);
                                course.maxSeat--;
                                course.allocatedSeat--;
                                LogUtil1.log("SEAT BOOKED IN ->"
                                        + '\n' + "CollegeName:" + c.collegeName
                                        + '\n' + "CourseName:" + course.courseName);
                                break;
                            } else if (course.getMaxSeat() == 0) {
                                LogUtil1.log("No seats availabe to allocate");
                                break;
                            } else {
                                LogUtil1.log("Seats are filled");
                                break;
                            }
                        }
                    }
                    
                }
                
            }
            
        } else if (menu == 2) {
            return;
            
        }
        Seat seat2 = new Seat(regNo, collegeID, courseName);
        seats.add(seat2);
        
    }
    
    public static void printSeatDetails() {
        
        for (Seat seat : getSeats()) {
            
            for (College c : getColleges()) {
                if (c.collegeID == seat.collegeID) {
                    LogUtil1.log("--------------------------------------");
                    LogUtil1.log("Student ID:" + seat.regNo);
                    LogUtil1.log("SeatID:" + seat.seatNO);
                    for (Course course : c.getCourses()) {
                        
                        if (course.courseID == seat.courseID) {
                            LogUtil1.log("courseName:" + course.courseName);
                        }
                    }
                    LogUtil1.log("collegeName:" + c.collegeName);
                    for (Course course : c.getCourses()) {
                        if (course.courseName.equals(seat.courseName)) {
                            LogUtil1.log("courseName:" + seat.courseName);
                            LogUtil1.log("--------------------------------------");
                        }
                        
                    }
                }
            }
        }
        
    }
    
    public static void bookedCollegeDetails() {
        for (College c : getColleges()) {
            if (c.collegeType == College.ENG) {
                LogUtil1.log("====================================");
                LogUtil1.log("collegeID:" + c.getCollegeID());
                LogUtil1.log("collegeName:" + c.collegeName);
                LogUtil1.log("collegeCode:" + c.collegeCode);
                for (Course course : c.getCourses()) {
                    
                    LogUtil1.log(".......................................");
                    LogUtil1.log("CourseNo:" + course.courseID);
                    LogUtil1.log("CourseName:" + course.courseName);
                    LogUtil1.log("Total seat Count:" + course.totalSeat );
                    LogUtil1.log("Balance seats Count:" + course.getMaxSeat());
                    LogUtil1.log("Booked Seat Count:" + course.allocatedSeat);
                    LogUtil1.log(".......................................");
                }
                LogUtil1.log("====================================");
                
            }
        }
        
    }
    
    public static ArrayList<Seat> getSeats() {
        return seats;
    }
    
    public static void setSeats(ArrayList<Seat> aSeats) {
        seats = aSeats;
    }
    
}
