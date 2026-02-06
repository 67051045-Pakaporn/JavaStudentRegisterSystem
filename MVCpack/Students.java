package MVCpack;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Students {
    private String stdId;
    private String stdPf;
    private String stdFname;
    private String stdLname;
    private String stdBdate; 
    private String stdHsch;
    private String stdEmail;
    private String stdRegId;

    public Students() {}

    public Students(String id, String prefix, String fname, String lname, String bdate, String school, String email, String regId) {
        if (validAge(bdate) == true) {
            setStdId(id);
            this.stdPf = prefix;
            this.stdFname = fname;
            this.stdLname = lname;
            this.stdBdate = bdate;
            this.stdHsch = school;
            this.stdEmail = email;
            this.stdRegId = regId;
        }
        else { System.out.println("Your age is invalid for registering to this programme.");}
    }

    // additional logics
    private boolean validAge(String bdate) {
        if (calStdAge(bdate) >= 15) { return true; }
        else { return false; }
    }

    private long calStdAge(String bdate) {
        LocalDate bd = LocalDate.parse(bdate);
        long age = ChronoUnit.YEARS.between(bd, LocalDate.now());

        return age;
    }

    // getters
    public String getStdId() { return this.stdId; }

    public String getStdPf() { return this.stdPf; }

    public String getStdFname() { return this.stdFname; }

    public String getStdLname() { return this.stdLname; }

    public String getStdBdate() { return this.stdBdate; }

    public String getStdHschool() { return this.stdHsch; }

    public String getStdEmail() { return this.stdEmail; }

    public String getStdRegId() { return this.stdRegId; }

    public String getStdName() { return this.stdPf + this.stdFname + " " + this.stdLname; }

    public int getStdAge() { return (int)calStdAge(this.stdBdate); }

    // setters
    public void setStdId(String id) { if (id.length() == 8 && id.startsWith("69")) { this.stdId = id; } }

    public void setStdPf(String prefix) { this.stdPf = prefix; }

    public void setStdFname(String fname) {this.stdFname = fname; }

    public void setStdLname(String lname) { this.stdLname = lname; }

    public void setStdBdate(String bdate) { this.stdBdate = bdate; }

    public void setStdHschool(String school) { this.stdHsch = school; }

    public void setStdEmail(String email) { this.stdEmail = email; }

    public void setStdRegId(String regId) { this.stdRegId = regId; }
}
