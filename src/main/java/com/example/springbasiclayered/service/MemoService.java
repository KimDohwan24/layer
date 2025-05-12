package com.example.springbasiclayered.service;

import com.example.springbasiclayered.dto.MemoRequestDto;
import com.example.springbasiclayered.dto.MemoResponseDto;

import java.util.List;

public interface MemoService {

    MemoResponseDto saveMemo(MemoRequestDto requestDto);

    List<MemoResponseDto> findAllMemos();

    MemoResponseDto findMemoById(Long id);

    MemoResponseDto updateMemo(Long id, String title, String contents);

    MemoResponseDto updateTitle(Long id, String title, String contents);

    void deleteMemo(Long id);

}
