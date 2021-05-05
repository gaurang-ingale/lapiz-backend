package dev.voidbit.lapiz;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Topic {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue
    Long id;

    public Topic(){

    }

    public Topic(Long id){
        this.id = id;
    }
}
