package Interface;

import Member.MemberDAO;
import Member.Professor;
import Member.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{
    @FXML private Button btn_register; // 회원가입 Stage 이동
    @FXML private Button btn_login; // 로그인 버튼
    @FXML private Button btn_forget; // 아이디/비밀번호 분실 Stage 이동
    @FXML private Button btn_cancel; // 종료
    @FXML private TextField Tf_id; // 아이디 TextField
    @FXML private TextField Tf_name; // 이름 TextField
    @FXML private TextField Pf_pw; // 비밀번호 PasswordField
    @FXML private TextField Pf_confirmpw; // 비밀번호 확인 PasswordField
    @FXML private TextField Tf_email; // Email TextField
    @FXML private CheckBox radio_male; // 남성 RadioButton
    @FXML private CheckBox radio_female; // 여성 RadioButton
    @FXML private RadioButton radio_stu;
    @FXML private RadioButton radio_prof;
    @FXML private Button btn_back;
    @FXML private DatePicker dtpicker;
    @FXML private TextField Tf_stunum;
    @FXML private TextField Tf_major;
    @FXML private TextField Tf_office;
    @FXML private Button Btn_Register;


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
            pwError.showAndWait();
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
            register_success.showAndWait();
            Stage primaryStage = new Stage();
            Stage stage = (Stage)Btn_Register.getScene().getWindow();
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
            register_success.showAndWait();
            Stage primaryStage = new Stage();
            Stage stage = (Stage)Btn_Register.getScene().getWindow();
            Parent parent = FXMLLoader.load(getClass().getResource("login_foam.fxml"));
            Scene scene = new Scene(parent);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setResizable(false);
            stage.close();
        }

    }
    @FXML void selectDatePicker(ActionEvent event){ // 문자열에 달력 날짜 저장
        String strDate = dtpicker.getValue().toString();
    }
}



