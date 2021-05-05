package dev.voidbit.lapiz;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Topic {
    @Id
    @GeneratedValue
    Long id;
}
