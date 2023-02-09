package Member;

public class Student extends Member{
    private String major;
    private int stu_num;

    public Student(String Name, String Id, String Pw, String Email, int Age, String Reg_Date) {
        super(Name, Id, Pw, Email, Age, Reg_Date);
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

}
