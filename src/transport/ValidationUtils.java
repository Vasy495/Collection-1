package transport;

public class ValidationUtils {
    
        public static String validOfDefault(String value) {
            return value == null || value.isBlank() ? "Информация не задана" : value;
        }

        public static int validOfIntDefault(int value) {
            return value >= 0 ? value : 0;
        }

        public static float validOfFloatDefault(float value) {
            return (value >= 0 ? value : 0);
        }
    }
