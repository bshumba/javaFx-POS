package com.example.customdialog;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

   @FXML
   private Button openDialogBtn;

   @FXML
   private Button cancelBtn;

   @FXML
   private TextField code_txt;

   @FXML
   private Button confirmBtn;

   public void openDialog() {

      try{

         FXMLLoader fxmlLoader = new FXMLLoader();
         fxmlLoader.setLocation(getClass().getResource("dialog-view.fxml"));
         DialogPane myDialog = fxmlLoader.load();

         Dialog<ButtonType> dialog = new Dialog<>();
         dialog.setDialogPane(myDialog);
         dialog.setTitle("My Dialog");
         dialog.showAndWait();

      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void openVBox() {

      try {

         FXMLLoader fxmlLoader = new FXMLLoader();
         fxmlLoader.setLocation(getClass().getResource("test-view.fxml"));
         DialogPane myDialog = fxmlLoader.load();

         Dialog<ButtonType> dialog = new Dialog<>();
         dialog.setDialogPane(myDialog);
         dialog.setTitle("My Dialog");
         dialog.showAndWait();

      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void customVBox() {
      dialogController.Display();
   }

   String dialogText;
   public void getConfirmation() {

      dialogText = code_txt.getText();

      confirmBtn.getScene().getWindow().hide();

      System.out.println(dialogText);
   }

   @Override
   public void initialize(URL location, ResourceBundle resources) {

   }
}