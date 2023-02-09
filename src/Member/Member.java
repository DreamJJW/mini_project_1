package Member;

public class Member {
    private String Name, Id, Pw, Email, Reg_Date, Gender;
    private int Age;
    public Member(String Name, String Id, String Pw, String Email, String Reg_Date, String Gender) {
        this.Name = Name;
        this.Id = Id;
        this.Pw = Pw;
        this.Email = Email;
        this.Reg_Date = Reg_Date;
        this.Gender = Gender;
    }

    public String getID() {
        return this.Id;
    }
    public String getName() {
        return this.Name;
    }
    public String getPw() {
        return this.Pw;
    }
    public String getEmail() {
        return this.Email;
    }
    public String Reg_Date() {
        return this.Reg_Date;
    }
    public void setName(String name){
        this.Name = Name;
    }
    public void setId(String Id){
        this.Id = Id;
    }
    public void setPw(String Pw){
        this.Pw = Pw;
    }
    public void setEmail(String Email){
        this.Email = Email;
    }
    public void setReg_Date(String Reg_Date){
        this.Reg_Date = Reg_Date;
    }
    public void setGender(String Gender) {this.Gender = Gender;}
    public String getGender() {return this.Gender;}



}
