package main.java.com.bot;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import com.google.gson.stream.JsonWriter;
import org.jetbrains.annotations.NotNull;

import javax.imageio.IIOException;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;


public class Library implements InstanceCreator<Library> {
    private Map<String, String> allMySongs;
    private String[] command;
    private String authorization;
    private static Library instance;
    private static Gson gs = new Gson();
    private static Gson gb = new GsonBuilder().create();
    private String source;

    private Library(){
    }

    @Override
    public Library createInstance(Type type) {
        if(Library.instance == null){
            return Library.instance = new Library();
        }
        return Library.instance;
    }


    public Map<String, String> getAllMySongs() { return allMySongs; }
    public void setAllMySongs(Map<String, String> value) { this.allMySongs = value; }

    public void add(String j)throws java.io.IOException{
        for (Map.Entry e :allMySongs.entrySet()) {
            System.out.println(j.equalsIgnoreCase(String.valueOf(e.getValue())));
            if (j.equalsIgnoreCase(String.valueOf(e.getValue()))){return;}
        }
        allMySongs.put(String.valueOf((allMySongs.size()+1)), j);
        this.toJson();
    }

    public void addL(String @NotNull [] i)  throws java.io.IOException {
        for (String j : i) { this.add(j);
        }
    }


    public void listSongs(@NotNull Map<String,String> map){
        for (Map.Entry e : map.entrySet()) {
            System.out.println(e.getKey() + "/" + e.getValue());
        }
    }

    public Library getInstance() {
        return instance;
    }

    String fileName = "library.json";
    Path path = Paths.get(fileName);

    void toJson() throws java.io.IOException{
        try (JsonWriter writer = new JsonWriter(Files.newBufferedWriter(path,
            StandardCharsets.UTF_8))) {
        writer.setIndent("  ");
        writer.beginObject();
        writer.name("allMySongs");
        writer.beginObject();
            for (Map.Entry e: allMySongs.entrySet()) {
                writer.name(String.valueOf(e.getKey())).value(String.valueOf(e.getValue()));

            }
        writer.endObject();
        writer.name("command");
        writer.beginArray();
            for (String i: command) {
                writer.value(i);
            }
        writer.endArray();
            writer.name("authorization").value(authorization);
        writer.endObject();
    }}

    public String[] getCommand() { return command; }
    public void setCommand(String[] value) { this.command = value; }
    public void commands(){
        for (String i : command) { System.out.println(i); }
    }

    public String getAuthorization() { return authorization; }
    public void setAuthorization(String value) { this.authorization = value; }

    public void setSource(String i){
        this.source = i;
    }

}

