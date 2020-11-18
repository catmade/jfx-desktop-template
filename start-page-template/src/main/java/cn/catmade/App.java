package cn.catmade;

import cn.catmade.controller.BaseController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

/**
 * JavaFX cn.catmade.App
 */
public final class App extends Application {

    private static Scene scene;

    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        // 需要先赋值，因为在 setRoot 方法中会使用到 stage
        App.stage = stage;

        stage.getIcons().add(new Image(App.class.getResource("/image/logo.png").toString()));

        setRoot("start", null);
        stage.show();
    }

    /**
     * 设置窗体内容并初始化控制器
     *
     * @param name fxml 文件名（不包含扩展名）.加载 resources/fxml 路径下的名字为 {@code name}.fxml 的文件
     * @param data 初始化控制器时传入的数据
     * @throws IOException 文件访问异常
     */
    public static void setRoot(String name, Map<String, Object> data) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/fxml/" + name + ".fxml"));
        Parent parent = loader.load();

        BaseController controller = loader.getController();
        controller.setStage(stage);
        controller.initData(data);

        if (scene == null) {
            scene = new Scene(parent);
            stage.setScene(scene);
        } else {
            scene.setRoot(parent);
        }
    }

    public static void main(String[] args) {
        launch();
    }

}