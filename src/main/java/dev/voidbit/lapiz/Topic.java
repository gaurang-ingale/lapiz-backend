package dev.voidbit.lapiz;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Topic {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue
    Long id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "subjectId", nullable = false)
    private Subject subject;

    public Topic(){
        this.subject = new Subject();
    }

    public Topic(Long id){
        this.id = id;
        this.subject = new Subject();
    }
}
