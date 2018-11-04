package com.shhatrat.nextbike.controller;

import com.shhatrat.nextbike.model.DataHolder;
import com.shhatrat.nextbike.model.myApi.city.FullCity;
import com.shhatrat.nextbike.model.myApi.city.MinimalCity;
import com.shhatrat.nextbike.model.myApi.point.MinimalPlace;
import com.shhatrat.nextbike.model.original.City;
import com.shhatrat.nextbike.model.original.Place;
import io.reactivex.Single;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CityController {

    @GetMapping("city/{cityUid}/minimal")
    Single<MinimalCity> getMinimalCity(
            @PathVariable Integer cityUid){
        return   DataHolder
                .getCity(cityUid)
                .map(MinimalCity::new);
    }

    @GetMapping("city/{cityUid}/full")
    Single<FullCity> getFullCity(
            @PathVariable Integer cityUid){
        return   DataHolder
                .getCity(cityUid)
                .map(FullCity::new);
    }

    @GetMapping("city/{cityUid}/places")
    Single<List<MinimalPlace>> getPlacesOfCity(
            @PathVariable Integer cityUid,
            @RequestParam(value = "items", required = false, defaultValue = "500") int items,
            @RequestParam(value = "skip", required = false, defaultValue = "0") int skip){
        return   DataHolder
                .getCity(cityUid)
                .map(City::getPlaceList).map(ee -> ee.stream().map(MinimalPlace::new)
                        .skip(skip)
                        .limit(items)
                        .collect(Collectors.toList()));
    }

    @GetMapping("city/{cityUid}/nearestPlaces")
    Single<List<MinimalPlace>> getNearestPlacesOfCity(
            @PathVariable Integer cityUid,
            @RequestParam(value = "items", required = false, defaultValue = "500") int items,
            @RequestParam(value = "skip", required = false, defaultValue = "0") int skip,
            @RequestParam(value = "lat", required = true, defaultValue = "0") double lat,
            @RequestParam(value = "lng", required = true, defaultValue = "0") double lng){
        return   DataHolder
                .getCity(cityUid)
                .map(City::getPlaceList).map(ee -> ee.stream()
                        .sorted((place, place2) -> Place.compareDistance(place, place2, lat, lng))
                        .map(MinimalPlace::new)
                        .skip(skip)
                        .limit(items)
                        .collect(Collectors.toList()));
    }
}
