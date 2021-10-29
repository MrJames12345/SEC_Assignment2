package texteditor;

import texteditor.textEditorApi.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DatePlugin implements TextEditorPlugin
{
    // Start
    @Override
    public void start(PluginController api)
    {
        api.addButton("Date", new DateAction(api));
    }

    // Button action callback
    private class DateAction implements ButtonAction
    {
        PluginController api;

        public DateAction(PluginController inApi)
        {
            api = inApi;
        }

        @Override
        public void triggerAction()
        {
            String currentText = api.getTextBoxText();
            int currentCaretPos = api.getCaretPosition();

            String addedText = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")); // <>WWW<> CHANGE THIS TO CURRENT LOCALE DATE
            String newText = currentText.substring(0, currentCaretPos) + addedText + currentText.substring(currentCaretPos);
            int newCaretPos = currentCaretPos + addedText.length();

            api.setText(newText);
            api.setCaretPosition(newCaretPos);
        }
    }
}