package com.pluralsight.week5;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    static String Url = "https://open.er-api.com/v6/latest/%s";
    static final HttpClient CLIENT = HttpClient.newHttpClient();

    public static void main(String[] args) {
        LOG.info("----------------");
        String currency = "CAD";

        HttpRequest request = HttpRequest.newBuilder(URI.create(Url.formatted(currency))).build();

        try {
            HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            LOG.error("Failed fetching", e);
        }
    }
}
