package com.example.http_study.dto;

import lombok.Data;

import java.util.List;

@Data
public class ArticleComplexDto {
    private String title;
    private String contents;
    private  WriterDto writer;
    private List<String> comments;
}
