package com.mahmoodb.spikes.cm.controller;

import com.mahmoodb.spikes.cm.model.Info;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(tags = "Info", description = "API to query application information")
public class InfoController {

    private final Logger log = LoggerFactory.getLogger(InfoController.class);

    @Value("${com.mahmoodb.app.title}")
    private String appTitle;
    @Value("${com.mahmoodb.app.build.version}")
    private String appVersion;

    @ApiOperation("Retrieve application information")
    @ApiResponses(value = {
      @ApiResponse(code = 200, message = "OK"),
      @ApiResponse(code = 400, message = "Bad Request"),
      @ApiResponse(code = 404, message = "Information Not Found."),
      @ApiResponse(code = 500, message = "Internal Server Error.")
    })
    @RequestMapping(value = "/info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Info> info() {
        Info info = new Info(appTitle, appVersion);
        log.info("/info api called to return - name: {}, version: {}", appTitle, appVersion);
        return new ResponseEntity<Info>(info, HttpStatus.OK);
    }
}