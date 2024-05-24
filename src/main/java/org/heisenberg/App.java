package org.heisenberg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * Hello world!
 */
public class App {


    public InputStream getInputStream(String path) throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(path);
        if (is == null) {
            throw new FileNotFoundException(path + " cannot be opened because it does not exist");
        }
        return is;
    }


    public static void main(String[] args) throws IOException {
        URL url = new URL("file:./pom.xml");
        URLConnection urlConnection = url.openConnection(Proxy.NO_PROXY);

        InputStream inputStream = urlConnection.getInputStream();
        byte[] bytes = inputStream.readAllBytes();
        String s = new String(bytes);
        System.out.println(s);
    }
}
