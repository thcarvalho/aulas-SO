package controllers;

import java.io.IOException;

public interface IFileController {
    void read(String path, String name) throws IOException;
}
