package Member;

public class Professor extends Member{

    private String office;
    private String major;
    public Professor(String Name, String Id, String Pw, String Email, String Reg_Date, String major, String office, String Gender) {
        super(Name, Id, Pw, Email, Reg_Date, Gender);
        this.major = major;
        this.office = office;
    }
    public String getMajor() {
        return this.major;
    }
    public String getOffice() {
        return this.office;
    }

    public void setMajor(String major){
        this.major = major;
    }
    public void setOffice(String office){
        this.office = office;
    }

}
