package de.opencloud.yivesmirror;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Yivesmirror {
    static HttpClient http;
    static Gson gson;

    /**
     * Initialize the Yivesmirror API
     */
    public Yivesmirror() {
        this.http = HttpClient.newHttpClient();
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public List<ServerSoftwareName> getServerSoftwareNames() throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://yivesmirror.com/api/list/all"))
                .build();

        return Arrays.stream(this.gson.fromJson(this.http.send(request, HttpResponse.BodyHandlers.ofString()).body(), String[].class))
        .map(ServerSoftwareName::new)
        .collect(Collectors.toList());
    }

    public ServerSoftware getServerSoftwareFromNameAndVersion(String name, String version) throws IOException, InterruptedException {
        ServerSoftwareVersion serverSoftwareVersion = new ServerSoftwareVersion(name, version);

        return serverSoftwareVersion.getServerSoftware();
    }
}
