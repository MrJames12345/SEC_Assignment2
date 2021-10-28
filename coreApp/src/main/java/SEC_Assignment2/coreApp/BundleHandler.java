package SEC_Assignment2.coreApp;

import java.util.Locale;
import java.util.ResourceBundle;

public class BundleHandler {
    
    // Variables
    private static String defaultLocale = "en-AU";
    private static ResourceBundle staticBundle;

    // Set bundle
    public static void setBundle(String inLocale)
    {
        staticBundle = ResourceBundle.getBundle("bundle", Locale.forLanguageTag(inLocale));
    };

    // Get string using given label
    public static String getString(String inLabel)
    {
        if (staticBundle == null)
        {
            staticBundle = ResourceBundle.getBundle("bundle", Locale.forLanguageTag(defaultLocale));
        }
        System.out.println(staticBundle);
        return staticBundle.getString(inLabel);
    }

}
