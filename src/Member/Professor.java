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

    @Override
    public String toString() {
        return "[ID: " + Id + ", 이름: " + getName() + ", 비밀번호: " + getPw() + ", 이메일: " + getEmail() + ", 가입일 " + Reg_Date + ", 성별: " + getGender() + "" +
                ", 학과: " + major + ", 연구실: " + office+"]";
    }

}
