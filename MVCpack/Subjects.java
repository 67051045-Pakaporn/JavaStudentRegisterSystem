package MVCpack;

public class Subjects {
    private String sjId;
    private String sjName;
    private int sjCrd = 0;
    private String sjLec;
    private String sjPreq = "None";
    private String sjType = "Unknown";

    public Subjects() {}

    public Subjects(String id, String name, int credit, String lecturer, String preq, String type) {
        setSjId(id);
        this.sjName = name;
        setSjCrd(credit);
        this.sjLec = lecturer;
        this.sjPreq = preq;
        this.sjType = type;
    }

    public Subjects(String id, String name, int credit, String lecturer) {
        setSjId(id);
        this.sjName = name;
        setSjCrd(credit);
        this.sjLec = lecturer;
    }

    // additional logic
    private boolean subjectType(String id) {
        if (id.startsWith("0550")) { 
            this.sjType = "Core Subject";
            return true;
        }
        else if (id.startsWith("9069")) { 
            this.sjType = "General Education";
            return true; 
        } else { return false; }
    }

    // getters
    public String getSjId() { return this.sjId; }

    public String getSjName() { return this.sjName; }
    
    public int getSjCrd() { return this.sjCrd; }

    public String getSjLec() { return this.sjLec; }

    public String getSjPreq() { return this.sjPreq; }

    public String getSjType() {return this.sjType; }

    // setters
    public void setSjId(String id) {
        if (id.length() == 8 && subjectType(id) == true) { this.sjId = id; }
        else { System.out.println("Invalid Subject Id");}
    }

    public void setSjName(String name) { this.sjName = name; }
    
    public void setSjCrd(int credit) { if (credit >= 0) { this.sjCrd = credit; } }

    public void setSjLec(String lecturer) { this.sjLec = lecturer; }

    public void setSjPreq(String preq) { this.sjPreq = preq; }
}
