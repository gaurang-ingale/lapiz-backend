package dev.voidbit.lapiz;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Teacher {
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private String firstName;
    private String lastName;

    private void composeNameFromFirstAndLastNames(){
        this.name = this.firstName + " " + this.lastName;
    }

    private void seperateFirstAndLastNamesFromName(){
        String[] names = name.split(" ");
        this.firstName = names[0];
        this.lastName = names[names.length - 1];
    }

    public Teacher(String name) {
        this.name = name;
        seperateFirstAndLastNamesFromName();
    }

    public Teacher(Long id, String name){
        this.id = id;
        this.name = name;
        seperateFirstAndLastNamesFromName();
    }

    public Teacher(Long id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        composeNameFromFirstAndLastNames();
    }

    public Teacher(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        composeNameFromFirstAndLastNames();
    }
}
