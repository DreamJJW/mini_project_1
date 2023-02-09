package Member;

public class Professor extends Member{

    private String office;
    private String major;
    public Professor(String Name, String Id, String Pw, String Email, int Age, String Reg_Date) {
        super(Name, Id, Pw, Email, Age, Reg_Date);
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
