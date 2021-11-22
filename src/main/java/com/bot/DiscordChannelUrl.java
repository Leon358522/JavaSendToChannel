package main.java.com.bot;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.*;
import com.google.api.client.util.Key;

public class DiscordChannelUrl extends GenericUrl {

    public DiscordChannelUrl(String encodeUrl){
        super(encodeUrl);
    }

}
