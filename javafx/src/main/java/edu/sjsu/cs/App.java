package edu.sjsu.cs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        List<Student> list = new ArrayList<>();
        list.add(new Student("John Doe", 1425,
                "https://images.unsplash.com/photo-1504251689939-201421c8e87d?q=80&w=3088&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"));
        list.add(new Student("Noah Miller", 6913,
                "https://images.unsplash.com/photo-1553197965-096ced3bf9df?q=80&w=3087&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"));
        VBox vb = new VBox();
        for (Student student : list) {
            vb.getChildren().add(getStudent(student));
        }

        BorderPane bp = new BorderPane();
        bp.setCenter(vb);

        scene = new Scene(bp, 350, 230, Color.LIGHTYELLOW);
        stage.setScene(scene);
        stage.setMinHeight(500);
        stage.setMinWidth(500);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    private VBox getStudent(Student s) {
        VBox student = new VBox();
        student.getChildren().add(new Text("Name: " + s.getName()));
        student.getChildren().add(new Text("ID: " + s.getStudentID()));

        Image image = new Image(s.getImgURL());
        ImageView imageView = new ImageView(image);

        double measure = Math.min(image.getWidth(), image.getHeight());
        double x = (image.getWidth() - measure) / 2;
        double y = (image.getHeight() - measure) / 2;
        Rectangle2D viewport = new Rectangle2D(x + 300, y, 1500, 1500);
        imageView.setViewport(viewport);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);

        student.getChildren().add(imageView);
        student.setBackground(new Background(new BackgroundFill(Color.DARKCYAN, null, null)));
        student.setPadding(new Insets(10));
        student.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DASHED, null, null)));
        student.setStyle("-fx-background-color: yellow;");
        return student;
    }

    public static void main(String[] args) {
        launch(args);
    }
}