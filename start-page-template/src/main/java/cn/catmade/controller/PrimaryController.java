package cn.catmade.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.File;

/**
 * 主界面
 *
 * @author Seven
 * @version 1.0
 * @date 2020/11/17 22:37
 */
public class PrimaryController extends BaseController {

    public static final String FXML_NAME = "primary";

    public static final String FILE_INTENT_NAME = "file";

    @FXML
    private Label lbFilePath;

    @Override
    public void onStageInited() {
        stage.setWidth(800);
        stage.setHeight(600);
        stage.setTitle("主界面");
    }

    @Override
    protected void onDataInited() {
        File file = (File) data.get(FILE_INTENT_NAME);
        lbFilePath.setText(file.getAbsolutePath());
    }
}
