package Interface;

import Database.dbConn;
import Member.MemberDAO;
import Member.Professor;
import Member.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable{
    @FXML private Button btn_register; // 회원가입 Stage 이동
    @FXML private Button btn_login; // 로그인 버튼
    @FXML private Button btn_forget; // 아이디/비밀번호 분실 Stage 이동
    @FXML private Button btn_cancel; // 종료
    @FXML private TextField Tf_id; // 아이디 TextField
    @FXML private TextField Tf_name; // 회원가입창 이름 TextField
    @FXML private TextField Pf_pw; // 회원가입창 비밀번호 PasswordField
    @FXML private TextField Pf_confirmpw; // 비밀번호 확인 PasswordField
    @FXML private TextField Tf_email; // Email TextField
    @FXML private CheckBox radio_male; // 남성 RadioButton
    @FXML private CheckBox radio_female; // 여성 RadioButton
    @FXML private RadioButton radio_stu; // 로그인 (학생) RadioButton
    @FXML private RadioButton radio_prof; // 로그인 (교수) RadioButton
    @FXML private Button btn_back; // 뒤로가기 Button
    @FXML private DatePicker dtpicker; // Calendar DatePicker
    @FXML private TextField Tf_stunum; // 학번 TextField
    @FXML private TextField Tf_major; // 전공 TextField
    @FXML private TextField Tf_office; // 연구실 TextField
    @FXML private Button Btn_Register; // 가입 확인 Button
    @FXML private PasswordField pf_pw; // 로그인 화면 pw칸
    @FXML private TextField tf_id; // 로그인 화면 id칸
    @FXML private Button btn_AllProf;
    @FXML private Button btn_AllStu;

    // Initialize
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    // 회원가입 창 이동
    @FXML public void OpenRegister() throws Exception {
        Stage RegisterStage = new Stage();
        if (radio_prof.isSelected()) { // 교수에 체크시
            Parent register = FXMLLoader.load(getClass().getResource("prof_register_foam.fxml"));
            RegisterStage.setScene(new Scene(register));
            RegisterStage.show();
            RegisterStage.setTitle("교수 회원 가입");
            RegisterStage.setResizable(false);
            Stage stage = (Stage)btn_register.getScene().getWindow();
            stage.close();
        }

        else if (radio_stu.isSelected()) { // 학부생에 체크시
            Parent register = FXMLLoader.load(getClass().getResource("stu_register_foam.fxml"));
            RegisterStage.setScene(new Scene(register));
            RegisterStage.show();
            RegisterStage.setTitle("학부생 회원 가입");
            RegisterStage.setResizable(false);
            Stage stage = (Stage)btn_register.getScene().getWindow();
            stage.close();
        }
    }

    // 뒤로 가기
    @FXML private void GoBack() throws Exception{
        Stage PrimaryStage = new Stage();
        Parent parent = FXMLLoader.load(getClass().getResource("login_foam.fxml"));
        PrimaryStage.setScene(new Scene(parent));
        PrimaryStage.show();
        Stage stage = (Stage)btn_back.getScene().getWindow();
        stage.close();
    }

    // 학생 회원가입
    @FXML public void Stu_Register(ActionEvent event) throws Exception {
        if (Tf_id.getText().equals("") || Pf_pw.getText().equals("") || Tf_name.getText().equals("") || Tf_email.getText().equals("")) {
            Alert emptyError = new Alert(Alert.AlertType.ERROR);
            emptyError.setHeaderText("오류");
            emptyError.setContentText("비어있는 칸이 있습니다.");
            emptyError.showAndWait();
        } else if (!Pf_pw.getText().equals(Pf_confirmpw.getText())) {
            Alert pwError = new Alert(Alert.AlertType.ERROR);
            pwError.setHeaderText("비밀번호 오류");
            pwError.setContentText("비밀번호를 확인해주세요.");
            pwError.showAndWait(); // 다이얼로그 Show, Wait
        } else { // DB로 정보 전송
            if (radio_female.isSelected()) {
                MemberDAO memberDAO = new MemberDAO();
                String Gender;
                memberDAO.stu_insert(new Student(Tf_id.getText(), Tf_name.getText(), Pf_pw.getText(),
                        Tf_email.getText(), dtpicker.getValue().toString(), Tf_major.getText(), Integer.parseInt(Tf_stunum.getText().toString()),
                        Gender = "여성"));
            } else if (radio_male.isSelected()) {
                MemberDAO memberDAO = new MemberDAO();
                String Gender;
                memberDAO.stu_insert(new Student(Tf_id.getText(), Tf_name.getText(), Pf_pw.getText(),
                        Tf_email.getText(), dtpicker.getValue().toString(), Tf_major.getText(), Integer.parseInt(Tf_stunum.getText().toString()),
                        Gender = "남성"));

            }
            Alert register_success = new Alert(Alert.AlertType.INFORMATION);
            register_success.setHeaderText("회원 가입이 완료되었습니다.");
            register_success.setContentText("로그인 하세요.");
            register_success.showAndWait(); // 다이얼로그 Show, Wait
            Stage primaryStage = new Stage();
            Stage stage = (Stage) Btn_Register.getScene().getWindow();
            Parent parent = FXMLLoader.load(getClass().getResource("login_foam.fxml"));
            Scene scene = new Scene(parent);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setResizable(false);
            stage.close();
        }
    }

    // 교수 회원가입
    @FXML public void Prof_Register(ActionEvent event) throws Exception {
            if (Tf_id.getText().equals("") || Pf_pw.getText().equals("") || Tf_name.getText().equals("") || Tf_email.getText().equals("")) {
                Alert emptyError = new Alert(Alert.AlertType.ERROR);
                emptyError.setHeaderText("오류");
                emptyError.setContentText("비어있는 칸이 있습니다.");
                emptyError.showAndWait();
            } else if (!Pf_pw.getText().equals(Pf_confirmpw.getText())) {
                Alert pwError = new Alert(Alert.AlertType.ERROR);
                pwError.setHeaderText("비밀번호 오류");
                pwError.setContentText("비밀번호를 확인해주세요.");
                pwError.showAndWait();
            } else { // DB로 정보 전송
                if (radio_female.isSelected()) {
                    MemberDAO memberDAO = new MemberDAO();
                    String Gender;
                    memberDAO.prof_insert(new Professor(Tf_id.getText(), Tf_name.getText(), Pf_pw.getText(),
                            Tf_email.getText(), dtpicker.getValue().toString(), Tf_major.getText(), Tf_office.getText(),
                            Gender = "여성"));
                } else if (radio_male.isSelected()) {
                    MemberDAO memberDAO = new MemberDAO();
                    String Gender;
                    memberDAO.prof_insert(new Professor(Tf_id.getText(), Tf_name.getText(), Pf_pw.getText(),
                            Tf_email.getText(), dtpicker.getValue().toString(), Tf_major.getText(), Tf_office.getText(),
                            Gender = "남성"));
                }
                Alert register_success = new Alert(Alert.AlertType.INFORMATION);
                register_success.setHeaderText("회원 가입이 완료되었습니다.");
                register_success.setContentText("로그인 하세요.");
                register_success.showAndWait(); // 다이얼로그 Show, Wait
                Stage primaryStage = new Stage();
                Stage stage = (Stage) Btn_Register.getScene().getWindow();
                Parent parent = FXMLLoader.load(getClass().getResource("login_foam.fxml"));
                Scene scene = new Scene(parent);
                primaryStage.setScene(scene);
                primaryStage.show();
                primaryStage.setResizable(false);
                stage.close();
            }

    }
    
    // 로그인 메소드
    @FXML public void login(ActionEvent event) throws Exception {

        Connection connection = null; // DB Connection
        PreparedStatement stmt = null; // 동적 SQL 처리
        ResultSet rs = null; // SQL ResultSet 반환

        String id = tf_id.getText(); // Textfield에서 id를 String에 저장
        String pw = pf_pw.getText(); // Passwordfield에서 pw를 String에 저장
        try {
            if (pf_pw.getText().equals("")) { // if Passwordfield가 공백이라면 에러 출력
                Alert noPw = new Alert(Alert.AlertType.ERROR); 
                noPw.setHeaderText("로그인 실패");
                noPw.setContentText("비밀번호를 입력해주세요.!!");
                noPw.showAndWait();
            }
            String sql = String.format("SELECT PW FROM STUDENT WHERE ID = '%s' AND PW = '%s'", id, pw); // 입력한 id와 매핑되는 pw를 db에서 불러온다
            connection = dbConn.getConnection();
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            rs.next(); // ResultSet 결과가 존재한다면 True(1) 반환

            if (pw.equals(rs.getString(1))) { // Password가 일치한다면
                System.out.println("로그인 성공");
                Stage primaryStage = new Stage();
                Stage stage = (Stage)btn_login.getScene().getWindow();
                Parent MainMenu = FXMLLoader.load(getClass().getResource("Stu_Menu.fxml")); // 메인메뉴 Stage 로드
                Scene scene = new Scene(MainMenu);
                primaryStage.setScene(scene);
                primaryStage.setTitle("메인 메뉴");
                primaryStage.show();
                primaryStage.setResizable(false);
                stage.close();
            }
            else {
                Alert loginFail = new Alert(Alert.AlertType.ERROR);
                loginFail.setHeaderText("로그인 실패!");
                loginFail.setContentText("비밀번호를 확인해주세요.");
                loginFail.showAndWait();
            }

        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("로그인 실패");
        }
    }
    // 캘린더 DatePicker
    @FXML void selectDatePicker(ActionEvent event){ // 문자열에 달력 날짜 저장
        String strDate = dtpicker.getValue().toString();
    }

    // 종료 메소드
    @FXML boolean cancel(ActionEvent event) {
        return false;
    }

    // 전체 학생 출력
    @FXML public void SelectAllStu() throws IOException {
        MemberDAO memberDAO = new MemberDAO();
        List<Student> StuList = memberDAO.selectAllStu();
        System.out.println("---[전체 학생 목록]---");
        if (StuList.size() == 0) {
            System.out.println("등록된 학생이 없습니다.");
        } else {
            for (Student student : StuList) {
                System.out.println("---" + student.toString());
            }
        }
    }

    // 전체 교수 출력
    @FXML public void SelectAllProf() {
        MemberDAO memberDAO = new MemberDAO();
        List<Professor> ProfList = memberDAO.selectAllProf();
        System.out.println("---[전체 교수 목록]---");
        if (ProfList.size() == 0) {
            System.out.println("등록된 학생이 없습니다.");
        } else {
            for (Professor prof : ProfList) {
                System.out.println("---" + prof.toString());
            }
        }
    }

}



