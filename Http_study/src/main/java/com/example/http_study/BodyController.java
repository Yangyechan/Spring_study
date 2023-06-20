package com.example.http_study;

import com.example.http_study.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
//@Controller
@RestController // HTML 파일을 못쓴다
public class BodyController {
    // '/body'로 요청이 들어왔을 때 ResponseDto 데이터를 표현한 json응답을 반환하는 메소드
    /*
    @PostMapping("/body")
    public @ResponseBody ResponseDto body(@RequestBody ArticleDto requestDto) {
        // ResponseDto 타입의 객체 반환, 반환 형태는 http응답의 Body임
        log.info(requestDto.toString());
        // ArticleDto 타입의 객체를 인자로 받아 로그로 출력
        ResponseDto response = new ResponseDto();
        response.setStatus(200);
        response.setMessage("success");
        return response;
    }

     */

    @PostMapping("/body")
    //@ResponseBody
    public ResponseDto body(
            @RequestBody // HTTP의 바디를 읽어오는 방법
            ArticleDto dto
    ) {
        log.info(dto.toString());
        ResponseDto response = new ResponseDto();
        response.setStatus(200);
        response.setMessage("success");
        return response;
    }

    @PostMapping("/body-2")
    //@ResponseBody
    public ResponseDto body2(
            @RequestBody
            WriterDto dto
    ) {
        log.info(dto.toString());
        ResponseDto response = new ResponseDto();
        response.setStatus(200);
        response.setMessage("success");
        return response;
    }

    @PostMapping("/body-3")
    //@ResponseBody
    public ResponseDto body3(
            @RequestBody
            ArticleWithCommentsDto dto
    ) {
        log.info("POST /3" + dto.toString());
        ResponseDto response = new ResponseDto();

        return response;
    }

    @PostMapping("/body-4")
    //@ResponseBody
    public ResponseDto body4(
            @RequestBody
            ArticleComplexDto dto
    ) {
        log.info(dto.toString());
        ResponseDto response = new ResponseDto();
        response.setMessage("success");
        response.setStatus(200);
        return response;
    }

    @PostMapping("/entity")
    //@ResponseBody
    public ResponseEntity<ResponseDto> entity(
            @RequestBody
            ArticleDto dto
    ) {
        log.info("POST /body" + dto.toString());
        ResponseDto response = new ResponseDto();
        response.setMessage("success");
        response.setStatus(200);
        // 1. 새 Repository 객체 생성
        ResponseEntity<ResponseDto> responseEntity =
                new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); // .OK .CREATED 등등
        //return responseEntity;
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-likelion-custom", "Hello World");
        //return new ResponseEntity<>(
        //        response, headers, HttpStatus.ACCEPTED
        //);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("x-likelion-one", "1")
                .headers(headers)
                .body(response);
    }
}
