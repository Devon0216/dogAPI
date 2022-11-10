package za.co.nedj.app.nedj.catdogapi.Client;

import feign.HeaderMap;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import za.co.nedj.app.nedj.catdogapi.model.Dog;

import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public interface DogClient {
    @RequestLine("GET /{dogName}")
    Dog findByBreedName(@Param("dogName")  String dogName, @HeaderMap Map<String,String> mapHeader);

    @RequestLine("GET /breeds")
    List<Dog> findAllBreeds(@HeaderMap Map<String,String> mapHeader);

}
