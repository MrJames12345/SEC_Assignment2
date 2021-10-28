package SEC_Assignment2.texteditor;

import SEC_Assignment2.textEditorApi.*;

public class DatePlugin implements TextEditorPlugin
{
    @Override
    public void start(PluginController api)
    {
        api.addButton("Add Date", new DateButton(api));
    }
}