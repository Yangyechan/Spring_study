package com.example.http_study.dto;

import lombok.Data;

import java.util.List;

@Data
public class ArticleWithCommentsDto {
    private String title;
    private String contents;
    private  String writer;
    private List<String> comments;
}
