package texteditor.coreApp;

import texteditor.textEditorApi.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.control.TextInputDialog;

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
        textArea.requestFocus();
    }

    @Override
    public void setCaretPosition(int newCaretPosition)
    {
        textArea.positionCaret(newCaretPosition);
        textArea.requestFocus();
    }

    @Override
    public void selectText(int inStart, int inEnd)
    {
        textArea.selectRange(inStart, inEnd);
    }

    @Override
    public String promptUserText(String inTitle)
    {
        var dialog = new TextInputDialog();
        dialog.setTitle(inTitle);
        dialog.setHeaderText("Enter text");
        return dialog.showAndWait().orElse(null);
    }

    @Override
    public void addButton(String inLabelName, ButtonAction callback)
    {
        Button newButton = new Button(inLabelName);
        newButton.setOnAction( event -> callback.triggerAction() );
        buttonBar.getItems().add(newButton);
    }

}
