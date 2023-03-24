package com.smallplayz.javawebbrowser;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class WebController implements Initializable {
    @FXML
    private Button newTabButton;
    @FXML
    private TabPane tabPane;
    @FXML
    private WebView webView;
    @FXML
    private TextField searchBar;
    @FXML
    private GridPane gridPane;

    private WebEngine engine;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        engine = webView.getEngine();
        engine.load("http://www.google.com");
    }

    public void searchButton() {
        engine.load("http://www." + searchBar.getText());
    }
    public void newTab() {
        Tab newTab = new Tab("New Tab");
        newTab.setClosable(true);

        BorderPane boarderPane = new BorderPane();
        WebView webView1 = new WebView();
        boarderPane.setCenter(webView1);

        GridPane gridPane1 = gridPane;
        boarderPane.setTop(gridPane1);

        newTab.setContent(boarderPane);
        engine = webView1.getEngine();
        engine.load("https://www.google.com");

        tabPane.getTabs().add(newTab);

        tabPane.getSelectionModel().select(newTab);
    }
}