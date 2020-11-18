module com.py7hon {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.desktop;

    opens cn.catmade.controller to javafx.fxml;

    exports cn.catmade;
    exports cn.catmade.controller;
}