package com.rest.pokedex;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {
    @GetMapping("/song")
    public String song(){
        return "I want to be the very best,\n" +
                "Like no one ever was.\n" +
                "To catch them is my real test,\n" +
                "To train them is my cause!\n" +
                "(I will travel across the land,\n" +
                "Searching far and wide.\n" +
                "Each Pokemon to understand\n" +
                "The power that's inside!)\n" +
                "Pokemon!\n" +
                "Gotta catch em' all!\n" +
                "It's you and me,\n" +
                "I know it's my destiny!\n" +
                "Pokemon!\n" +
                "Oh, you're my best friend,\n" +
                "In a world we must defend!\n" +
                "Pokemon!\n" +
                "Gotta catch em' all!\n" +
                "(A heart so true,\n" +
                "Our courage will pull us through!)\n" +
                "You teach me and I'll teach you,\n" +
                "Po-ke-mon!\n" +
                "Gotta catch em' all!\n" +
                "Gotta catch em' all!\n" +
                "Every challenge along the way,\n" +
                "With courage I will face!\n" +
                "I will battle every day,\n" +
                "To claim my rightful place!\n" +
                "Come with me, the time is right,\n" +
                "There's no better team!\n" +
                "Arm in arm, we'll win the fight,\n" +
                "It's always been our dream!\n" +
                "Pokemon!\n" +
                "Gotta catch em' all!\n" +
                "It's you and me,\n" +
                "I know it's my destiny!\n" +
                "Pokemon!\n" +
                "Oh, you're my best friend,\n" +
                "In a world we must defend!\n" +
                "Pokemon!\n" +
                "Gotta catch em' all!\n" +
                "(A heart so true,\n" +
                "Our courage will pull us through!)\n" +
                "You teach me and I'll teach you,\n" +
                "Po-ke-mon!\n" +
                "Gotta catch em' all!\n" +
                "Gotta catch em' all!\n" +
                "Gotta catch em' all!\n" +
                "Gotta catch em' all!\n" +
                "Gotta catch em' all!\n" +
                "Pokemon!\n" +
                "Gotta catch em' all!\n" +
                "It's you and me,\n" +
                "I know it's my destiny!\n" +
                "Pokemon!\n" +
                "Oh, you're my best friend,\n" +
                "In a world we must defend!\n" +
                "Pokemon!\n" +
                "Gotta catch em' all!\n" +
                "(A heart so true,\n" +
                "Our courage will pull us through!)\n" +
                "You teach me and I'll teach you,\n" +
                "Po-ke-mon!\n" +
                "Gotta catch em' all!\n" +
                "Gotta catch em' all!\n" +
                "Po-ke-mon!";
    }
}
