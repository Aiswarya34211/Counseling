
package tartlabs.counseling.Model;

import java.io.Serializable;


public class Seat  implements Serializable {
    
    private static int lastseatNumber = 0;
    
    public int regNo;
    public int seatNO;
    public int collegeID;
    public int courseID;
    public String collegeName;
    public String courseName;
    
    public Seat(int regNo,int collegeID,int courseID){
        this.regNo = regNo;
        this.collegeID = collegeID;
        this.courseID = courseID;
        this.seatNO = generateseatNumber();
        
    }
    public Seat(int regNo,int collegeID,String courseName){
        this.regNo = regNo;
        this.collegeID = collegeID;
        this.courseName = courseName;
        this.seatNO = generateseatNumber();
    }

    private int generateseatNumber() {
        setLastseatNumber(getLastseatNumber() + 1);
        return getLastseatNumber();
                
    }

    public static int getLastseatNumber() {
        return lastseatNumber;
    }

    public static void setLastseatNumber(int aLastseatNumber) {
        lastseatNumber = aLastseatNumber;
    }
}
