package rollingHash;

import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.HashMap;

public class TestPDFShift {
    private static final String API_KEY = "api:f47c2ced61b0465388b46e445b8aea01";

    public static void main(String args[]) throws Exception {
        var jsonObject = new HashMap<>();
        jsonObject.put("source","https://trial.fin360.in/");
        jsonObject.put("sandbox", true);
        var httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api.pdfshift.io/v3/convert/pdf"))
                .timeout(Duration.ofSeconds(20))
                .header("Content-Type", "application/json")
                .header("Authentication", "Basic " + API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString()))
                .build();

        var httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofInputStream());

        var statusCode = response.statusCode();
        if (statusCode == 200 || statusCode == 201) {
            // Save the file locally
            var targetFile = new File("src/main/resources/timeline-near-future.pdf");
            Files.copy(response.body(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } else {
            System.out.println("not able to process");
        }
    }
}

