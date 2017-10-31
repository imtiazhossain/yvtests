package automationFramework.utils;

public class Utils {

    public static String applyDefaultIfMissing(String variable, String defaultValue) {
        if (variable == null) {
            variable = defaultValue;
        }

        return variable;
    }
}

