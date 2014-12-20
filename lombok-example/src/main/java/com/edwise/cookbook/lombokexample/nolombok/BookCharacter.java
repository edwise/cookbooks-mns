package com.edwise.cookbook.lombokexample.nolombok;

import java.util.List;

public class BookCharacter {

    private String name;
    private String nickname;
    private int age;
    private List<String> powers;
    private String otherField;
    private String otherField2;
    private String otherField3;
    private String otherField4;

    private BookCharacter(String name, String nickname, int age, List<String> powers,
                          String otherField, String otherField2, String otherField3,
                          String otherField4) {
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.powers = powers;
        this.otherField = otherField;
        this.otherField2 = otherField2;
        this.otherField3 = otherField3;
        this.otherField4 = otherField4;
    }

    public static BookCharacterBuilder builder() {
        return new BookCharacterBuilder();
    }

    public static class BookCharacterBuilder {
        private String name;
        private String nickname;
        private int age;
        private List<String> powers;
        private String otherField;
        private String otherField2;
        private String otherField3;
        private String otherField4;

        BookCharacterBuilder() {
        }

        public BookCharacterBuilder name(String name) {
            this.name = name;
            return this;
        }

        public BookCharacterBuilder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public BookCharacterBuilder age(int age) {
            this.age = age;
            return this;
        }

        public BookCharacterBuilder powers(List<String> powers) {
            this.powers = powers;
            return this;
        }

        public BookCharacterBuilder otherField(String otherField) {
            this.otherField = otherField;
            return this;
        }

        public BookCharacterBuilder otherField2(String otherField2) {
            this.otherField2 = otherField2;
            return this;
        }

        public BookCharacterBuilder otherField3(String otherField3) {
            this.otherField3 = otherField3;
            return this;
        }

        public BookCharacterBuilder otherField4(String otherField4) {
            this.otherField4 = otherField4;
            return this;
        }

        public BookCharacter build() {
            return new BookCharacter(name, nickname, age, powers, otherField,
                    otherField2, otherField3, otherField4);
        }

        @Override
        public String toString() {
            return "CharacterBuilder{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "BookCharacter{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", powers=" + powers +
                ", otherField='" + otherField + '\'' +
                ", otherField2='" + otherField2 + '\'' +
                ", otherField3='" + otherField3 + '\'' +
                ", otherField4='" + otherField4 + '\'' +
                '}';
    }
}
