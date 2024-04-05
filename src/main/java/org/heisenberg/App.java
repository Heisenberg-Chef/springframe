package org.heisenberg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

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
        App app = new App();

        InputStream inputStream = app.getInputStream("./App.class");

        System.out.println(inputStream);
    }
}
