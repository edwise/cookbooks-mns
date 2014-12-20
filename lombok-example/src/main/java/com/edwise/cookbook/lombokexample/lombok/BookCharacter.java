package com.edwise.cookbook.lombokexample.lombok;

import lombok.ToString;
import lombok.experimental.Builder;

import java.util.List;

@Builder
@ToString(doNotUseGetters = true)
public class BookCharacter {

    private String name;
    private String nickname;
    private int age;
    private List<String> powers;
    private String otherField;
    private String otherField2;
    private String otherField3;
    private String otherField4;
}
