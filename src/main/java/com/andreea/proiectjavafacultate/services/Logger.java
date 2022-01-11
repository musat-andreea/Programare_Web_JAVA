package com.andreea.proiectjavafacultate.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {
    BufferedWriter wr;
    public Logger(String path) throws IOException {
        wr = new BufferedWriter(new FileWriter(path, true));
    }

    public void write(String text) throws IOException {
        Date d = new Date();
        wr.write("{" + Thread.currentThread().getName() + "} " + " [" + d + "] " + text + "\n"); // write string
        wr.flush();
    }

    public void close() throws IOException {
        wr.close();
    }

}