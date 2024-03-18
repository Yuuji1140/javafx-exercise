module edu.sjsu.cs {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.sjsu.cs to javafx.fxml;
    exports edu.sjsu.cs;
}
