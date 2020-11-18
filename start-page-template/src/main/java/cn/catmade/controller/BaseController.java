package cn.catmade.controller;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 基本控制器，包含 stage 对象，可以进行窗体相关的操作
 *
 * @author Seven
 * @version 1.0
 * @date 2020/11/17 22:55
 */
public class BaseController implements Initializable {

    protected static AtomicReference<Stage> astage = new AtomicReference<>();

    protected Stage stage;

    /**
     * 保存外部传递的数据<br>
     * 参考：{@link cn.catmade.App#setRoot(String, Map)}
     */
    protected final Map<String, Object> data = new HashMap<>();

    /**
     * 设置 stage
     *
     * @param stage stage
     */
    public final void setStage(Stage stage) {
        this.stage = stage;
        BaseController.astage.set(stage);
        onStageInited();
    }

    /**
     * 初始化 stage 后，会调用此方法
     */
    public void onStageInited() {
        // Override
    }

    public final void initData(Map<String, Object> data) {
        if (data != null) {
            data.forEach(this.data::put);
        }
        onDataInited();
    }

    /**
     * 初始化数据完成后，会调用此方法
     */
    protected void onDataInited() {
        // Override
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Override
    }
}
