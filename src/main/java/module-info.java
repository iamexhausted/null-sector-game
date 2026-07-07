module com.github.iamexhausted.nullsectorgame.nullsectorgit {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.github.iamexhausted.nullsectorgame.nullsectorgit to javafx.fxml;
    exports com.github.iamexhausted.nullsectorgame.nullsectorgit;
}