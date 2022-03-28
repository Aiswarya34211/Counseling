package util;

import courseAllocation.Course;
import exception.InvalidInputException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static tartlabs.counseling.DataBase.CollegeDatabase.getColleges;
import tartlabs.counseling.DataBase.SeatDatabase;
import static tartlabs.counseling.DataBase.StudentDatabase.getStudents;
import tartlabs.counseling.Model.College;
import tartlabs.counseling.Model.Student;

public class AppUtil {

    private static final int MAX_TRIES = 5;

    public static boolean isNumeric(String name) {

        try {
            double e = Double.parseDouble(name);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;

    }

    public static int getIntegerformatFromUser(String inputHint, String errorMessage) {

        return getIntegerformatFromUser(Integer.MAX_VALUE, Integer.MIN_VALUE,
                new String[]{inputHint}, errorMessage);
    }

    public static int getIntegerformatFromUser(int min, int max, String[] inputHints, String errorMessage) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            for (String hint : inputHints) {
                LogUtil1.log(hint);
            }

            try {

                int datas = Integer.parseInt(reader.readLine());
                if (datas >= min && datas <= max) {
                    return datas;
                } else {
                    LogUtil1.log(errorMessage);

                }
            } catch (NumberFormatException | IOException e) {
                LogUtil1.log(errorMessage);
            }

        }
    }

    public static Float getFloatFormatFromUser(String inputHint, String errorMessage) {

        return getFloatFormatFromUser(Float.MAX_VALUE, Float.MIN_VALUE,
                new String[]{inputHint}, errorMessage);
    }

    public static Float getFloatFormatFromUser(Float min, Float max,
            String[] inputHints, String errorMessage) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int inputCounter = 1;
        while (true) {
            for (String hint : inputHints) {
                LogUtil1.log(hint);
            }

            try {

                Float datas = Float.parseFloat(reader.readLine());
                if (datas >= min && datas <= max) {
                    LogUtil1.log(errorMessage);
                    inputCounter++;

                } else {
                    return datas;
                }
            } catch (NumberFormatException | IOException e) {
                LogUtil1.log(errorMessage);
            }
            if (inputCounter > MAX_TRIES) {
                LogUtil1.log("You Entered Maximum Tries!!");
                throw new InvalidInputException();
            }

        }
    }

    public static int getIntegerformatFromUser(String[] inputHints, String errorMessage) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int inputCounter = 1;
        while (true) {
            for (String hint : inputHints) {
                LogUtil1.log(hint);
            }
            try {
                int data = Integer.parseInt(reader.readLine());

                inputCounter++;
                return data;

            } catch (NumberFormatException | IOException e) {
                LogUtil1.log(errorMessage);

            }
            if (inputCounter > MAX_TRIES) {
                LogUtil1.log("You Entered Maximum Tries!!");
                throw new InvalidInputException();
            }
        }

    }

    public static String getStringFormatFromUser(String[] inputHints,
            String errorMessage) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int inputCounter = 1;

        while (true) {
            for (String hint : inputHints) {
                LogUtil1.log(hint);
            }
            try {
                String s = reader.readLine();
                if (isNumeric(s)) {
                    LogUtil1.log(errorMessage);
                    inputCounter++;
                } else {
                    return s;
                }
            } catch (IOException e) {
                LogUtil1.log(errorMessage);
            }
            if (inputCounter > MAX_TRIES) {
                LogUtil1.log("You Entered Maximum Tries!!");

                throw new InvalidInputException();
            }

        }

    }

    public static int getCollegeID() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        int inputCounter = 0;
        while (true) {
            int collegeID = getIntegerformatFromUser
        (new String[]{"Which college you want to choose",
                "Please Enter the College ID:"},
                    "Please enter correct college ID*");

            for (College c : getColleges()) {
                if (collegeID == c.collegeID) {
                    return collegeID;
                }
            }

            inputCounter++;
            LogUtil1.log("Enter valid college ID*");
            if (inputCounter >= MAX_TRIES) {
                LogUtil1.log("You Entered Maximum Tries!!");
                throw new InvalidInputException();
            }
        }
    }

    public static int getCouresID() {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        int inputCounter = 0;
        while (true) {

            int courseID = getIntegerformatFromUser
        (new String[]{"Which course you want to choose",
                "Please Enter the Course ID:"},
                    "Please enter correct course ID*");

            for (College c : getColleges()) {
                for (Course course : c.getCourses()) {
                    if (courseID == course.courseID) {
                        return courseID;
                    }
                }
            }
            inputCounter++;
            LogUtil1.log("Enter valid course ID*");
            if (inputCounter >= MAX_TRIES) {
                LogUtil1.log("You Entered Maximum Tries!!");
                throw new InvalidInputException();
            }
        }

    }

    public static String getCouresName() {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        int inputCounter = 0;
        while (true) {
            String courseName = getStringFormatFromUser
        (new String[]{"Which course you want to choose",
                "Please Enter the Course Name:"},
                    "Please enter correct course Name*");

            for (College c : getColleges()) {
                for (Course course : c.getCourses()) {
                    if (courseName.equals(course.courseName)) {
                        return courseName;
                    }
                }
            }
            inputCounter++;
            LogUtil1.log("Enter valid course Name*");
            if (inputCounter >= MAX_TRIES) {
                LogUtil1.log("You Entered Maximum Tries!!");
                throw new InvalidInputException();
            }
        }

    }

    public static int getRegNo() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        int inputCounter = 0;
        while (true) {
            int regNo = getIntegerformatFromUser
        (new String[]{"Enter Student ID:"},
                    "please enter vaild student id*");

            for (Student s : getStudents()) {
                if (regNo == s.getRegNo()) {
                    return regNo;
                }
            }
            inputCounter++;
            LogUtil1.log("Enter valid studenr ID*");
            if (inputCounter >= MAX_TRIES) {
                LogUtil1.log("You Entered Maximum Tries!!");
                throw new InvalidInputException();
            }
        }
    }

    public static int getDBCourseID(int collegeID) {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        int inputCounter = 0;
        while (true) {

            int courseID = getIntegerformatFromUser
        (new String[]{"Which course you want to choose",
                "Please Enter the Course ID:"},
                    "Please enter correct course ID*");

            for (College c : getColleges()) {
                for (Course course : c.getCourses()) {
                    if (collegeID == c.collegeID) {
                        if (courseID == course.courseID) {
                            return courseID;
                        }
                    }
                }
            }
            AppUtil.previousMenuCollegeWise(courseID);

            inputCounter++;
            LogUtil1.log("enter valid courseID*");
            if (inputCounter >= MAX_TRIES) {
                LogUtil1.log("you entered maximum tries!!");
                throw new InvalidInputException();
            }
        }

    }

    public static int printDBCollegeID(String courseName) {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        int inputCounter = 0;
        while (true) {

            int collegeID = getIntegerformatFromUser
        (new String[]{"Which college you want to choose",
                "Please Enter the College ID:"},
                    "Please enter correct college ID*");

            for (College c : getColleges()) {
                for (Course course : c.getCourses()) {
                    if (courseName.equals(course.courseName)) {
                        if (collegeID == c.collegeID) {
                            return collegeID;
                        }
                    }

                }
            }
            
               AppUtil.previousMenuCourseWise(collegeID);
            inputCounter++;
            LogUtil1.log("enter valid choice");
            if (inputCounter >= MAX_TRIES) {
                LogUtil1.log("you entered maximum tries!!");
                throw new InvalidInputException();
            }
        }
    }

    public static void previousMenuCollegeWise(int courseID) {

        if (courseID == 0) {
            SeatDatabase.collegeWise(courseID);
        }
    }

    public static void previousMenuCourseWise(int collegeID) {

        if (collegeID == 0) {
            SeatDatabase.courseWise(collegeID);

        }
    }

}
