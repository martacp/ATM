package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginGUI extends Application{

    Stage Window;
    Scene LoginScene;
    TextField Username;
    PasswordField Password;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Window = primaryStage;
        Window.setTitle("ATM");

        GridPane grid = new GridPane();
        grid.setVgap(8);
        grid.setHgap(8);

        Label userLabel = new Label();
        userLabel.setText("Username: ");
        grid.setConstraints(userLabel, 0, 0);

        Username = new TextField();
        Username.setMaxWidth(200);
        grid.setConstraints(Username, 1, 0);

        Label passwordLabel = new Label();
        passwordLabel.setText("Password: ");
        grid.setConstraints(passwordLabel, 0, 1);

        Password = new PasswordField();
        Password.setMaxWidth(200);
        grid.setConstraints(Password, 1, 1);

        Button button = new Button();
        button.setText("Login");
        grid.setConstraints(button, 1, 2);

        grid.setAlignment(Pos.CENTER);
        grid.getChildren().addAll(userLabel, Username, passwordLabel, Password, button);

        LoginScene = new Scene(grid, 300,340);
        Window.setScene(LoginScene);
        Window.show();
    }
}
