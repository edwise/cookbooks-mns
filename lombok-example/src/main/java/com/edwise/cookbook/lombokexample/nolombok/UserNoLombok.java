package com.edwise.cookbook.lombokexample.nolombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserNoLombok {

    private long id;
    private String name;
    private String surname;
    private String phone;
    private LocalDate birthday;
    private int type;
}
