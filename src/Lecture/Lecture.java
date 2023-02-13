package Lecture;

public class Lecture {
    private String LectName, LectProf;
    private int LectNum;

    public Lecture(String LectName, String LectProf, int LectNum){
        this.LectNum = LectNum;
        this.LectProf = LectProf;
        this.LectNum = LectNum;
    }

    public String getLectName() {
        return this.LectName;
    }
    public String getLectProf() {
        return this.LectProf;
    }
    public int getLectNum() { return this.LectNum;}
    public void setLectName(String LectName){
        this.LectName = LectName;
    }
    public void setLectProf(String LectProf){
        this.LectProf = LectProf;
    }
    public void setLectNum(int LectNum) {this.LectNum = LectNum;}



}
