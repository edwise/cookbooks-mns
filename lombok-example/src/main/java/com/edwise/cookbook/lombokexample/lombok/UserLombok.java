package com.edwise.cookbook.lombokexample.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserLombok {

    private long id;

    @NonNull
    private String name;

    private String surname;
    private String phone;
    private LocalDate birthday;
    private int type;
}
