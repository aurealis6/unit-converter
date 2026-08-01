public class Converter {

    public static double convert(double value, String from, String to) {
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

}
