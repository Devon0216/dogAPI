package za.co.nedj.app.nedj.catdogapi.Client;

import feign.Feign;
import feign.Logger;
import feign.Param;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import za.co.nedj.app.nedj.catdogapi.config.ApiConfig;
import za.co.nedj.app.nedj.catdogapi.model.Dog;

import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
public class DogClientImpl {



    private Map<String,String> getHeaderMap(){
        Map<String,String> headerMap = new HashMap<>();
        headerMap.put("x-api-key", ApiConfig.getDogApiKey());
        return headerMap;
    }

    public List<Dog> getDogs(){
        final DogClient dogClient = getDogClient();
        return  dogClient.findAllBreeds(getHeaderMap());
    }

    private DogClient getDogClient() {
        return Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(DogClientImpl.class))
                .logLevel(Logger.Level.FULL)
                .target(DogClient.class, "https://api.thedogapi.com/v1");
    }



}
