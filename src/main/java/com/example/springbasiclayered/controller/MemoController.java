package com.example.springbasiclayered.controller;

import com.example.springbasiclayered.dto.MemoRequestDto;
import com.example.springbasiclayered.dto.MemoResponseDto;
import com.example.springbasiclayered.service.MemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

/**
 * Memo Controller
 */
@RestController // @Controller + @ResponseBody
@RequestMapping("/memos") // Prefix
public class MemoController {

    // 주입된 의존성을 변경할 수 없어 객체의 상태를 안전하게 유지할 수 있다.
    private final MemoService memoService;

    /**
     * 생성자 주입
     * 클래스가 필요로 하는 의존성을 생성자를 통해 전달하는 방식
     * @param memoService @Service로 등록된 MemoService 구현체인 Impl
     */
    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    /**
     * 메모 생성 API
     * @param : {@link MemoRequestDto} 메모 생성 요청 객체
     * @return : {@link ResponseEntity<MemoResponseDto>} JSON 응답
     */
    @PostMapping
    public ResponseEntity<MemoResponseDto> createMemo(@RequestBody MemoRequestDto requestDto) {

        return new ResponseEntity<>(memoService.saveMemo(requestDto), HttpStatus.CREATED);
    }

    /**
     * 메모 전체 조회 API
     * @return : {@link List<MemoResponseDto>} JSON 응답
     */
    @GetMapping
    public List<MemoResponseDto> findAllMemos() {

        return memoService.findAllMemos();
    }

    /**
     * 메모 단건 조회 API
     * @param id 식별자
     * @return : {@link ResponseEntity<MemoResponseDto>} JSON 응답
     * @exception ResponseStatusException 식별자로 조회된 Memo가 없는 경우 404 Not Found
     */
    @GetMapping("/{id}")
    public ResponseEntity<MemoResponseDto> findMemoById(@PathVariable Long id) {

        return new ResponseEntity<>(memoService.findMemoById(id), HttpStatus.OK);
    }

    /**
     * 메모 전체 수정 API
     * @param id 식별자
     * @param : {@link MemoRequestDto} 메모 수정 요청 객체
     * @return : {@link ResponseEntity<MemoResponseDto>} JSON 응답
     * @exception ResponseStatusException 요청 필수값이 없는 경우 400 Bad Request, 식별자로 조회된 Memo가 없는 경우 404 Not Found
     */
    @PutMapping("/{id}")
    public ResponseEntity<MemoResponseDto> updateMemo(
            @PathVariable Long id,
            @RequestBody MemoRequestDto requestDto
    ) {

        return new ResponseEntity<>(memoService.updateMemo(id, requestDto.getTitle(), requestDto.getContents()), HttpStatus.OK);
    }

    /**
     * 메모 제목 수정 API
     * @param id 식별자
     * @param : {@link MemoRequestDto} 메모 수정 요청 객체
     * @return : {@link ResponseEntity<MemoResponseDto>} JSON 응답
     * @exception ResponseStatusException 요청 필수값이 없는 경우 400 Bad Request, 식별자로 조회된 Memo가 없는 경우 404 Not Found
     */
    @PatchMapping("/{id}")
    public ResponseEntity<MemoResponseDto> updateTitle(
            @PathVariable Long id,
            @RequestBody MemoRequestDto requestDto
    ) {

        return new ResponseEntity<>(memoService.updateTitle(id, requestDto.getTitle(), requestDto.getContents()), HttpStatus.OK);
    }

    /**
     * 메모 삭제 API
     * @param id 식별자
     * @return {@link ResponseEntity<Void>} 성공시 Data 없이 200OK 상태코드만 응답.
     * @exception ResponseStatusException 식별자로 조회된 Memo가 없는 경우 404 Not Found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMemo(@PathVariable Long id) {

        memoService.deleteMemo(id);
        // 성공한 경우
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
