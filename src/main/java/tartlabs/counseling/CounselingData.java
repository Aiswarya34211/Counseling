package tartlabs.counseling;

import exception.InvalidInputException;
import tartlabs.counseling.DataBase.CollegeDatabase;
import tartlabs.counseling.DataBase.SeatDatabase;
import tartlabs.counseling.DataBase.StudentDatabase;
import util.AppUtil;
import util.LogUtil1;

public class CounselingData {

    public static void main(String args[]) throws Exception {
        
         
        LogUtil1.log("~~~~~~~~~Welcome~~~~~~~~~");
         while (true) {
        LogUtil1.log("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        LogUtil1.log("1.Student Details");
        LogUtil1.log("2.Print Student Details");
        LogUtil1.log("3.Update Student details");
        LogUtil1.log("4.College Details");
        LogUtil1.log("5.View All College Details");
        LogUtil1.log("6.View Course Details");
        LogUtil1.log("7.Add College Details");
        LogUtil1.log("8.View Counseling college list");
        LogUtil1.log("9.Seat Allocation Details");
        LogUtil1.log("10.View Seat Allocation Details");
        LogUtil1.log("11.View College BookedSeats Details");
       // LogUtil1.log("12. Previous Menu");
        LogUtil1.log("12.Exit!");
        LogUtil1.log("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

   

            try {
                int menuChoice = AppUtil.getIntegerformatFromUser(new String[]
                {"Enter any choice:"},
                        "Invalid choice*");

                switch (menuChoice) {
                    case 1:
                        StudentDatabase.getStudentDetails();
                        break;
                    case 2:
                        StudentDatabase.printStudentDetails();
                        break;
                    case 3:
                        StudentDatabase.UpdateStudentDetails();
                        break;
                    case 4:
                        CollegeDatabase.getCollegeDetails();
                        break;
                    case 5:
                        CollegeDatabase.printCollegeDetails();
                        break;
                    case 6:
                        CollegeDatabase.printCourseDetails();
                        break;
                    case 7:
                        CollegeDatabase.addCollegeDetails();
                        break;
                   case 8: 
                        CollegeDatabase.printSeatCollegeDetails();
                        break;
                    case 9:
                        SeatDatabase.seatAllocation();
                        break;
                    case 10:
                        SeatDatabase.printSeatDetails();
                        break;
                    case 11:
                        SeatDatabase.bookedCollegeDetails();
                        break;
                    /*case 12:
                       // CounsellingData
                        break;*/
                    case 12:
                        LogUtil1.log("Thank You!");
                        return;
                    default:
                        LogUtil1.log("invalid enter*");
                        break;

                }

            } catch (InvalidInputException e) {
                LogUtil1.log("Invalid*");
                continue;
            }
        }
      
    }
}
