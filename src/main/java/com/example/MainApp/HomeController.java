package com.example.MainApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Parent DBRoot;
    private Stage DBStage;
    private Scene DBScene;
    @FXML
    private Button DBButton;
    @FXML
    private Rectangle indicator;


    public void switchToAddData(ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("add-data-view.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("add data");

            // Get current buildings and send them to AddDataController

            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public void switchToPrediction(ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("prediction-view.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("prediction");

            // Get current buildings and send them to AddDataController

            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public void switchToReport(ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("report-view.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("reports");

            // Get current buildings and send them to AddDataController

            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public void switchToScenarios(ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("scenarios-view.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("scenarios");

            // Get current buildings and send them to AddDataController

            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public void switchToUpdateData(ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("update-data-view.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("update data");

            // Get current buildings and send them to AddDataController

            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public void switchToViewData(ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("view-data-view.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("view data");

            // Get current buildings and send them to AddDataController

            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Boolean checkDatabaseConnection(){
        // add the code here to check if the database is connected or not


        return true;
    }

    public void openDBWindow (ActionEvent event){
        try {
            DBButton.setDisable(true);
            DBRoot = FXMLLoader.load(getClass().getResource("DBWindow.fxml"));
            DBStage = new Stage();
            DBStage.initModality(Modality.APPLICATION_MODAL);
            DBScene = new Scene(DBRoot);
            DBStage.setScene(DBScene);
            DBStage.setResizable(false);
            DBStage.initStyle(StageStyle.UTILITY);
            DBStage.setOnHidden( windowEvent -> {
                DBButton.setDisable(false);
                if(checkDatabaseConnection()){
                    indicator.setFill(Color.GREEN);
                }
                else{
                    indicator.setFill(Color.RED);
                }});

            DBStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
