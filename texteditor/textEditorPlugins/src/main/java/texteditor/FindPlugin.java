package texteditor;

import texteditor.textEditorApi.*;

public class FindPlugin implements TextEditorPlugin
{
    // Start
    @Override
    public void start(PluginController api)
    {
        api.addButton("Find", new FindAction(api));
    }

    // Button action callback
    private class FindAction implements ButtonAction
    {
        PluginController api;

        public FindAction(PluginController inApi)
        {
            api = inApi;
        }

        @Override
        public void triggerAction()
        {
            // Ask user for search
            var enteredSearch = api.promptUserText("Enter search term...");
            // Get text after caret position
            int currentCaretPos = api.getCaretPosition();
            String textFromCaret = api.getTextBoxText().substring(currentCaretPos);
            // IF search term exists in text, select search term in text
            int searchTermPosition = textFromCaret.indexOf(enteredSearch);
            if ( searchTermPosition >= 0 )
                api.selectText(currentCaretPos + searchTermPosition, currentCaretPos + searchTermPosition + enteredSearch.length());
        }
    }
}