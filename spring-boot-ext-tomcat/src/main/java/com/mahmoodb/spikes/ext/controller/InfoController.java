package com.mahmoodb.spikes.ext.controller;

import com.mahmoodb.spikes.ext.model.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    private final Logger log = LoggerFactory.getLogger(InfoController.class);

    @Value("${com.mahmoodb.app.title}")
    private String appTitle;
    @Value("${com.mahmoodb.app.build.version}")
    private String appVersion;

    @RequestMapping(value = "/info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Info> info() {
        Info info = new Info(appTitle, appVersion);
        log.info("/info api called to return - name: {}, version: {}", appTitle, appVersion);
        return new ResponseEntity<Info>(info, HttpStatus.OK);
    }
}