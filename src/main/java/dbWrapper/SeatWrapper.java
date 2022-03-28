
package dbWrapper;

import java.io.Serializable;
import java.util.ArrayList;
import tartlabs.counseling.Model.Seat;


public class SeatWrapper implements Serializable{
    
     private int lastseatID;
    private ArrayList<Seat> seats;
    
    
    public SeatWrapper(int lastseatID,ArrayList<Seat> seats){
    
    this.lastseatID = lastseatID;
    this.seats = seats;
    
    }

    public int getLastseatID() {
        return lastseatID;
    }

    public void setLastseatID(int lastseatID) {
        this.lastseatID = lastseatID;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

   
    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

}
