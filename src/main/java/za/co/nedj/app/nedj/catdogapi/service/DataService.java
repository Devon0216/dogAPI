package za.co.nedj.app.nedj.catdogapi.service;

import za.co.nedj.app.nedj.catdogapi.model.Dog;
import za.co.nedj.app.nedj.catdogapi.model.DogDTO;
import za.co.nedj.app.nedj.catdogapi.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Stateless
public class DataService {

    @PersistenceContext(name = "nfpePU")
    private EntityManager entityManager;

    private static final String DOG_GETALL_QUERY = "SELECT p FROM Dog p";
    private static final String USER_GETALL_QUERY = "SELECT p FROM Dog p";

//    public Optional<Dog> getDog(String dogName) {
//        Dog getDog = entityManager.find(Dog.class, dogName) ;
//        Optional<Dog> getOptionalDog = Optional.of(getDog);
//        return getOptionalDog;
//    }

    public List<Dog> getAllDogs(){
        TypedQuery<Dog> getAllDogsTypeQuery = entityManager.createQuery(DOG_GETALL_QUERY, Dog.class);
        return getAllDogsTypeQuery.getResultList();
    }

    public DogDTO addDog(DogDTO dogDTO) {
        entityManager.persist(dogDTO);
        return dogDTO;
    }
//
//    public Dog updateDog(Dog dog) {
//        entityManager.merge(dog);
//        return dog;
//    }
//
//    public Dog deleteDog(Long dogId) {
//        Dog dog = entityManager.find(Dog.class, dogId);
//        entityManager.remove(dog);
//        return dog;
//    }

    /** user
     *
     */
    public Optional<User> getUser(Long userId) {
        User getUser = entityManager.find(User.class, userId) ;
        Optional<User> getOptionalUser = Optional.of(getUser);
        return getOptionalUser;
    }

    public List<User> getAllUsers() {
        TypedQuery<User> getAllDogsTypeQuery = entityManager.createQuery(USER_GETALL_QUERY, User.class);
        return getAllDogsTypeQuery.getResultList();
    }

    public User addUser(User user) {
        entityManager.persist(user);
        return user;
    }

    public User updateUser(User user) {
        entityManager.merge(user);
        return user;
    }

    public User deleteUser(Long userId) {
        User user = entityManager.find(User.class, userId);
        entityManager.remove(user);
        return user;
    }
}
