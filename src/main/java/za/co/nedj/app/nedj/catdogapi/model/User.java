package za.co.nedj.app.nedj.catdogapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "User")
@Entity
public class User {
    @Id
    @Generated
    @Column(name = "USER_ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "FAVOURITE_DOG_BREED")
    private String favouriteDogBreed;

    @ManyToMany
    @JoinTable(
            name = "USER_DOGS",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "DOG_ID"))
    private List<Dog> dogs;


}
