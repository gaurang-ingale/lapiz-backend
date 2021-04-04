package dev.voidbit.lapiz;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Subject {
    private Long id;
    private String name;

    public Subject(String name){
        this.name = name;
    }
}
