package SEC_Assignment2.coreApp;

import SEC_Assignment2.textEditorApi.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;

public class PluginControllerMain implements PluginController
{

    private TextArea textArea;
    private ToolBar buttonBar;

    public PluginControllerMain(TextArea inTextArea, ToolBar inToolBar)
    {
        textArea = inTextArea;
        buttonBar = inToolBar;
    }

    @Override
    public String getTextBoxText()
    {
        return textArea.getText();
    }

    @Override
    public int getCaretPosition()
    {
        return textArea.getCaretPosition();
    }

    @Override
    public void setText(String inNewText)
    {
        textArea.setText(inNewText);
    }

    @Override
    public void setCaretPosition(int newCaretPosition)
    {
        int newPosition = 0; // <>TEST<>
        textArea.positionCaret(newPosition);
    }

    @Override
    public void addButton(String inLabelName, ButtonAction callback)
    {
        Button newButton = new Button(inLabelName);
        newButton.setOnAction( event -> callback.triggerAction() );
        /*TEST*/ System.out.println("buttonBar ->"); System.out.println(buttonBar);
        buttonBar.getItems().add(newButton);
    }

}
