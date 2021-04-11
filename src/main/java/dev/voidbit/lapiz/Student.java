package dev.voidbit.lapiz;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue
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

    public Student(String name){
        this.name = name;
        seperateFirstAndLastNamesFromName();
    }

    public Student(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        composeNameFromFirstAndLastNames();
    }

    public Student(Long id, String name){
        this.id = id;
        this.name = name;
        seperateFirstAndLastNamesFromName();
    }

    public Student(Long id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        composeNameFromFirstAndLastNames();
    }

    public void setName(String name){
        this.name = name;
        seperateFirstAndLastNamesFromName();
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
        composeNameFromFirstAndLastNames();
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
        composeNameFromFirstAndLastNames();
    }
}
