package Member;

public class Student extends Member{
    private String major;
    private int stu_num;

    public Student(String Name, String Id, String Pw, String Email, String Reg_Date, String major, int stu_num, String Gender) {
        super(Name, Id, Pw, Email, Reg_Date, Gender);
        this.major = major;
        this.stu_num = stu_num;
    }

    public String getMajor() {
        return this.major;
    }
    public int getStu_num() {
        return this.stu_num;
    }

    public void setMajor(String major){
        this.major = major;
    }
    public void setStu_num(int stu_num){
        this.stu_num = stu_num;
    }

    @Override
    public String toString() {
        return "[ID: " + Id + ", 이름: " + getName() + ", 비밀번호: " + getPw() + ", 이메일: " + getEmail() + ", 가입일 " + Reg_Date + ", 성별: " + getGender() + "" +
                ", 학과: " + major + ", 학번: " + stu_num+"]";
    }

}
