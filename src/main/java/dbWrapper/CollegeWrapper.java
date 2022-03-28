package dbWrapper;

import java.io.Serializable;
import java.util.ArrayList;
import tartlabs.counseling.Model.College;

public class CollegeWrapper implements Serializable {

    private int lastENGCollegeID;
    private int lastMEDCollegeID;
    private int lastARTCollegeID;
    private int lastcollegeNumber;
    private ArrayList<College> colleges;

    public CollegeWrapper(int lastENGCollegeID, int lastMEDCollegeID,
            int lastARTCollegeID,int lastcollegeNumber, ArrayList<College> colleges) {
        this.lastENGCollegeID = lastENGCollegeID;
        this.lastMEDCollegeID = lastMEDCollegeID;
        this.lastARTCollegeID = lastARTCollegeID;
        this.lastcollegeNumber = lastcollegeNumber;
        this.colleges = colleges;

    }

    public int getLastENGCollegeID() {
        return lastENGCollegeID;
    }

    public void setLastENGCollegeID(int lastENGCollegeID) {
        this.lastENGCollegeID = lastENGCollegeID;
    }

    public int getLastMEDCollegeID() {
        return lastMEDCollegeID;
    }

    public void setLastMEDCollegeID(int lastMEDCollegeID) {
        this.lastMEDCollegeID = lastMEDCollegeID;
    }

    public int getLastARTCollegeID() {
        return lastARTCollegeID;
    }

    public void setLastARTCollegeID(int lastARTCollegeID) {
        this.lastARTCollegeID = lastARTCollegeID;
    }

    public ArrayList<College> getColleges() {
        return colleges;
    }

    public void setColleges(ArrayList<College> colleges) {
        this.colleges = colleges;
    }

   
    public int getLastcollegeNumber() {
        return lastcollegeNumber;
    }
    
    public void setLastcollegeNumber(int lastcollegeNumber) {
        this.lastcollegeNumber = lastcollegeNumber;
    }

}
