package com.example.http_study.dto;

import lombok.Data;

// 블로그 게시글
// 게시글 - 제목
// 게시글 - 내용
/*

 */
@Data
public class ResponseDto {
    private Integer status;
    private String message;
}
