package texteditor.textEditorApi;

public interface PluginController
{
    public String getTextBoxText();
    public int getCaretPosition();
    public void setText(String inNewText);
    public void setCaretPosition(int newCaretPosition);
    public void selectText(int inStart, int inEnd);
    public String promptUserText(String inTitle);
    
    public void addButton(String inLabelName, ButtonAction callback);
}