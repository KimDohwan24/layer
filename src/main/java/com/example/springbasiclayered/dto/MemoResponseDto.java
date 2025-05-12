package com.example.springbasiclayered.dto;

import com.example.springbasiclayered.entity.Memo;
import lombok.Getter;

/**
 * Memo 응답 DTO
 */
@Getter
public class MemoResponseDto {

    /**
     * 식별자
     */
    private Long id;

    /**
     * 제목
     */
    private String title;

    /**
     * 내용
     */
    private String contents;

    public MemoResponseDto(Memo memo) {
        this.id = memo.getId();
        this.title = memo.getTitle();
        this.contents = memo.getContents();
    }
}
