package ua.ithillel.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpClient.newHttpClient;

public class RandomHttpService {
    public int getNumber(int min, int max) {
        int number = 0;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI
                            ("http://www.randomnumberapi.com/api/v1.0/random?min="
                                    + min + "&max=" + max + "&count=1"))
                    .GET()
                    .build();
            HttpClient client = newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String str = response.body();
            str = str.substring(1, response.body().length() - 1);
            number = Integer.parseInt(str);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return number;
    }
}
