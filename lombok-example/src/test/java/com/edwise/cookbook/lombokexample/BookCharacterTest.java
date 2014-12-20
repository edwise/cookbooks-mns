package com.edwise.cookbook.lombokexample;

import com.edwise.cookbook.lombokexample.lombok.BookCharacter;
import org.junit.Test;

import java.util.Arrays;

public class BookCharacterTest {

    @Test
    public void testBookCharacterLombokedCreateWithBuilder() {
        BookCharacter bookCharacter =
                BookCharacter.builder()
                        .name("Aragorn")
                        .nickname("Strider")
                        .age(89)
                        .powers(Arrays.asList("1111", "22222"))
                        .otherField("111")
                        .otherField2("wgtqwgh")
                        .otherField3("sdhgqwh")
                        .otherField4("hwqerew").build();

        System.out.println(bookCharacter.toString());
    }

    @Test
    public void testBookCharacterNotLombokedCreateWithBuilder() {
        com.edwise.cookbook.lombokexample.nolombok.BookCharacter bookCharacter =
                com.edwise.cookbook.lombokexample.nolombok.BookCharacter.builder()
                        .name("Aragorn")
                        .nickname("Strider")
                        .age(89)
                        .powers(Arrays.asList("1111", "22222"))
                        .otherField("111")
                        .otherField2("wgtqwgh")
                        .otherField3("sdhgqwh")
                        .otherField4("hwqerew").build();

        System.out.println(bookCharacter.toString());
    }
}
