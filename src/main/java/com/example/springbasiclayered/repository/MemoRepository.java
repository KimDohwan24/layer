package com.example.springbasiclayered.repository;

import com.example.springbasiclayered.dto.MemoResponseDto;
import com.example.springbasiclayered.entity.Memo;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MemoRepository {

    MemoResponseDto saveMemo(Memo memo);

    List<MemoResponseDto> findAllMemos();

    Optional<Memo> findMemoById(Long id);

    Memo findMemoByIdOrElseThrow(Long id);

    int updateMemo(Long id, String title, String contents);
    int updateTitle(Long id, String title);
    int deleteMemo(Long id);

}
