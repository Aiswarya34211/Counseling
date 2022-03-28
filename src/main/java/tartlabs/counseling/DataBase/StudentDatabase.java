package tartlabs.counseling.DataBase;

import java.io.IOException;
import tartlabs.counseling.Model.Student;
import java.util.ArrayList;
import java.util.Collections;
import tartlabs.counseling.Model.CBSEStudent;
import tartlabs.counseling.Model.DiplomaStudent;
import util.AppUtil;
import util.FileUtil;
import util.LogUtil1;

public abstract class StudentDatabase {

    private static ArrayList<Student> students = FileUtil.studentDeserialize();
    ArrayList<Student> save = new ArrayList<>(students);
 

    public static void getStudentDetails() throws IOException {

        String name = AppUtil.getStringFormatFromUser(
                new String[]{"Enter the student name"},
                "Invalid name*");
        if (AppUtil.isNumeric(name)) {
            LogUtil1.log("invalid!please enter the correct name");
            return;
        }

        int choice = AppUtil.getIntegerformatFromUser(1,2,
                new String[]{"Do you want enter the marks", "1.YES", "2.NO"},
                "Invalid choice");

        Float maths = null, physics = null, chemistry = null;

        if (choice == 1) {

            maths = AppUtil.getFloatFormatFromUser(
                    0f, 200f, new String[]{"Enter the Maths Mark"},
                    "Invalid maths mark");

            physics = AppUtil.getFloatFormatFromUser(
                    0f, 200f, new String[]{"Enter the Physics Mark"},
                    "Invalid physics mark");

            chemistry = AppUtil.getFloatFormatFromUser(
                    0f, 200f, new String[]{"Enter the Chemistry Mark"},
                    "Invalid chemistry mark");

        }

        int studentType = AppUtil.getIntegerformatFromUser(
                new String[]{"Choose the type of student type",
                    "1.CBSE", "2.Diplom", "3.State board"},
                "Invalid choice");

        Student student1;

        if (studentType == 1) {

            student1 = new CBSEStudent(name, maths, physics, chemistry);

        } else if (studentType == 2) {

            student1 = new DiplomaStudent(name, maths, physics, chemistry);

        } else {

            student1 = new Student(name, maths, physics, chemistry);

        }

        student1.calculateCutoff();
        //student1.calculateRank(students);
        students.add(student1);
        FileUtil.studentSerialize(students);

    }

    public static void printStudentDetails() {

        int sortType = AppUtil.getIntegerformatFromUser(1,4,
                new String[]{"Please enter the type to sort!",
                    "1.RegNo", "2.Name", "3.Cutoff", "4.Rank"}, "Invalid Type");

        switch (sortType) {

        case 2:
                getStudents().sort((s1, s2) -> s1.name.compareTo(s2.name));
                break;
            case 4:
                getStudents().sort((s1, s2) -> {
                    if (s1.getRank() == null || s2.getRank() == null) {
                        return 0;
                    }
                    
                    return (int) (s1.getRank() - s2.getRank());
                });
                break;
            case 3:
                getStudents().sort((s1, s2) -> {
                    if (s1.getCutoff() == null || s2.getCutoff() == null) {
                        return 0;
                    }
                    return (int) (s2.getCutoff() - s1.getCutoff());
                });

                int lastCutoff = 200;
                int rank = 0;
                for (Student s1 : students) {

                    rank++;

                    s1.setRank(rank);
                    lastCutoff = s1.getRank();
                }

            case 1:
                
            default:
               Collections.sort(getStudents());
        }
        for (Student s : students) {

            LogUtil1.log("=====================");
            LogUtil1.log("name:" + s.name);
            LogUtil1.log("regNo:" + s.getRegNo());
            if (s.getRank() != null) {
                LogUtil1.log("rank:" + s.getRank());
            }
            if (s.getMaths() != null) {
                LogUtil1.log("maths:" + s.getMaths());
            }
            if (s.getPhysics() != null) {
                LogUtil1.log("physics:" + s.getPhysics());
            }
            if (s.getChemistry() != null) {
                LogUtil1.log("chemistry:" + s.getChemistry());
            }

            if (s.getCutoff() != null) {
                LogUtil1.log("cutoff mark:" + s.getCutoff());

            }
            if (s instanceof CBSEStudent) {
                LogUtil1.log("Student Type: CBSE");
            } else if (s instanceof DiplomaStudent) {
                LogUtil1.log("Student Type: Diploma");
            } else {
                LogUtil1.log("Student Type:StateBoard");
            }
            LogUtil1.log("=====================");
        }

    }

    public static void UpdateStudentDetails() {

        int regNo = AppUtil.getIntegerformatFromUser(
                new String[]{"please enter the student regsiter number:"},
                "Invalid choice");
        boolean found = false;
        for (Student s : students) {
            if (s.getRegNo() == regNo) {

                String name = AppUtil.getStringFormatFromUser(
                        new String[]{"Enter the student name"},
                        "Invalid name*");

                if (!name.isEmpty()) {
                    s.name = name;
                }

                Float maths = AppUtil.getFloatFormatFromUser(
                        0f, 200f, new String[]{"Enter the update maths mark"},
                        "Invalid maths mark");

                Float physics = AppUtil.getFloatFormatFromUser(
                        0f, 200f, new String[]{"Enter the update physics mark"},
                        "Invalid maths mark");

                Float chemistry = AppUtil.getFloatFormatFromUser(
                        0f, 200f, new String[]{"Enter the chemistry Mark"},
                        "Invalid maths mark");

                s.setMaths(maths);
                s.setPhysics(physics);
                s.setChemistry(chemistry);
               // s.calculateRank(students);
                s.calculateCutoff();

                found = true;
                break;
            }

        }
        if (!found) {
            LogUtil1.log("Sorry! User Not Found");

        }

    }
    
    
    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static void setStudents(ArrayList<Student> aStudents) {
        students = aStudents;
    }

}
