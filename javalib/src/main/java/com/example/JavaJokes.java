package com.example;

import java.util.Random;

public class JavaJokes {
    public static String getJoke() {
        String jokes[]={"Can a kangaroo jump higher than a house? Of course, a house doesn’t jump at all","My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away" ,"I heard women love a man in uniform. Can’t wait to start working at McDonalds." ,"It is so cold outside I saw a politician with his hands in his own pockets." ,"It’s cleaning day today. I’ve already polished off a whole chocolate bar.","Famous last words of a postman: What a lovely dog you have!"
              };

        int idx = new Random().nextInt(jokes.length);
        return jokes[idx];

    }
}
