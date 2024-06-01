import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscarTasaDeCambio {
    public static double generarTasa (String moneda1, String moneda2) throws IOException, InterruptedException {
        // instancia de HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/6c0fc8eb300d1f46c477ee18/pair/"+moneda1+"/"+moneda2))
                .GET()
                .build();
        // instancia de HttpClient
        HttpClient client = HttpClient.newHttpClient();
        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Obtener el cuerpo de la respuesta
        String responseBody = response.body();
        // Convertir el JSON a un objeto JsonObject
        JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
        // Obtener el valor de "conversion_rate" como un double
        double conversionRate = jsonObject.get("conversion_rate").getAsDouble();
        // Imprimir el valor de "conversion_rate"
        return conversionRate;
    }
}