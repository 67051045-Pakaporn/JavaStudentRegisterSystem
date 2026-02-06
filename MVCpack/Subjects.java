package MVCpack;

public class Subjects {
    private String sjId;
    private String sjName;
    private String sjCrd;
    private String sjLec;
    private String sjPreq;


    public Subjects(String id, String name, String credit, String lecturer, String preq) {
        this.sjId = id;
        this.sjName = name;
        this.sjCrd = credit;
        this.sjLec = lecturer;
        this.sjPreq = preq; // prerequisite
    }

    // getters

    // setters
}
