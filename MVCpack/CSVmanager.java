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

    public void saveStd(Students std) {
        ArrayList<Students> db = stdLoad();

        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getStdId().equals(std.getStdId())) { return;}
        }

        db.add(std);
        stdSaveAll(db);
    }

    public void updateStd(Students std) {
        ArrayList<Students> db = stdLoad();
        boolean flag = false;

        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getStdId().equals(std.getStdId())) {
                db.set(i, std);
                flag = true;
                break;
            }
        }

        if (flag == true) { stdSaveAll(db); }
    }

    public void deleteStd(Students std) {
        ArrayList<Students> db = stdLoad();
        boolean flag = false;

        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getStdId().equals(std.getStdId())) {
                db.remove(i);
                flag = true;
                break;
            }
        }

        if (flag == true) { stdSaveAll(db); }
    }

    public void dropStd(Students std) {
        try (PrintWriter prw = new PrintWriter(new FileWriter(FStudents, false))) {} 
        catch (IOException e) { e.printStackTrace(); }
    }

    private void stdSaveAll(ArrayList<Students> lst) {
        try (PrintWriter prw = new PrintWriter(new FileWriter(FStudents, false))) {
            for (Students std : lst) {
                prw.println(std.getStdRegId() + "," + std.getStdPf() + "," + std.getStdFname() + "," + std.getStdLname() + "," + std.getStdBdate() + "," + std.getStdHschool() + "," + std.getStdEmail() + "," + std.getStdRegId());
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    /* ==== Student CSV manager section ends here ==== */

    /* ==== Subject CSV manager section starts here ==== */
    public ArrayList<Subjects> sjLoad() {
        ArrayList<Subjects> lst = new ArrayList<>();
        File f = new File(FSubjects);
        if (!f.exists()) { return lst; }

        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");

                String id = data[0];
                String name = data[1];
                int credit = Integer.parseInt(data[2]);
                String lecturer = data[3];
                String preq = data[4];
                String type = data[5];
                
                lst.add(new Subjects(id, name, credit, lecturer, preq, type));
            }
        } catch(Exception e) { e.printStackTrace(); }

        return lst;
    }

    public void saveSj(Subjects sj) {
        ArrayList<Subjects> db = sjLoad();

        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getSjId().equals(sj.getSjId())) { return;}
        }

        db.add(sj);
        sjSaveAll(db);
    }

    public void updateSj(Subjects sj) {
        ArrayList<Subjects> db = sjLoad();
        boolean flag = false;

        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getSjId().equals(sj.getSjId())) {
                db.set(i, sj);
                flag = true;
                break;
            }
        }

        if (flag == true) { sjSaveAll(db); }
    }

    public void deleteSj(Subjects sj) {
        ArrayList<Subjects> db = sjLoad();
        boolean flag = false;

        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getSjId().equals(sj.getSjId())) {
                db.remove(i);
                flag = true;
                break;
            }
        }

        if (flag == true) { sjSaveAll(db); }
    }

    public void dropSj(Subjects sj) {
        try (PrintWriter prw = new PrintWriter(new FileWriter(FSubjects, false))) {} 
        catch (IOException e) { e.printStackTrace(); }
    }

    private void sjSaveAll(ArrayList<Subjects> lst) {
        try (PrintWriter prw = new PrintWriter(new FileWriter(FStudents, false))) {
            for (Subjects sj : lst) {
                prw.println(sj.getSjId() +"," + sj.getSjName() + "," + sj.getSjCrd() + "," + sj.getSjLec() + "," + sj.getSjPreq() + "," + sj.getSjType());
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    /* ==== Subject CSV manager section ends here ==== */

    /* ==== Registered Subject CSV manager section starts here ==== */
    public ArrayList<RegisteredSubject> regLoad() {
        ArrayList<RegisteredSubject> lst = new ArrayList<>();
        File f = new File(FRegSubject);
        if (!f.exists()) { return lst; }

        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");

                String stdName = data[0];
                String sjName = data[1];
                String grade = data[2];
                int num = Integer.parseInt(data[3]);
                
                lst.add(new RegisteredSubject(stdName, sjName, grade, num));
            }
        } catch(Exception e) { e.printStackTrace(); }

        return lst;
    }

    public void saveReg(RegisteredSubject r) {
        ArrayList<RegisteredSubject> db = regLoad();

        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getStdId().equals(r.getStdId())) { return;}
        }

        db.add(r);
        regSaveAll(db);
    }

    public void updateReg(RegisteredSubject r) {
        ArrayList<RegisteredSubject> db = regLoad();
        boolean flag = false;

        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getStdId().equals(r.getStdId())) {
                db.set(i, r);
                flag = true;
                break;
            }
        }

        if (flag == true) { regSaveAll(db); }
    }

    public void deleteReg(RegisteredSubject r) {
        ArrayList<RegisteredSubject> db = regLoad();
        boolean flag = false;

        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getStdId().equals(r.getStdId())) {
                db.remove(i);
                flag = true;
                break;
            }
        }

        if (flag == true) { regSaveAll(db); }
    }

    public void dropReg(RegisteredSubject r) {
        try (PrintWriter prw = new PrintWriter(new FileWriter(FSubjects, false))) {} 
        catch (IOException e) { e.printStackTrace(); }
    }

    private void regSaveAll(ArrayList<RegisteredSubject> lst) {
        try (PrintWriter prw = new PrintWriter(new FileWriter(FStudents, false))) {
            for (RegisteredSubject r : lst) {
                prw.println(r.getStdId() + "," + r.getSjName() + "," + r.getRegGrade() + "," + r.getRegNum());
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    /* ==== Registered Subject CSV manager section ends here ==== */

    /* ==== Subject Structure CSV manager section starts here ==== */
    public ArrayList<SubjectStructure> ssLoad() {
        ArrayList<SubjectStructure> lst = new ArrayList<>();
        File f = new File(FSubjectStruc);
        if (!f.exists()) { return lst; }

        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");

                String id = data[0];
                String name = data[1];
                String dept = data[2];
                String preq = data[3];
                String open = data[4];
                
                lst.add(new SubjectStructure(line, name, dept, preq, open));
            }
        } catch(Exception e) { e.printStackTrace(); }

        return lst;
    }

    public void saveSS(RegisteredSubject r) {
        ArrayList<RegisteredSubject> db = regLoad();

        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getStdId().equals(r.getStdId())) { return;}
        }

        db.add(r);
        regSaveAll(db);
    }

    public void updateSS(RegisteredSubject r) {
        ArrayList<RegisteredSubject> db = regLoad();
        boolean flag = false;

        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getStdId().equals(r.getStdId())) {
                db.set(i, r);
                flag = true;
                break;
            }
        }

        if (flag == true) { regSaveAll(db); }
    }

    public void deleteSS(RegisteredSubject r) {
        ArrayList<RegisteredSubject> db = regLoad();
        boolean flag = false;

        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getStdId().equals(r.getStdId())) {
                db.remove(i);
                flag = true;
                break;
            }
        }

        if (flag == true) { regSaveAll(db); }
    }

    public void dropSS(RegisteredSubject r) {
        try (PrintWriter prw = new PrintWriter(new FileWriter(FSubjects, false))) {} 
        catch (IOException e) { e.printStackTrace(); }
    }

    private void ssSaveAll(ArrayList<SubjectStructure> lst) {
        try (PrintWriter prw = new PrintWriter(new FileWriter(FStudents, false))) {
            for (SubjectStructure ss : lst) {
                prw.println(ss.getSsId() + "," + ss.getSsName() + "," + ss.getSsDept() + "," + ss.getSsPreq() + "," + ss.getSsOpen());
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
}
