package com.shhatrat.nextbike.controller;


import com.shhatrat.nextbike.model.myApi.MInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping("/info")
    @ResponseBody
    MInfo info(){
        return new MInfo();
    }

}
