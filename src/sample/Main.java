package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("-----start----- " + Thread.currentThread().getName());
        stage.setTitle("Hello JavaFX");

        Label nameLbl = new Label("Enter your name:");
        TextField nameFld = new TextField();

        Label msg = new Label();
        msg.setStyle("-fx-text-fill: blue;");

        Button sayHelloBtn = new Button("Say Hello");
        Button exitBtn = new Button("Exit");

        sayHelloBtn.setOnAction(e -> {
            String name = nameFld.getText();
            if (name.trim().length() > 0) {
                msg.setText("Hello " + name);
            } else {
                msg.setText("Hello there");
            }
        });

        //A JavaFX application may be run in web browsers. Calling the Platform.exit() method in web
        //environments may not have any effect.
        exitBtn.setOnAction(e -> Platform.exit());

        VBox root = new VBox();

        root.setSpacing(5);

        root.getChildren().addAll(nameLbl, nameFld, msg, sayHelloBtn, exitBtn);

        Scene scene = new Scene(root, 350, 150);
        stage.setScene(scene);
        stage.setTitle("Hello JavaFX Application");
        stage.show();
    }

    @Override
    public void init() throws Exception {
        //It is not allowed to create a Stage or a Scene on the JavaFX Launcher Thread.
        //They must be created on the JavaFX Application Thread.
        System.out.println("-----init----- " + Thread.currentThread().getName());
        super.init();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("-----stop----- " + Thread.currentThread().getName());
        super.stop();
    }

    public static void main(String[] args) {
        System.out.println("-----main----- " + Thread.currentThread().getName());
        launch(args);
    }
}
