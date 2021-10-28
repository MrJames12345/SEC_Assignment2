package SEC_Assignment2.coreApp;

// Subprojects
import SEC_Assignment2.textEditorApi.*;
import SEC_Assignment2.texteditor.*;
//JavaFX
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import java.lang.reflect.InvocationTargetException;

public class MainGUI
{
    
    private Stage stage;
    private TextArea textArea;
    private ToolBar toolBar;
    
    public void initialise(Stage inStage)
    {
        
        // - Structure - //

        stage = inStage;
        stage.setTitle(BundleHandler.getString("main_title"));
        stage.setMinWidth(800);

        // Toolbar
        Button btn1 = new Button(BundleHandler.getString("add_plugin_button"));
        Button btn2 = new Button(BundleHandler.getString("add_script_button"));
        toolBar = new ToolBar(btn1, btn2);
        // Subtle user experience tweaks
        toolBar.setFocusTraversable(false);
        toolBar.getItems().forEach(btn -> btn.setFocusTraversable(false));
        // Main area
        BorderPane mainBox = new BorderPane();
        mainBox.setTop(toolBar);
        textArea = new TextArea();
        textArea.setStyle("-fx-font-family: 'monospace'");
        mainBox.setCenter(textArea);
        Scene scene = new Scene(mainBox);

        // - Setting actions - //

        btn1.setOnAction(event -> addPlugin());
        btn2.setOnAction(event -> addScript());
        
        // TextArea event handlers & caret positioning.
        textArea.textProperty().addListener((object, oldValue, newValue) -> 
        {
            System.out.println("textArea.getCaretPosition() -> " + textArea.getCaretPosition());
            System.out.println("newValue -> " + newValue);
        });
        
        textArea.selectRange(8, 16); // Select a range of text (and move the caret to the end)

        // Example global keypress handler.
        scene.setOnKeyPressed(keyEvent -> 
        {
            KeyCode key = keyEvent.getCode();
            boolean ctrl = keyEvent.isControlDown();
            boolean shift = keyEvent.isShiftDown();
            boolean alt = keyEvent.isAltDown();
            if(key == KeyCode.F1)
            {
                new Alert(Alert.AlertType.INFORMATION, "F1", ButtonType.OK).showAndWait();
            }
            else if(ctrl && shift && key == KeyCode.B)
            {
                new Alert(Alert.AlertType.INFORMATION, "ctrl+shift+b", ButtonType.OK).showAndWait();
            }
            else if(ctrl && key == KeyCode.B)
            {
                new Alert(Alert.AlertType.INFORMATION, "ctrl+b", ButtonType.OK).showAndWait();
            }
            else if(alt && key == KeyCode.B)
            {
                new Alert(Alert.AlertType.INFORMATION, "alt+b", ButtonType.OK).showAndWait();
            }
        });

        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    private void addPlugin()
    {
        // User input for plugin name
        var dialog = new TextInputDialog();
        dialog.setTitle(BundleHandler.getString("add_plugin_button"));
        dialog.setHeaderText("Enter text");

        var inputStr = dialog.showAndWait().orElse(null);
        // IF entered text, load plugin
        if(inputStr != null)
        {
            try
            {
                Class<?> pluginClass = Class.forName("SEC_Assignment2.texteditor.DatePlugin");
                TextEditorPlugin pluginObject = (TextEditorPlugin) pluginClass.getConstructor().newInstance();
                /*TEST*/ System.out.println("textArea ->"); System.out.println(textArea);
                /*TEST*/ System.out.println("toolBar ->"); System.out.println(toolBar);
                PluginControllerMain pluginController = new PluginControllerMain(textArea, toolBar);
                pluginObject.start(pluginController);
            }
            catch( ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e )
            {
                System.out.println("Error loading plugin: [" + e.getClass() + "] " + e.toString());
                

            }

        }
    }

    private void addScript()
    {
        
    }

    private void EXAMPLE()
    {
        // Button addBtn = new Button("Add...");
        // Button removeBtn = new Button("Remove...");
        // ToolBar toolBar = new ToolBar(addBtn, removeBtn);
        
        // addBtn.setOnAction(event -> new Alert(Alert.AlertType.INFORMATION, "Add...", ButtonType.OK).showAndWait());
        // removeBtn.setOnAction(event -> new Alert(Alert.AlertType.INFORMATION, "Remove...", ButtonType.OK).showAndWait());

        // // FYI: 'ObservableList' inherits from the ordinary List interface, but also works as a subject for any 'observer-pattern' purposes; e.g., to allow an on-screen ListView to display any changes made to the list as they are made.

        // ObservableList<String> list = FXCollections.observableArrayList();
        // ListView<String> listView = new ListView<>(list);        
        // list.add("Item 1");
        // list.add("Item 2");
        // list.add("Item 3");

        // BorderPane box = new BorderPane();
        // box.setTop(toolBar);
        // box.setCenter(listView);

        // Dialog dialog = new Dialog();
        // dialog.setTitle("List of things");
        // dialog.setHeaderText("Here's a list of things");
        // dialog.getDialogPane().setContent(box);
        // dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        // dialog.showAndWait();
    }
}