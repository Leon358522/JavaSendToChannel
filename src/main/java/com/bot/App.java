package main.java.com.bot;


import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.GenericUrl;
import com.google.gson.*;
import com.google.api.client.http.ByteArrayContent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

/**
 * Hello world!
 */
public final class App extends Libary{
    private App() {
    }
    private String channel = "";
    public Map<String, String> contentN = new HashMap<>();
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
            HttpContent content;
            String send =  l.getCommand()[0] + l.getAllMySongs().get("5");
            System.out.println(a.contentN);
            a.contentN.put("content",send);
            System.out.println(a.contentN);
            HttpHeaders h = new HttpHeaders();
            System.out.println(a.contentN.get("content"));
//            h.setContentMD5(send);
            HttpRequest request = r.buildPostRequest(url, content = ByteArrayContent.fromString("application/json", a.contentN.get("content")));
            request.getHeaders().setAuthorization(l.getAuthorization());
            HttpResponse response = request.execute();


        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            a.channel = args[0];
        } catch (Exception IndexOutOfBoundsException) {
        }
        //int channel = args[]


    }
}

