package com.ringleadafrica.rlapos.dialog;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.ColorInput;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddQuantityDialog {

   static Integer qty = 0;

   public static Integer addQuantity(int oldQty) {

      Stage stage = new Stage();
      stage.initModality(Modality.APPLICATION_MODAL);
      TextField text1 = new TextField();
      text1.setPrefWidth(160);

      Label titleLabel = new Label("Enter Quantity or Remove Product");
      titleLabel.setStyle("-fx-font-size: 16px;" +
              "-fx-font-weight: bold;");

      Label label = new Label("Enter Quantity:");
      label.setStyle("-fx-font-size: 14px;");

      GridPane gridPane = new GridPane();
      gridPane.setHgap(25);

      gridPane.add(label, 0, 0);
      gridPane.add(text1, 1, 0);

      Separator sep = new Separator();

      Button addBtn = new Button("Add");
      addBtn.setPrefWidth(80);
      addBtn.setPrefHeight(35);
      addBtn.setStyle("-fx-font-size: 14px;" +
              "-fx-background-color: rgb(18, 50, 233);" +
              "-fx-text-fill: #fff;");
      addBtn.setOnAction(e -> {
         if (text1.getText().isEmpty() || text1.getText().isBlank()) {
            qty = oldQty;
         } else {
            qty = Integer.valueOf(text1.getText());
            stage.close();
         }
      });

      Button dropBtn = new Button("Drop");
      dropBtn.setPrefWidth(80);
      dropBtn.setPrefHeight(35);
      dropBtn.setStyle("-fx-font-size: 14px;" +
              "-fx-background-color: rgb(252, 5, 5);" +
              "-fx-text-fill: #fff;");
      dropBtn.setOnAction(e -> {
         qty = -1;
         stage.close();
      });

      Button cancelBtn = new Button("Cancel");
      cancelBtn.setPrefWidth(80);
      cancelBtn.setPrefHeight(35);
      cancelBtn.setStyle("-fx-font-size: 14px;" +
              "-fx-background-color: rgb(128, 25, 11);" +
              "-fx-text-fill: #fff;");
      cancelBtn.setOnAction(e -> {
         qty = oldQty;
         stage.close();
      });

      GridPane btnGridPane = new GridPane();
      btnGridPane.setHgap(20);

      btnGridPane.add(addBtn, 0,0);
      btnGridPane.add(dropBtn, 1, 0);
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

      return qty;
   }
}
