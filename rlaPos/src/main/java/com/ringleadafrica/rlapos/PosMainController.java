package com.ringleadafrica.rlapos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class PosMainController implements Initializable {

    @FXML
    private Hyperlink si_forgotPass;

    @FXML
    private Button si_loginBtn;

    @FXML
    private AnchorPane si_loginForm;

    @FXML
    private PasswordField si_password;

    @FXML
    private TextField si_username;

    @FXML
    private AnchorPane side_form;
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    private Alert alert;

    private ObservableList<UserModel> personalData = FXCollections.observableArrayList();

    public void loginBtn() {

        if (si_username.getText().isEmpty() || si_password.getText().isEmpty()) {

            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all blank fields");
            alert.showAndWait();

        } else {

            String sql = "SELECT username, password FROM users WHERE username = ? AND password = ?";

            connect = Database.DbConnection();

            try {

                prepare = connect.prepareStatement(sql);
                prepare.setString(1, si_username.getText());
                prepare.setString(2, si_password.getText());

                result = prepare.executeQuery();

                if(result.next()) {

                    String userInfo = "SELECT id, username, role FROM users " +
                            "WHERE username = '" + si_username.getText() + "' " +
                            "AND password = '" + si_password.getText() + "'";
                    try {

                        prepare = connect.prepareStatement(userInfo);
                        result = prepare.executeQuery();

                        if (result.next()) {

                            PersonalInfo.id = result.getInt("id");
                            PersonalInfo.username = result.getString("username");
                            PersonalInfo.role = result.getString("role");

//                            OPENING MAIN FORM DEPENDING ON THE USER LOGGED IN
                            Parent root;
                            if (PersonalInfo.role.equals("Admin")) {

                                root = FXMLLoader.load(getClass().getResource("admin-view.fxml"));
                                Stage stage = new Stage();
                                Scene scene = new Scene(root);

                                stage.setTitle("RLA - POS");

                                stage.setScene(scene);
                                stage.show();

                            } else {

                                root = FXMLLoader.load(getClass().getResource("teller-view.fxml"));
                                Stage stage = new Stage();
                                Scene scene = new Scene(root);

                                stage.setTitle("RLA - POS");

                                stage.setScene(scene);
                                stage.show();
                            }

                            si_loginBtn.getScene().getWindow().hide();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong username/password");
                    alert.showAndWait();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}