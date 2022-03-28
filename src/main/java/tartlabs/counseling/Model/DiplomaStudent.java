package tartlabs.counseling.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class DiplomaStudent extends Student implements Serializable {

    public DiplomaStudent(String name) {
        super(name);

    }

    public DiplomaStudent(String name, Float maths, Float physics, Float chemistry) {

        super(name, maths, physics, chemistry);
    }

    @Override
    public void calculateCutoff() {
        if (maths == null || physics == null || chemistry == null) {
            return;
        }
        this.cutoff = (maths + (physics / 2) + (chemistry / 2));
        this.cutoff = cutoff % 200;
    }

   /* @Override
    public void calculateRank(ArrayList<Student> students) {
        int lastCutoff = 0;
        int rank = students.size() + 1;
        for(Student s: students){

        if (s.getCutoff() > lastCutoff) {
            rank--;
        }
        s.setRank(rank);
        lastCutoff = s.getRank();
    }
    }*/

}
