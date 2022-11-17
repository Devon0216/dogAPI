package za.co.nedj.app.nedj.catdogapi.service;

import org.mapstruct.factory.Mappers;
import za.co.nedj.app.nedj.catdogapi.Client.DogClientImpl;
import za.co.nedj.app.nedj.catdogapi.Mapper.DogMapper;
import za.co.nedj.app.nedj.catdogapi.model.Dog;
import za.co.nedj.app.nedj.catdogapi.model.DogDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;

@Stateless
public class DogService {

    @EJB
    private DataService dataService;
    @EJB
    private DogClientImpl dogClient;
    private final DogMapper dogMapper = Mappers.getMapper(DogMapper.class);

    public List<DogDTO> getDogBreeds(){
        List<Dog> dogs = dogClient.getDogBreeds();
        return dogMapper.getDogs(dogs);
    }

    public Optional<DogDTO> getDogByBreed(String dogBreedName) {
        Optional<Dog> dog = dogClient.getDogByBreedName(dogBreedName);
        return dog.map(x -> Optional.of(dogMapper.getDogDTOFromDog(dog.get()))
                .orElseGet(() -> new DogDTO()));
//        return Optional.of(dogMapper.getDogDTOFromDog(dog.get())) ;
    }


    public List<DogDTO> getAllDogs() {
        List<Dog> dogs = dataService.getAllDogs();
        return dogMapper.getDogs(dogs);
    }

    public DogDTO addDog(DogDTO dogDTO) {
        dataService.addDog(dogDTO);
        return dogDTO;
    }

}
