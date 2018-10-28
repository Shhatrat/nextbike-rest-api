package com.shhatrat.nextbike;

import com.shhatrat.nextbike.model.DataHolder;
import com.shhatrat.nextbike.model.myApi.MCountry;
import com.shhatrat.nextbike.model.myApi.MInfo;
import io.reactivex.Single;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {

    @GetMapping("/hello")
    MInfo info(){
        return new MInfo();
    }


    @GetMapping("/country/all")
    Single<List<MCountry>> getAllCountries(){
       return   DataHolder
               .getAllData()
               .map(m ->
                       (m.getCountryList().stream()
                               .map(MCountry::new)
                       ).collect(Collectors.toList())
               );
    }

    @GetMapping("/country/{nameFromUser}")
    Single<List<MCountry>> getAllCountries(@PathVariable String nameFromUser){
        return   DataHolder
                .getAllData()
                .map(m ->
                        (m.getCountryList().stream().filter( n -> n.getName().toLowerCase().replace("%20", " ").equals(nameFromUser.toLowerCase()))
                                .map(MCountry::new)
                        ).collect(Collectors.toList())
                );
    }

}
