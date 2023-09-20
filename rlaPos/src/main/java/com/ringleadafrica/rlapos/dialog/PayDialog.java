package com.ringleadafrica.rlapos.dialog;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PayDialog {

   private static Alert alert;
   static Double amount = -1.0;
   public static Double makePayment(double totCost) {

      Stage stage = new Stage();
      stage.initModality(Modality.APPLICATION_MODAL);

      TextField text1 = new TextField();
      text1.setPrefWidth(160);

      Label titleLabel = new Label("Enter Amount Presented By Client");
      titleLabel.setStyle("-fx-font-size: 16px;" +
              "-fx-font-weight: bold;");

      Label label = new Label("Enter Amount:");
      label.setStyle("-fx-font-size: 14px;");

      GridPane gridPane = new GridPane();
      gridPane.setHgap(25);

      gridPane.add(label, 0, 0);
      gridPane.add(text1, 1, 0);

      Separator sep = new Separator();

      Button addBtn = new Button("Pay");
      addBtn.setPrefWidth(100);
      addBtn.setPrefHeight(35);
      addBtn.setStyle("-fx-font-size: 14px;" +
              "-fx-background-color: F7BD1E;" +
              "-fx-text-fill: #000;");
      addBtn.setOnAction(e -> {
         if (text1.getText().isEmpty() || text1.getText().isBlank()) {
            amount = -1.0;
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Amount cannot be Empty");
            alert.showAndWait();

         } else {

            if (amount < totCost) {

               alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Error Message");
               alert.setHeaderText(null);
               alert.setContentText("Insufficient Amount!!!");
               alert.showAndWait();

            } else {
               amount = Double.valueOf(text1.getText());
               stage.close();
            }
         }
      });

      Button cancelBtn = new Button("Cancel");
      cancelBtn.setPrefWidth(100);
      cancelBtn.setPrefHeight(35);
      cancelBtn.setStyle("-fx-font-size: 14px;" +
              "-fx-background-color: rgb(252, 5, 5);" +
              "-fx-text-fill: #000;");
      cancelBtn.setOnAction(e -> {
         amount = -1.0;
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

      return amount;
   }
}
