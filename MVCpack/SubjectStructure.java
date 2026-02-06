package MVCpack;

public class SubjectStructure {
    private String ssId;
    private String ssName;
    private String ssDept;
    private String ssPreq;
    private String ssOpen;

    public SubjectStructure(String id, String name, String dept, String preq, String open) {
        setSsId(id);
        this.ssName = name;
        this.ssDept = dept;
        this.ssPreq = preq;
        this.ssOpen = open;
    }

    // getters
    public String getSsId() { return ssId; }

    public String getSsName() { return ssName; }

    public String getSsDept() { return ssDept; }

    public void setSsDept(String ssDept) { this.ssDept = ssDept; }

    public String getSsPreq() { return ssPreq; }

    public String getSsOpen() { return ssOpen; }

    // setters
    public void setSsId(String ssId) { if (ssId.length() == 8 && ssId.startsWith("0") == false) { this.ssId = ssId; } }

    public void setSsName(String ssName) { this.ssName = ssName; }

    public void setSsPreq(String ssPreq) { this.ssPreq = ssPreq; }

    public void setSsOpen(String ssOpen) { this.ssOpen = ssOpen; }
}
