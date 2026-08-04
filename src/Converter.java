public class Converter {

    public static double convert(double value, String from, String to) {
        if (isLength(from)) {
            return convertLength(value, from, to);
        } else if (isWeight(from)) {
            return convertWeight(value, from, to);
        } else if (isTemperature(from)) {
            return convertTemperature(value, from, to);
        }
        throw new IllegalArgumentException("Unknown unit: " + from);
    }

    private static boolean isLength(String unit) {
        return unit.equals("meter") || unit.equals("foot") || unit.equals("centimeter")
                || unit.equals("millimeter") || unit.equals("kilometer") || unit.equals("inch")
                || unit.equals("yard") || unit.equals("mile");
    }

    private static boolean isWeight(String unit) {
        return unit.equals("kilogram") || unit.equals("gram") || unit.equals("milligram") || unit.equals("pound") || unit.equals("ounce");
    }

    private static boolean isTemperature(String unit) {
        return unit.equals("celsius") || unit.equals("fahrenheit") || unit.equals("kelvin");
    }

    public static double convertLength(double value, String from, String to) {
        double result = 0.0;

        switch (from) {
            case "foot": value *= 0.3048; break;
            case "centimeter": value *= 0.01; break;
            case "millimeter": value *= 0.001; break;
            case "kilometer": value *= 1000; break;
            case "inch": value *= 0.0254; break;
            case "yard": value *= 0.9144; break;
            case "mile": value *= 1609.34; break;
        }

        switch (to) {
            case "meter": result = value; break;
            case "foot": result = value / 0.3048; break;
            case "centimeter": result =value / 0.01; break;
            case "millimeter": result =value / 0.001; break;
            case "kilometer": result =value / 1000; break;
            case "inch": result =value / 0.0254; break;
            case "yard": result =value / 0.9144; break;
            case "mile": result =value / 1609.34; break;
        }
        return result;
    }

    private static double convertWeight(double value, String from, String to) {
        double result = 0.0;

        switch (from) {
            case "gram": value *= 0.001; break;
            case "milligram": value *= 0.000001; break;
            case "pound": value *= 0.453592; break;
            case "ounce": value *= 0.0283495; break;
        }

        switch (to) {
            case "kilogram": result = value; break;
            case "gram": result = value / 0.001; break;
            case "milligram": result = value / 0.000001; break;
            case "pound": result = value / 0.453592; break;
            case "ounce": result = value / 0.0283495; break;
        }
        return result;
    }

    private static double convertTemperature(double value, String from, String to) {
        double celsius;
        switch (from) {
            case "fahrenheit": celsius = (value - 32) * 5.0 / 9.0; break;
            case "kelvin": celsius = value - 273.15; break;
            default: celsius = value;
        }

        switch (to) {
            case "fahrenheit": return celsius * 9.0 / 5.0 + 32;
            case "kelvin": return celsius + 273.15;
            default: return celsius;
        }
    }

}
