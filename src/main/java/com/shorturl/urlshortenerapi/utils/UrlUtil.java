package com.shorturl.urlshortenerapi.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlUtil {
    private UrlUtil() {
    }

     public static String getBaseUrl(String url) throws MalformedURLException {
        URL reqUrl = new URL(url);
        String protocol = reqUrl.getProtocol();
        String host = reqUrl.getHost();
        int port = reqUrl.getPort();

        if (port == -1) {
            return String.format("%s://%s/", protocol, host);
        } else {
            return String.format("%s://%s:%d/", protocol, host, port);
        }

    }
    
    public static boolean isValidUrl(String url) {
    	try {
    	 String pattern =  "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    	 Pattern patt = Pattern.compile(pattern);
         Matcher matcher = patt.matcher(url);
         return matcher.matches();
    	} catch (RuntimeException e) {
    	        return false;
    	}       
    }
}
