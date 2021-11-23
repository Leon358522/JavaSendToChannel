package main.java.com.bot;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.gson.*;
import com.google.api.client.http.ByteArrayContent;

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Hello world!
 */
public final class App extends Libary{
    private App() {
    }
    private String channel = "";
    public Map<String, String> content = new HashMap<>();
    int[] SI = {22,15,17,25};
    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        App a = new App();
        a.channel = "443110011607187488";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("libary.json"));
            Gson gs = new Gson();
            Libary l = gs.fromJson(reader, Libary.class);
            //l.listSongs(l.getAllMySongs());
            String urlS =  "https://discord.com/api/v9/channels/" + a.channel + "/messages";
            DiscordChannelUrl url = new DiscordChannelUrl(urlS);
            HttpRequestFactory r = new NetHttpTransport().createRequestFactory();
            HttpContent c ;
            for (int i: a.SI) {
                String send = "{\"content\": " + "\"" + l.getCommand()[0] + l.getAllMySongs().get(String.valueOf(i)) + "\"}";
                System.out.println(a.content.get("content"));
                HttpRequest request = r.buildRequest("POST",url , c = ByteArrayContent.fromString("application/json", send));
                request.getHeaders().setAuthorization(l.getAuthorization());
                HttpResponse response = request.execute();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            a.channel = args[0];
        } catch (Exception IndexOutOfBoundsException) {
        }


    }
}
