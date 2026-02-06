package MVCpack;

public class RegisteredSubject {
    private Students student; // get student id;
    private Subjects subject; // get subject id;
    private String stdName;
    private String sjName;
    private String regGrade = "None";
    private int regNum = 0;

    public RegisteredSubject() {}

    public RegisteredSubject(String stdName, String sjName, String grade, int num) {
        this.stdName = stdName;
        this.sjName = sjName;
        this.regGrade = grade;
        this.regNum = num;
    }

    public RegisteredSubject(Students std, Subjects sj) {
        this.student = std;
        this.subject = sj;
        regNum += 1;
    }

    //additional logic

    // getters
    public String getStdId() { return student.getStdId(); }

    public String getSjName() { return subject.getSjId(); }

    public String getRegGrade() { return this.regGrade; }

    public int getRegNum() { return this.regNum; }

    // setters
    public void setRegGrade(String grade) { this.regGrade = grade; }
}
