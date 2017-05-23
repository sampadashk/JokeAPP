package com.example;

import java.util.Random;

public class JavaJokes {
    public static String getJoke() {
        String jokes[]={"You know you're ugly when it comes to a group picture and they hand you the camera."
                ,"Can a kangaroo jump higher than a house? Of course, a house doesn’t jump at all","Team work is important; it helps to put the blame on someone else.","You're not fat, you're just... easier to see.","My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away" ,"I heard women love a man in uniform. Can’t wait to start working at McDonalds." ,"It is so cold outside I saw a politician with his hands in his own pockets." ,"It’s cleaning day today. I’ve already polished off a whole chocolate bar.","A recent study has found that women who carry a little extra weight live longer than the men who mention it.","Famous last words of a postman: What a lovely dog you have!","I used to think I was indecisive, but now I'm not too sure."
              };

        int idx = new Random().nextInt(jokes.length);
        return jokes[idx];

    }
}
