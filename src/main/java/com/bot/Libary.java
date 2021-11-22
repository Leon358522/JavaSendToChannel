package main.java.com.bot;

import java.util.Map;

public class Libary {
    private Map<String, String> allMySongs;
    private String[] command;
    private String authorization;

    public Libary(){}

    public Map<String, String> getAllMySongs() { return allMySongs; }
    public void setAllMySongs(Map<String, String> value) { this.allMySongs = value; }

    public void add(String j){
        allMySongs.put(String.valueOf((allMySongs.size()+1)), j);
    }

    public void listSongs(Map<String,String> map){
        for (Map.Entry e : map.entrySet()) {
            System.out.println(e.getKey() + "/" + e.getValue());
        }
    }

    public String[] getCommand() { return command; }
    public void setCommand(String[] value) { this.command = value; }
    public void commands(){
        for (String i : command) { System.out.println(i); }
    }

    public String getAuthorization() { return authorization; }
    public void setAuthorization(String value) { this.authorization = value; }
}

