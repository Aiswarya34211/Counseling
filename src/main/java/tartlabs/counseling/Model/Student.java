package tartlabs.counseling.Model;

import interfaces.StudentActions;
import java.io.Serializable;
import java.util.ArrayList;
import util.LogUtil1;

public class Student extends Person implements StudentActions, Serializable,
       Comparable<Student>{

    private static int lastRegNo = 100;
    private static int lastRank = 0;

    private int regNo;

    protected Float maths;
    protected Float physics;
    protected Float chemistry;
    protected Float cutoff;
    protected Integer rank;


    public Student(String name) {

        super(name);
        this.regNo = generatelastregNO();
        this.rank = generatelastrank();

    }

    public Student(String name, Float maths, Float physics, Float chemistry) {

        super(name);
        this.regNo = generatelastregNO();
        this.rank = generatelastrank();
        this.maths = maths;
        this.physics = physics;
        this.chemistry = chemistry;

    }

    private int generatelastregNO() {
        lastRegNo = lastRegNo + 1;
        return lastRegNo;

    }

    private int generatelastrank() {
        lastRank = lastRank +1;

        return lastRank;

    }

    @Override
    public void calculateCutoff() {

        if (maths == null || physics == null || chemistry == null) {
            return;
        }

        this.cutoff = (maths + (physics / 2) + (chemistry / 2));
        this.cutoff = this.cutoff % 200;

    }

   public void calculateRank(ArrayList<Student> students) {

        int lastCutoff = 200;
        //int rank = students.size() +1;
        for (Student s : students) {
           
            if (s.getRank() >= lastCutoff) {
                rank++;
            }
            s.setRank(rank);
            lastCutoff = s.getRank();

        }
    }
    @Override
    public int compareTo(Student s) {
        return this.regNo - s.regNo;

    }
    

     //@Override
    /*public int compareTo(Student s1, Student s2) {
        return (int) (s1.getRank() - s2.getRank());
    }*/
    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public Float getMaths() {
        return maths;
    }

    public void setMaths(Float maths) {
        this.maths = maths;
    }

    public Float getPhysics() {
        return physics;
    }

    public void setPhysics(Float physics) {
        this.physics = physics;
    }

    public Float getChemistry() {
        return chemistry;
    }

    public void setChemistry(Float chemistry) {
        this.chemistry = chemistry;
    }

    public Float getCutoff() {
        return cutoff;
    }

    public void setCutoff(Float cutoff) {
        this.cutoff = cutoff;
    }

    @Override
    public void study() {

        LogUtil1.log("Inside override");

    }

    @Override
    public Float printMarks() {

        LogUtil1.log("Inside override");
        return null;
    }

    public static int getLastRegNo() {
        return lastRegNo;
    }

    public static void setLastRegNo(int aLastRegNo) {
        lastRegNo = aLastRegNo;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public static int getLastRank() {
        return lastRank;
    }

    public static void setLastRank(int aLastRank) {
        lastRank = aLastRank;
    }
}
