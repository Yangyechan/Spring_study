package com.example.http_study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class HeaderController {
    @PostMapping("/header-one")
    public String getHeader(@RequestHeader("x-likelion") String header) {
        log.info("POST /header-one header: " + header);
        return "index";
    }

    @PostMapping("header-optional")
    public String getHeaderOptional(
            @RequestHeader(value = "x-likelion", required = false) // required = false는 header의 값이 null일 때도 호출
            String header
    ) {
        log.info("POST /header-optional header: " + header);
        return "index";
    }

    // header-type으로 들어온 HTTP 요청에 대하여
    // 헤더 중 x-likelion-int가 있으면 Integer에 할당
    @PostMapping("/header-type")
    public String getHeaderInteger(
            @RequestHeader(value = "x-likelion-int")
            Integer header
    ) {
        log.info("POST /header-type header: " + header);
        return "index";
    }

    @PostMapping("/header-all")
    public String getHeaderAll(
            @RequestHeader
            MultiValueMap<String, String> headerMap
    ) {
        for (Map.Entry<String, List<String>> entry : headerMap.entrySet()) {
            log.info(String.format(
                    "%s: %s", entry.getKey(), entry.getValue()));
        }
        return "index";
    }
}
