package cn.catmade.controller;

import cn.catmade.App;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * 开始界面
 *
 * @author Seven
 * @version 1.0
 * @date 2020/11/17 22:37
 */
public class StartController extends BaseController {

    @FXML
    private Button btnSelectFile;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setBtnOnClickListener();
    }

    @Override
    public void onStageInited() {
        stage.setWidth(500);
        stage.setHeight(360);
        stage.centerOnScreen();
        stage.setTitle("选择文件");
    }

    private void setBtnOnClickListener() {
        btnSelectFile.setOnMouseClicked(mouseEvent -> {
            btnSelectFile.setDisable(true);
            Platform.runLater(() -> {
                System.out.println("task-thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("txt files (*.txt)", "*.txt"),
                        new FileChooser.ExtensionFilter("any files (*.*)", "*.*")
                );

                File file = fileChooser.showOpenDialog(astage.get());
                if (file == null) {
                    return;
                }

                try {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put(PrimaryController.FILE_INTENT_NAME, file);
                    App.setRoot(PrimaryController.FXML_NAME, map);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            btnSelectFile.setDisable(false);
        });
    }
}
