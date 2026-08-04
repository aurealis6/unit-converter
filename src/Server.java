import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;

public class Server {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", (HttpExchange exchange) -> {
            String response = Files.readString(Path.of("src/form.html"));
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.createContext("/convert", (HttpExchange exchange) -> {
            String query = exchange.getRequestURI().getQuery();
            System.out.println(query);

            String[] splitQuery = query.split("&");
            double value = 0.0;
            String from = "";
            String to = "";
            for (int i = 0; i < splitQuery.length; i++) {
                String[] tokens = splitQuery[i].split("=");
                if (tokens[0].equals("value")) {
                    value = Double.parseDouble(tokens[1]);
                } else if (tokens[0].equals("from")) {
                    from = tokens[1];
                } else if (tokens[0].equals("to")) {
                    to = tokens[1];
                }
            }
            String formattedResult = String.format(java.util.Locale.US, "%.5f", Converter.convert(value, from, to));
            exchange.getResponseHeaders().set("Content-Type", "text/plain");
            byte[] responseBytes = formattedResult.getBytes();
            exchange.sendResponseHeaders(200, responseBytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(responseBytes);
            os.close();
        });

        server.createContext("/unit-converter-style.css", (HttpExchange exchange) -> {
            String css = Files.readString(Path.of("src/unit-converter-style.css"));
            exchange.getResponseHeaders().set("Content-Type", "text/css");
            exchange.sendResponseHeaders(200, css.length());
            OutputStream os = exchange.getResponseBody();
            os.write(css.getBytes());
            os.close();
        });

        server.createContext("/Inter-Variable.ttf", (HttpExchange exchange) -> {
            byte[] fontBytes = Files.readAllBytes(Path.of("Inter-Variable.ttf"));
            exchange.getResponseHeaders().set("Content-Type", "font/ttf");
            exchange.sendResponseHeaders(200, fontBytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(fontBytes);
            os.close();
        });

        server.start();
        System.out.println("Server started on http://localhost:8080");
    }
}