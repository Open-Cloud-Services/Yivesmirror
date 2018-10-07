package de.opencloud.yivesmirror;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class ServerSoftware {
    public String size_human;
    public int size_bytes;
    public String file_name;
    public String date_human;
    public int date_epoch;
    public String mc_version;
    public String direct_link;
    public String grab_link;

    public InputStream download() throws IOException {
        return URI.create(direct_link).toURL().openConnection().getInputStream();
    }
}
