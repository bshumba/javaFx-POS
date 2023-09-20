module com.example.customdialog {
   requires javafx.controls;
   requires javafx.fxml;
   requires javafx.graphics;

   opens com.example.customdialog to javafx.fxml;
   exports com.example.customdialog;
}