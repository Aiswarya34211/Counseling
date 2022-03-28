package tartlabs.counseling.DataBase;

import courseAllocation.Course;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import tartlabs.counseling.Model.College;
import util.AppUtil;
import util.FileUtil;
import util.LogUtil1;

public class CollegeDatabase {

    private static ArrayList<College> colleges = FileUtil.collegeDeserialize();

    public static void getCollegeDetails() throws IOException {

        int collegeType = AppUtil.getIntegerformatFromUser(1, 3,
                new String[]{"Enter the college type",
                    "1.Engineering College..",
                    "2.Medical College..", "3.Arts College.."},
                "Invaild type");

        String collegeName = AppUtil.getStringFormatFromUser
        (new String[]{"Enter the CollegeName: "}, "invaild collegename");
        if (AppUtil.isNumeric(collegeName)) {
            LogUtil1.log("invaild!please enter the correct name");
            return;
        }
        College college = new College(collegeName, collegeType);
        colleges.add(college);
        if (collegeType != 1) {
            return;
        }

        int course = AppUtil.getIntegerformatFromUser(
                new String[]{"How many course you want add in " + collegeName},
                "invaild course count");
        for (int i = 0; i < course; i++) {

            int courseID = AppUtil.getIntegerformatFromUser
        (new String[]{"Enter the courseID"}, "invail courseID");

            String courseName = AppUtil.getStringFormatFromUser
        (new String[]{"Enter the Course Name:"}, "invaild coursename");

            int seat = AppUtil.getIntegerformatFromUser
        (new String[]{"Enter the seat count:"}, "invaild seat count");

            college.addCourse(new Course(courseName, seat, courseID));
            Set<Course> courses = new HashSet<>();

        }

        FileUtil.collegeSerialize(colleges);
    }

    public static void printCollegeDetails() {

        for (College c : colleges) {

            LogUtil1.log("====================================");
            LogUtil1.log("collegeID:" + c.getCollegeID());
            LogUtil1.log("collegeName:" + c.collegeName);
            LogUtil1.log("collegeCode:" + c.collegeCode);
            LogUtil1.log("====================================");

        }
    }

    public static void printCourseDetails() {
        for (College c : colleges) {
            if (c.collegeType == College.ENG) {

                LogUtil1.log("===============================================");
                LogUtil1.log("CollegeNO:" + c.collegeID);
                LogUtil1.log("CollegeName:" + c.collegeName);
                LogUtil1.log("CollegeId:" + c.collegeCode);
                for (Course course : c.getCourses()) {
                    if (course.getMaxSeat() != 0) {
                    LogUtil1.log(".......................................");
                    LogUtil1.log("CourseNo:" +course.courseID);
                    LogUtil1.log("CourseName:" + course.courseName);
                    //LogUtil1.log("Number of Seats:" + course.totalSeat);
                    LogUtil1.log("Available Seat count:" + course.getMaxSeat());
                    LogUtil1.log(".......................................");
                    }
                }
                LogUtil1.log("===============================================");
            }
        }
    }

    public static void addCollegeDetails() throws IOException {

        int choice = AppUtil.getIntegerformatFromUser
        (1, 2, new String[]{"What you want to add - Seat count or Course",
            "please Enter the choice", "1.Course", "2.Seat"},
                "Please enter the vaild choice");

        if (choice == 1) {

            CollegeDatabase.printSeatCollegeDetails();

            int collegeID = AppUtil.getCollegeID();

            for (College c : colleges) {

                if (c.collegeID == collegeID) {

                    for (Course course : c.getCourses()) {

                        LogUtil1.log("-------------------------------");
                        LogUtil1.log("courseID:" + course.courseID);
                        LogUtil1.log("courseName:" + course.courseName);
                        LogUtil1.log("Seat count:" + course.getMaxSeat());
                        LogUtil1.log("------------------------------");

                    }

                    int course = AppUtil.getIntegerformatFromUser(new String[]{
                        "How many course you want add:"}, "invaild course count");

                    for (int i = 0; i < course; i++) {

                        int courseID = AppUtil.getIntegerformatFromUser(new String[]{
                            "Enter the courseID"}, "invail courseID");

                        String courseName = AppUtil.getStringFormatFromUser
        (new String[]{"Add the Course Name:"}, "invaild coursename");

                        int seat = AppUtil.getIntegerformatFromUser
        (new String[]{"Add the seat count:"}, "invaild seat count");

                        c.addCourse(new Course(courseName, seat, courseID));
                        LogUtil1.log("successfuly add the course");
                    }
                }

            }
        } else if (choice == 2) {

            CollegeDatabase.printSeatCollegeDetails();

            int collegeID = AppUtil.getCollegeID();

            for (College c : colleges) {

                if (c.collegeID == collegeID) {
                    for (Course course : c.getCourses()) {

                        LogUtil1.log("-------------------------------");
                        LogUtil1.log("courseID:" + course.courseID);
                        LogUtil1.log("courseName:" + course.courseName);
                        LogUtil1.log("Seat count:" + course.getMaxSeat());
                        LogUtil1.log("------------------------------");

                    }
                }
            }

            int courseID = AppUtil.getDBCourseID(collegeID);

            for (College c : colleges) {
                if (c.collegeID == collegeID) {
                    for (Course course : c.getCourses()) {
                        if (courseID == course.courseID) {
                            int addSeat = AppUtil.getIntegerformatFromUser(new String[]{
                                "Add the seat count:"}, "invaild seat count");
                            LogUtil1.log(course.getMaxSeat() + addSeat);

                            int value = course.getMaxSeat() + addSeat;
                            LogUtil1.log("successfuly add the seat count");
                            course.setMaxSeat(value);

                        }
                    }
                }
            }

        }

    }

    public static void printSeatCollegeDetails() {

        for (College c : colleges) {
            if (c.collegeType == College.ENG) {

                LogUtil1.log("====================================");
                LogUtil1.log("collegeID:" + c.getCollegeID());
                LogUtil1.log("collegeName:" + c.collegeName);
                LogUtil1.log("collegeCode:" + c.collegeCode);
                LogUtil1.log("====================================");
            }
        }
    }

    public static void printCourseDetails1() {

        HashSet<String> duplicateCourses = new HashSet<>();

        for (College c : colleges) {

            for (Course course : c.getCourses()) {
                if (duplicateCourses.contains(course.courseName)) {
                    continue;
                }
                if (c.collegeType == College.ENG) {
                    if (course.getMaxSeat() != 0) {
                        LogUtil1.log("--------------------------------------");
                        //LogUtil1.log("courseID:" + course.courseID);
                        LogUtil1.log("courseName:" + course.courseName);

                        LogUtil1.log("---------------------------------------");
                        duplicateCourses.add(course.courseName);
                    }
                }

            }
        }
    }

    public static ArrayList<College> getColleges() {
        return colleges;
    }

    public static void setColleges(ArrayList<College> aColleges) {
        colleges = aColleges;
    }

  

}
