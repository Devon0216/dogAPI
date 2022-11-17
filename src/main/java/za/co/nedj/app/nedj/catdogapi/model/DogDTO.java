package za.co.nedj.app.nedj.catdogapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DogDTO {
    private Long id;
    private String name;
    private String lifeSpan ;
    private String alternativeName ;
    private List<UserDTO> users;
}
