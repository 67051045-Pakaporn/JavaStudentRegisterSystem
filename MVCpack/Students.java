package MVCpack;

public class Students {
    private String stdId;
    private String stdPf;
    private String stdFname;
    private String stdLname;
    private String stdBdate; 
    private String stdHsch;
    private String stdEmail;
    private String stdRegId;

    public Students(String id, String prefix, String fname, String lname, String bdate, String school, String email, String regId) {
        this.stdId = id;
        this.stdPf = prefix;
        this.stdFname = fname;
        this.stdLname = lname;
        this.stdBdate = bdate;
        this.stdHsch = school;
        this.stdEmail = email;
        this.stdRegId = regId;
    }

    // getters

    // setters
}
