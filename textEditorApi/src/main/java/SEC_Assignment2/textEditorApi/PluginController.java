package SEC_Assignment2.textEditorApi;

public interface PluginController
{
    public String getTextBoxText();
    public int getCaretPosition();
    public void setText(String inNewText);
    public void setCaretPosition(int newCaretPosition);
    public void addButton(String inLabelName, ButtonAction callback);
}