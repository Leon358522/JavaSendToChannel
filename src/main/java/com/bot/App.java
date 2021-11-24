package main.java.com.bot;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.gson.*;
import com.google.api.client.http.ByteArrayContent;

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

public final class App{

    private String channel = "";
    public Map<String, String> content = new HashMap<>();
    String[] addS = {"Lost without you Freya Ridings","Trouble's coming royal blood", "Monsoon 2020 Tokio Hotel", "Ottomatic oliver", "With or without you U2", "waiting Amber mark ", "Wandering star empire of the sun", "Can't hold me down GRiZ Tash neal", "It's my life No Doubt", "Our Demons The Glitch Mob", "FTW Lets Be Friends", "Memories (feat. Kid Cudi) David Guetta", "Halfway to nowhere Chelou", "Afraid The Neighbourhood"};
    String[] sI = {"22","15","17","25"};
    App() {}

    public Library createLibrary(String i) throws java.io.FileNotFoundException{
        BufferedReader reader = new BufferedReader(new FileReader(i));
        Gson gs = new Gson();
        Library j = gs.fromJson(reader, Library.class);
        j.setSource(i);
        return j;
    }

    public void SendToChannel(String[] SI, Library l, App a) throws java.io.IOException,InterruptedException{
        String urlS =  "https://discord.com/api/v9/channels/" + a.channel + "/messages";
        DiscordChannelUrl url = new DiscordChannelUrl(urlS);
        HttpRequestFactory r = new NetHttpTransport().createRequestFactory();
        HttpContent c ;
        for (String i: a.sI) {
            String send = "{\"content\": " + "\"" + l.getCommand()[0] + l.getAllMySongs().get(i) + "\"}";
            HttpRequest request = r.buildRequest("POST",url , c = ByteArrayContent.fromString("application/json", send));
            request.getHeaders().setAuthorization(l.getAuthorization());
            HttpResponse response = request.execute();
            TimeUnit.SECONDS.sleep(1);
        }
    }
    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        App a = new App();
        try {
            a.channel = args[0];
            a.sI = args[1].split(",");
        } catch (Exception IndexOutOfBoundsException) {
            a.channel = "443110011607187488";
            a.sI = new String[]{"22", "25"};
        }

        try {
            Library l = a.createLibrary("library.json");
            //l.listSongs(l.getAllMySongs());
            //a.SendToChannel(a.SI, l, a);
            l.addL(a.addS);
            l.listSongs(l.getAllMySongs());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

