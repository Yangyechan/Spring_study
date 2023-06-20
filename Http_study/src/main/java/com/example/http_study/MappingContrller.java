package com.example.http_study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class MappingContrller {
    @RequestMapping(value = "/path", method = RequestMethod.POST)
    public String postPath() {
        log.info("POST /path");
        return "index";
    }

    @RequestMapping(
            value = "/path",
            method = {RequestMethod.PUT, RequestMethod.DELETE}
    )
    public String putOrDelete() {
        log.info("PUT or DELETE /path");
        return "index";
    }

    @RequestMapping(
            value = "/path",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE // 헤더에 consumes = JSON을 통해 JSON 해석 방식으로 함
    )                                                   // consumes를 추가했기에 JSON 파일을 요청해야함
    public String consumes() {
        log.info("Post /path Content-Type: application/json");
        return "index";
    }

    @RequestMapping(
            value = "/path",
            method = RequestMethod.POST,
            headers = "x-likelion=hello" // 헤더정보를 추가해 정보 보호
    )                                    // 개발자 책임은 500번대 에러뜸
    public String headerWith() {
        log.info("POST /path with x-likelion=hello");
        return "index";
    }

    @RequestMapping(
            value = "/path",
            method = RequestMethod.POST,
            headers = "x-likelion",
            params = "likelion=hello" //
    )
    public String params() {
        log.info("POST /path with parameter likelion2");
        return "index";
    }
}
