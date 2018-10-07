package de.opencloud.yivesmirror;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ServerSoftwareName {
    private String name;

    ServerSoftwareName(String name) {
        this.name = name;
    }

    public List<ServerSoftwareVersion> getVersions() throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(MessageFormat.format("https://yivesmirror.com/api/list/{0}", this.name)))
                .build();

        return Arrays.asList(Yivesmirror.gson.fromJson(Yivesmirror.http.send(request, HttpResponse.BodyHandlers.ofString()).body(), String[].class))
                .stream()
                .map(this::toVersion)
                .collect(Collectors.toList());
    }

    private ServerSoftwareVersion toVersion(String version) {
        return new ServerSoftwareVersion(this.name, version);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
