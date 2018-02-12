package io.mateu.games.javafx;

import io.mateu.games.core.Juego;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World!");
        
        /*
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        */

        StackPane root = new StackPane();
        //root.getChildren().add(btn);

        Canvas canvas;
        root.getChildren().add(canvas = new Canvas());

        root.setPrefHeight(2000);
        root.setPrefWidth(2000);

        ServiceLoader<Juego> loader = ServiceLoader.load(Juego.class);

        Juego j = null;

        try {
            Iterator<Juego> js = loader.iterator();
            while (j == null && js.hasNext()) {
                j = js.next();
            }
        } catch (ServiceConfigurationError serviceError) {
            serviceError.printStackTrace();
        }


        j.setRenderizador(new JavaFXRenderizador(canvas, j));

        Juego finalJ1 = j;
        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            finalJ1.setScreenX((Double) newVal);
            canvas.setWidth((Double) newVal);
            System.out.println("w=" + newVal);
        });

        primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
            finalJ1.setScreenY((Double) newVal);
            canvas.setHeight((Double) newVal);
            System.out.println("h=" + newVal);
        });

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();

        Juego finalJ = j;
        canvas.setOnMouseClicked(e -> finalJ.tap(e.getX(), e.getY()));
        canvas.setOnMouseMoved(e -> finalJ.moveTo(e.getX(), e.getY()));


        j.onStart();

    }


}
