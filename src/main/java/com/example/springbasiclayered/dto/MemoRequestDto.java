package com.example.springbasiclayered.dto;

import lombok.Getter;

/**
 * Memo 요청 DTO
 */
@Getter
public class MemoRequestDto {

    /**
     * 제목
     */
    private String title;

    /**
     * 내용
     */
    private String contents;

}
