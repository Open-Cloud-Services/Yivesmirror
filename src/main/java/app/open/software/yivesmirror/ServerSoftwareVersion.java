package app.open.software.yivesmirror;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.MessageFormat;

public class ServerSoftwareVersion {
    private String version;
    private String name;

    ServerSoftwareVersion(String name, String version) {
        this.name = name;
        this.version = version;
    }

    /**
     * Gets the Server software for version and name
     *
     * @return the serversoftware
     * @throws IOException
     * @throws InterruptedException
     */
    public ServerSoftware getServerSoftware() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(MessageFormat.format("https://yivesmirror.com/api/file/{0}/{1}", this.name, this.version)))
                .build();

        return Yivesmirror.gson.fromJson(Yivesmirror.http.send(request, HttpResponse.BodyHandlers.ofString()).body(), ServerSoftware.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
