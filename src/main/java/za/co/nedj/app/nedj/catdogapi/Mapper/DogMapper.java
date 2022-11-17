package za.co.nedj.app.nedj.catdogapi.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import za.co.nedj.app.nedj.catdogapi.model.Dog;
import za.co.nedj.app.nedj.catdogapi.model.DogDTO;

import java.util.List;
import java.util.Optional;

@Mapper
public interface DogMapper {
    @Mapping(target="id", source="id")
    @Mapping(target="name", source="name")
    @Mapping(target="lifeSpan", source="lifeSpan")
    @Mapping(target="alternativeName", source="alternativeName")
    @Mapping(target="users", source="users")
    DogDTO getDogDTOFromDog(Dog dog);

    @Mapping(target="id", source="id")
    @Mapping(target="name", source="name")
    @Mapping(target="lifeSpan", source="lifeSpan")
    @Mapping(target="alternativeName", source="alternativeName")
    @Mapping(target="users", source="users")
    Dog getDogFromDogDTO(DogDTO dogDTO);

    List<DogDTO> getDogs(List<Dog> dogs);

}
