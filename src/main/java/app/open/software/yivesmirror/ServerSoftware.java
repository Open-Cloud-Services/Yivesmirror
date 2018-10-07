package app.open.software.yivesmirror;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * Model class for Json
 */
public class ServerSoftware {
    public String size_human;
    public int size_bytes;
    public String file_name;
    public String date_human;
    public int date_epoch;
    public String mc_version;
    public String direct_link;
    public String grab_link;

    /**
     * Helper method to download / get the input stream
     *
     * @return the InputStream of the connection
     * @throws IOException
     */
    public InputStream download() throws IOException {
        return URI.create(direct_link).toURL().openConnection().getInputStream();
    }
}
