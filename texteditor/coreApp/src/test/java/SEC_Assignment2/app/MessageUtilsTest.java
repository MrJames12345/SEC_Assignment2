/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package texteditor.app;

import org.junit.jupiter.textEditorApi.Test;

import static org.junit.jupiter.textEditorApi.Assertions.assertEquals;

public class MessageUtilsTest {
    @Test public void testGetMessage() {
        assertEquals("Hello      World!", MessageUtils.getMessage());
    }
}
