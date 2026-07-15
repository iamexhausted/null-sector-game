module com.github.iamexhausted.nullsectorgame.nullsectorgit {
    requires javafx.controls;
    requires com.google.gson;

    opens com.github.iamexhausted.nullsectorgame.model.level_system to com.google.gson;
    opens com.github.iamexhausted.nullsectorgame.model.dto to com.google.gson;

    exports com.github.iamexhausted.nullsectorgame;
}