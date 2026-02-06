package MVCpack;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVmanager {
    private String FSubjects = "Subjects.csv";
    private String FStudents = "Students.csv";
    private String FRegSubject = "RegisteredSubject.csv";
    private String FSubjectStruc = "SubjectStructure.csv";

    /* ==== Student CSV manager section starts here ==== */
    public ArrayList<Students> stdLoad() {
        ArrayList<Students> lst = new ArrayList<>();
        File f = new File(FStudents);
        if (!f.exists()) { return lst; }

        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");

                String id = data[0];
                String prefix = data[1];
                String fname = data[2];
                String lname = data[3];
                String bd = data[4];
                String school = data[5];
                String email = data[6];
                String regId = data[7];

                lst.add(new Students(id, prefix, fname, lname, bd, school, email, regId));
            }
        } catch(Exception e) { e.printStackTrace(); }

        return lst;
    }

    private void stdSaveAll(ArrayList<Students> lst) {
        try (PrintWriter prw = new PrintWriter(new FileWriter(FStudents, false))) {
            for (Students std : lst) {
                //prw.println(g.getId() + "," + g.getFname() + "," + g.getLname() + "," + g.getScore());
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    /* ==== Student CSV manager section ends here ==== */
}
