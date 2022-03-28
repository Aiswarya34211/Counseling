package tartlabs.counseling.Model;

import courseAllocation.Course;
import java.io.Serializable;
import java.util.ArrayList;
import util.LogUtil1;

public class College implements Serializable {

    private static int lastENCollegeID = 0;
    private static int lastMDCollegeID = 0;
    private static int lastARCollegeID = 0;

    public static final int ENG = 1;
    public static final int MED = 2;
    public static final int ART = 3;
    private static int lastcollegeNumber;

    public int collegeType;
    public String collegeName;
    public String collegeCode;
    public int course;
    public int collegeID;

    private ArrayList<Course> courses = new ArrayList<>();

    public College(String collegeName, int collegeType) {
        this.collegeType = collegeType;
        this.collegeName = collegeName;
        this.collegeCode = generatecollegeCode(collegeType);
        this.collegeID = generatecollegeID();

    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    private String generatecollegeCode(int collegeType) {

        String collegeID = " ";
        switch (collegeType) {
            case ENG:
                collegeID += "EN";
                break;
            case MED:
                collegeID += "MD";
                break;
            case ART:
                collegeID += "AR";
                break;
            default:
                LogUtil1.log("collegeType invalid");
                break;
        }

        String toReturn = " ";

        if (collegeType == ENG) {

            generatelastENCollegeID();
            toReturn = collegeID += "00" + getLastENCollegeID();
            LogUtil1.log(toReturn);
        } else if (collegeType == MED) {

            generatelastMDCollegeID();

            toReturn = collegeID += "00" + getLastMDCollegeID();
            LogUtil1.log(toReturn);
        } else if (collegeType == ART) {

            generatelastARCollegeID();

            toReturn = collegeID += "00" + getLastARCollegeID();
            LogUtil1.log(toReturn);
        } else {
            LogUtil1.log("not vaild");
        }

        return toReturn;
    }

    private int generatecollegeID() {
        setLastcollegeNumber(getLastcollegeNumber() + 1);
        return getLastcollegeNumber();

    }

    private int generatelastENCollegeID() {
        lastENCollegeID = lastENCollegeID + 1;
        return lastENCollegeID;

    }

    private int generatelastMDCollegeID() {
        lastMDCollegeID = lastMDCollegeID + 1;
        return lastMDCollegeID;

    }

    private int generatelastARCollegeID() {
        lastARCollegeID = lastARCollegeID + 1;
        return lastARCollegeID;

    }

    public static int getLastENCollegeID() {
        return lastENCollegeID;
    }

    public static void setLastENCollegeID(int aLastENCollegeID) {
        lastENCollegeID = aLastENCollegeID;
    }

    public static int getLastMDCollegeID() {
        return lastMDCollegeID;
    }

    public static void setLastMDCollegeID(int aLastMDCollegeID) {
        lastMDCollegeID = aLastMDCollegeID;
    }

    public static int getLastARCollegeID() {
        return lastARCollegeID;
    }

    public static void setLastARCollegeID(int aLastARCollegeID) {
        lastARCollegeID = aLastARCollegeID;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public static int getLastcollegeNumber() {
        return lastcollegeNumber;
    }

    public static void setLastcollegeNumber(int aLastcollegeNumber) {
        lastcollegeNumber = aLastcollegeNumber;
    }

    public int getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(int collegeID) {
        this.collegeID = collegeID;
    }

}
