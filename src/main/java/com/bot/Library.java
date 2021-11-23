package main.java.com.bot;


import com.google.gson.Gson;
import com.google.gson.InstanceCreator;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.util.Map;


public class Library implements InstanceCreator<Library> {
    private Map<String, String> allMySongs;
    private String[] command;
    private String authorization;
    private static Library instance;
    private static Gson gs = new Gson();
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

    public void add(String j){
        for (Map.Entry e : allMySongs.entrySet()) {
            if (allMySongs.get(e) == j){return;}
        }
        allMySongs.put(String.valueOf((allMySongs.size()+1)), j);
    }

    public void addL(String @NotNull [] i){
        for (String j : i) { this.add(j);
        }
        gs.toJson(this.source);
    }


    public void listSongs(@NotNull Map<String,String> map){
        for (Map.Entry e : map.entrySet()) {
            System.out.println(e.getKey() + "/" + e.getValue());
        }
    }

    public Library getInstance() {
        return instance;
    }

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

