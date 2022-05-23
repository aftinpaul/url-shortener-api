package com.shorturl.urlshortenerapi.utils;


public class ShorteningUtil {
    
    public static final String ALPHABET = "Mheo9PI2qNs5Zpf80TBn7lmRbtQ4YKXHvwAEWxuzdra316OJigGLSVUCyFjkDc";
    public static final int BASE = ALPHABET.length();
    public static final long ID_ADD_VALUE=100000;
    
    private ShorteningUtil() {}

   //converting the id into a string of randomized alphabets
    public static String idToStr(Long num) {
    	//adding a constant to id to start at 5 characters
    	num+=ID_ADD_VALUE;
        StringBuilder str = new StringBuilder();
        while (num > 0) {
            str.insert(0, ALPHABET.charAt((int) (num % BASE)));
            num = num / BASE;
        }
        return str.toString();
    }

    //re-converting the randomized alphabets to the id value for persistence
    public static Long strToId(String str) {
        Long num = 0L;
        for (int i = 0; i < str.length(); i++) {
            num = num * BASE + ALPHABET.indexOf(str.charAt(i));
        }
        //subtracting the constant value
        return num-ID_ADD_VALUE;
    }

    

}
