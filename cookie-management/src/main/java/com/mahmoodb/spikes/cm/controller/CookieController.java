package com.mahmoodb.spikes.cm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "Cookie", description = "API to query for cookies")
public class CookieController {
    private static final Logger log = LoggerFactory.getLogger(CookieController.class);

    @ApiOperation("Read cookie for username")
    @ApiResponses(value = {
      @ApiResponse(code = 200, message = "OK"),
      @ApiResponse(code = 400, message = "Bad Request"),
      @ApiResponse(code = 404, message = "Cookie Not Found."),
      @ApiResponse(code = 500, message = "Internal Server Error.")
    })
    @RequestMapping(value = "/cookie", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> cookie(@CookieValue(value = "token", defaultValue = "mahmoodb") String username) {
        String name = String.format("Hello '%s'", username);

        log.info("/cookie api called to return - token: {}", name);
        return new ResponseEntity<String>(name, HttpStatus.OK);
    }

    @ApiOperation("Change cookie username")
    @ApiResponses(value = {
      @ApiResponse(code = 200, message = "OK"),
      @ApiResponse(code = 400, message = "Bad Request"),
      @ApiResponse(code = 500, message = "Internal Server Error.")
    })
    @RequestMapping(value = "/cookie/update", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestParam(name = "token", required = true) String username) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.SET_COOKIE, "token=" + username);

        String cookie = headers.get(HttpHeaders.SET_COOKIE).toString();
        String message = String.format("New token '%s'", username);
        log.info("/cookie api called to update - token: {}", cookie);
        return new ResponseEntity<String>(message, headers, HttpStatus.OK);
    }
}
