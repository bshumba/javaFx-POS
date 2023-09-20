package com.example.customdialog;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class dialogController {

   public static void Display() {

      Stage stage = new Stage();
      stage.initModality(Modality.APPLICATION_MODAL);
      TextField text1 = new TextField();
      text1.setPrefWidth(160);

      Label titleLabel = new Label("Enter Quantity or Remove Product");
      titleLabel.setStyle("-fx-font-size: 16px;");

      Label label = new Label("Enter Text:");
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

      Button dropBtn = new Button("Drop");
      dropBtn.setPrefWidth(80);
      dropBtn.setPrefHeight(35);
      dropBtn.setStyle("-fx-font-size: 14px;" +
              "-fx-background-color: rgb(252, 5, 5);" +
              "-fx-text-fill: #fff;");

      Button cancelBtn = new Button("Cancel");
      cancelBtn.setPrefWidth(80);
      cancelBtn.setPrefHeight(35);
      cancelBtn.setStyle("-fx-font-size: 14px;" +
              "-fx-background-color: rgb(128, 25, 11);" +
              "-fx-text-fill: #fff;");

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
      layout.setMargin(titleLabel, new Insets(5, 5, 5, 20));
      layout.setSpacing(4);
      layout.setStyle("-fx-background-color: #50C797;");

      Scene scene = new Scene(layout, 320, 200);
      stage.setTitle("RLA - POS");
      stage.setScene(scene);
      stage.showAndWait();

   }

}
