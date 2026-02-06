package MVCpack;

public class RegisteredSubject {
    private Students student; // get student id;
    private Subjects subjects; // get subject id;
    private String regSubGrade;

    public RegisteredSubject(Students std, Subjects sj, String grade) {
        this.student = std;
        this.subjects = sj;
        this.regSubGrade = grade;
    }

    // getters

    // setters
}
