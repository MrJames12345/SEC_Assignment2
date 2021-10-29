package texteditor.textEditorApi;

public interface CaretMover
{
    int getNewPosition(String inText, int inCurrentPosition);
}