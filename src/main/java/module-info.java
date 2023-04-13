module com.studentmanagementjfx.studentmanagementjfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires org.junit.jupiter.api;

    opens com.studentmanagementjfx to javafx.fxml;
    exports com.studentmanagementjfx;
    exports com.studentmanagementjfx.Controllers;
    exports com.studentmanagementjfx.Controllers.Admin;
    exports com.studentmanagementjfx.Controllers.Client;
    exports com.studentmanagementjfx.Models;
    exports com.studentmanagementjfx.Views;
}