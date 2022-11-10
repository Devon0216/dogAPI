package za.co.nedj.app.nedj.catdogapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "DOGS")
public class Dog {
    @Id
    @Generated
    @Column(name = "DOG_ID")
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LIFE_SPAN")
    private String lifeSpan ;
    @Column(name = "ALT_NAME")
    private String alternativeName ;

    @ManyToMany(mappedBy = "dogs")
    private Set<User> users;
}