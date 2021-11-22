package main.java.com.bot;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;

public class Test {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("libary.json"));
            Gson gs = new Gson();
            Libary l = gs.fromJson(reader, Libary.class);
            System.out.println(l.getCommand()[0]);
        } catch (Exception FileNotFoundException){

        }
    }
}
