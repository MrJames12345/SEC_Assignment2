package texteditor.coreApp;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage stage)
    {
        // var localeString = getParameters().getNamed().get("locale");
        // if(localeString != null)
        // {
        //     BundleHandler.setBundle(localeString);
        // }

        MainGUI mainGui = new MainGUI();
        mainGui.initialise(stage);
    }
}
