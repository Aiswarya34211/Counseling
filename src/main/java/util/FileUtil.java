package util;

import courseAllocation.Course;
import dbWrapper.CollegeWrapper;
import dbWrapper.CourseWrapper;
import dbWrapper.SeatWrapper;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import tartlabs.counseling.Model.College;
import tartlabs.counseling.Model.Student;
import dbWrapper.StudentWrapper;
import tartlabs.counseling.Model.Seat;

public abstract class FileUtil {

    private static final String STUDENT_FILE_NAME = "student.txt";
    private static final String COLLEGE_FILE_NAME = "college.txt";
    private static final String SEAT_FILE_NAME = "seat.txt";

    public static void studentSerialize(ArrayList<Student> students) {

        try {
            FileOutputStream file = new FileOutputStream(STUDENT_FILE_NAME);
            ObjectOutputStream out = new ObjectOutputStream(file);
            StudentWrapper wrapper = new StudentWrapper(Student.getLastRegNo(),
                  students);
            out.writeObject(wrapper);

            out.close();

        } catch (Exception e) {
            LogUtil1.log(e.getMessage());
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> studentDeserialize() {
        ArrayList<Student> students = new ArrayList<>();

        try {
            FileInputStream file = new FileInputStream(STUDENT_FILE_NAME);
            ObjectInputStream in = new ObjectInputStream(file);

            StudentWrapper studentsWrapper = (StudentWrapper) in.readObject();
            Student.setLastRegNo(studentsWrapper.getLastStudentRegNo());
            students = studentsWrapper.getStudents();
            in.close();
            file.close();

        } catch (IOException | ClassNotFoundException e) {
            LogUtil1.log("File not found");
        }
        return students;

    }

    public static void collegeSerialize(ArrayList<College> colleges) {

        try {
            FileOutputStream file = new FileOutputStream(COLLEGE_FILE_NAME);
            ObjectOutputStream out = new ObjectOutputStream(file);
            CollegeWrapper wrapper = new CollegeWrapper(College.getLastENCollegeID(),
                    College.getLastMDCollegeID(), College.getLastARCollegeID(),
                    College.getLastcollegeNumber(),colleges);

            out.writeObject(wrapper);

            out.close();

        } catch (Exception e) {
            LogUtil1.log(e.getMessage());
            e.printStackTrace();

        }
    }

    public static ArrayList<College> collegeDeserialize() {
        ArrayList<College> colleges = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(COLLEGE_FILE_NAME);
            ObjectInputStream in = new ObjectInputStream(file);

            CollegeWrapper collegesWrapper = (CollegeWrapper) in.readObject();
            College.setLastENCollegeID(collegesWrapper.getLastENGCollegeID());
            College.setLastMDCollegeID(collegesWrapper.getLastMEDCollegeID());
            College.setLastARCollegeID(collegesWrapper.getLastARTCollegeID());
            College.setLastcollegeNumber(collegesWrapper.getLastcollegeNumber());
            colleges = collegesWrapper.getColleges();
            //colleges = (ArrayList<College>)in.readObject();

            in.close();
            file.close();

        } catch (IOException | ClassNotFoundException e) {
            LogUtil1.log("file not found");

        }
        return colleges;

    }
    
   public static void seatSerialize(ArrayList<Seat> seats) {

        try {
              FileOutputStream file = new FileOutputStream(SEAT_FILE_NAME);
            ObjectOutputStream out = new ObjectOutputStream(file);
            
            SeatWrapper wrapper = new SeatWrapper(Seat.getLastseatNumber(),
                  seats);
            
            out.writeObject(wrapper);

            out.close();

        } catch (Exception e) {
            LogUtil1.log(e.getMessage());
            e.printStackTrace();
        }
    }

    public static ArrayList<Seat> seatDeserialize(){
        ArrayList<Seat> seats = new ArrayList<>();

        try {
            FileInputStream file = new FileInputStream(SEAT_FILE_NAME);
            ObjectInputStream in = new ObjectInputStream(file);

             SeatWrapper seatsWrapper = (SeatWrapper) in.readObject();
            Seat.setLastseatNumber(seatsWrapper.getLastseatID());
            seats = seatsWrapper.getSeats();
            
            //seats = (ArrayList<Seat>) in.readObject();
            
            in.close();
            file.close();
        } catch (IOException | ClassNotFoundException e) {
            LogUtil1.log("File not found");
        }
        return seats;

    }

}
