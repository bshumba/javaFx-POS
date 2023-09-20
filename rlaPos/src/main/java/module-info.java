module com.ringleadafrica.rlapos {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    opens com.ringleadafrica.rlapos to javafx.fxml;
    exports com.ringleadafrica.rlapos;
   exports com.ringleadafrica.rlapos.dialog;
   opens com.ringleadafrica.rlapos.dialog to javafx.fxml;
}