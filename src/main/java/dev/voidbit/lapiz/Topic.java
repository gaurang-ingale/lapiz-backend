package dev.voidbit.lapiz;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Topic {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue

    Long id;

    private String name;

    private String description;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "subjectId", nullable = true)
    private Subject subject;

    public Topic(Long id){
        this.id = id;
    }

    public Topic(String name) {
        this.name = name;
    }

    public Topic(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
