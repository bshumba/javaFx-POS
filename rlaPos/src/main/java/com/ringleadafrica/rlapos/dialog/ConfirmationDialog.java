package com.ringleadafrica.rlapos.dialog;

import com.ringleadafrica.rlapos.Database;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConfirmationDialog {

   private static Connection connect;
   private static PreparedStatement prepare;
   private static ResultSet result;
   private static Alert alert;
   static String managerCode = "no";
   public static String managerConfirm() {
      Stage stage = new Stage();
      stage.initModality(Modality.APPLICATION_MODAL);

      TextField text1 = new TextField();
      text1.setPrefWidth(160);

      Label titleLabel = new Label("Enter Manager Code To Proceed");
      titleLabel.setStyle("-fx-font-size: 16px;" +
              "-fx-font-weight: bold;");

      Label label = new Label("Enter Code:");
      label.setStyle("-fx-font-size: 14px;");

      GridPane gridPane = new GridPane();
      gridPane.setHgap(25);

      gridPane.add(label, 0, 0);
      gridPane.add(text1, 1, 0);

      Separator sep = new Separator();

      Button addBtn = new Button("Confirm");
      addBtn.setPrefWidth(100);
      addBtn.setPrefHeight(35);
      addBtn.setStyle("-fx-font-size: 14px;" +
              "-fx-background-color: rgb(18, 50, 233);" +
              "-fx-text-fill: #fff;");
      addBtn.setOnAction(e -> {
         if (text1.getText().isEmpty() || text1.getText().isBlank()) {
            managerCode = "no";
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Code Textbox cannot be Empty");
            alert.showAndWait();

         } else {

            managerCode = text1.getText();

            String sqlCheck = "SELECT * FROM users WHERE password = '"
                    + managerCode + "' AND role = '" + "Admin" + "'";
            connect = Database.DbConnection();

            try {

               prepare = connect.prepareStatement(sqlCheck);
               result = prepare.executeQuery();

               if (result.next()) {

                  managerCode = "yes";
                  stage.close();

               } else {

                  alert = new Alert(Alert.AlertType.ERROR);
                  alert.setTitle("Error Message");
                  alert.setHeaderText(null);
                  alert.setContentText("Wrong manager password");
                  alert.showAndWait();
               }

            } catch (Exception event) {
               event.printStackTrace();
            }

         }
      });

      Button cancelBtn = new Button("Cancel");
      cancelBtn.setPrefWidth(100);
      cancelBtn.setPrefHeight(35);
      cancelBtn.setStyle("-fx-font-size: 14px;" +
              "-fx-background-color: rgb(252, 5, 5);" +
              "-fx-text-fill: #fff;");
      cancelBtn.setOnAction(e -> {
         managerCode = "no";
         stage.close();
      });

      GridPane btnGridPane = new GridPane();
      btnGridPane.setHgap(20);

      btnGridPane.add(addBtn, 0,0);
      btnGridPane.add(cancelBtn, 2, 0);

      HBox hBox = new HBox(btnGridPane);
      hBox.setPadding(new Insets(10, 10, 0, 20));

      VBox layout = new VBox(titleLabel, gridPane, sep, hBox);
      layout.setPadding(new Insets(20, 10, 10, 10));
      layout.setMargin(gridPane, new Insets(10, 10, 20, 10));
      layout.setMargin(titleLabel, new Insets(0, 5, 10, 20));
      layout.setSpacing(4);
      layout.setStyle("-fx-background-color: #50C797;");

      Scene scene = new Scene(layout, 320, 200);
      stage.setTitle("RLA - POS");
      stage.setScene(scene);
      stage.showAndWait();

      return managerCode;
   }
}
