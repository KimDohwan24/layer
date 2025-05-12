package com.example.springbasiclayered.repository;

import com.example.springbasiclayered.dto.MemoResponseDto;
import com.example.springbasiclayered.entity.Memo;

import java.util.List;
import java.util.Map;

public interface MemoRepository {

    Memo saveMemo(Memo memo);

    List<MemoResponseDto> findAllMemos();

    Memo findMemoById(Long id);

    void deleteMemo(Long id);

}
