package SEC_Assignment2.texteditor;

import SEC_Assignment2.textEditorApi.*;

public class DateButton implements ButtonAction
{

    PluginController api;

    public DateButton(PluginController inApi)
    {
        api = inApi;
    }

    @Override
    public void triggerAction()
    {
        String currentText = api.getTextBoxText();
        int currentCaretPos = api.getCaretPosition();

        String addedText = "<ADDED TEXT>"; // <>WWW<> CHANGE THIS TO CURRENT LOCALE DATE
        String newText = currentText.substring(0, currentCaretPos + 1) + addedText + currentText.substring(currentCaretPos + 1);;
        int newCaretPosition = currentCaretPos + addedText.length();

        api.setText(newText);
        api.setCaretPosition(newCaretPosition);
    }
}