package Interface;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable{
    @FXML private Button btn_register; // 회원가입 Stage 이동
    @FXML private Button btn_login; // 로그인 버튼
    @FXML private Button btn_forget; // 아이디/비밀번호 분실 Stage 이동
    @FXML private Button btn_cancel; // 종료
    @FXML private TextField Tf_id; // 아이디 TextField
    @FXML private TextField Tf_name; // 이름 TextField
    @FXML private TextField Pf_pw; // 비밀번호 PasswordField
    @FXML private TextField Pf_confirm; // 비밀번호 확인 PasswordField
    @FXML private TextField Tf_email; // Email TextField
    @FXML private CheckBox radio_male; // 남성 RadioButton
    @FXML private CheckBox radio_female; // 여성 RadioButton


    // Initialize
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }
    
    // 회원가입 창 이동
    @FXML public void OpenRegister() throws Exception {
        Stage RegisterStage = new Stage();
        Parent register = FXMLLoader.load(getClass().getResource("register_foam.fxml"));
        RegisterStage.setScene(new Scene(register));
        RegisterStage.show();
        RegisterStage.setTitle("회원 가입");
        RegisterStage.setResizable(false);
        Stage stage = (Stage)btn_register.getScene().getWindow();
        stage.close();
    }

    // 회원가입 
    @FXML public void Register(ActionEvent event) throws Exception {
        if (Tf_id.getText().equals("") || Pf_pw.getText().equals("") || Tf_name.getText().equals("") || Tf_email.getText().equals(""))
        {
            Alert emptyError = new Alert(Alert.AlertType.ERROR);
            emptyError.setHeaderText("오류");
            emptyError.setContentText("비어있는 칸이 있습니다.");
            emptyError.showAndWait();
        }
        else if (!Pf_pw.getText().equals(Pf_confirm.getText())) {
            Alert pwError = new Alert(Alert.AlertType.ERROR);
            pwError.setHeaderText("비밀번호 오류");
            pwError.setContentText("비밀번호를 확인해주세요.");
            pwError.showAndWait();
        }

        else { // DB로 정보 전송
        }
        }

    }


