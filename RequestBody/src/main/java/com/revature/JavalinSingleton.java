package com.revature;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.Javalin;

/**
 * Background: A json string representing a song will be sent in this POST request with the following fields: 
 *      songName, artistName
 */
public class JavalinSingleton {

    public static Javalin getInstance(){
        Javalin app = Javalin.create();
        
        /**
         * problem1: retrieve the song object from the request body and return the artist name.
         * 
         * Note: Please refer to the "RequestBody.MD" file for more assistance if needed.
         */
        app.post("/problem1", ctx -> {
                //implement logic here
                String jsonString = ctx.body();

                ObjectMapper om = new ObjectMapper();
                Song song = om.readValue(jsonString, Song.class);
                ctx.result(song.getArtistName());
        });

        /**
         * problem2: retrieve the song object from the request body...
         *      1. update the artist in the song object to "Beatles"
         *      2. return the updated song object in the response body
         * 
         * Note: Please refer to the "RequestBody.MD" file for more assistance if needed.
         */
        app.post("/problem2", ctx -> {
               //implement logic here
               String jsonString2 = ctx.body();
               ObjectMapper om2 = new ObjectMapper();
               Song song2 = om2.readValue(jsonString2, Song.class);
               song2.artistName("Beatles");

               String jsonReturned = om2.writeValueAsString(song2);
               ctx.result(jsonReturned);

        });


        return app;
    }
    
}
