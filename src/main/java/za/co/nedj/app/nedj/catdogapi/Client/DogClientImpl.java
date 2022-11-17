package za.co.nedj.app.nedj.catdogapi.Client;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import za.co.nedj.app.nedj.catdogapi.config.ApiConfig;
import za.co.nedj.app.nedj.catdogapi.model.Dog;

import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Stateless
public class DogClientImpl {
    private Map<String,String> getHeaderMap(){
        Map<String,String> headerMap = new HashMap<>();
        headerMap.put("x-api-key", ApiConfig.getDogApiKey());
        return headerMap;
    }

    private DogClient getDogClient() {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger(DogClientImpl.class))
                .logLevel(Logger.Level.FULL)
                .target(DogClient.class, "https://api.thedogapi.com/v1");
    }

    public List<Dog> getDogBreeds(){
        final DogClient dogClient = getDogClient();
        return  dogClient.findAllBreeds(getHeaderMap());
    }

    public Optional<Dog> getDogByBreedName(String dogBreedName){
        final DogClient dogClient = getDogClient();
        return  dogClient.findByBreedName(dogBreedName, getHeaderMap())
                .stream().findFirst();
    }


}
