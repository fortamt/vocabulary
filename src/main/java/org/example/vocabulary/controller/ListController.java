package org.example.vocabulary.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.vocabulary.dto.ListResponseDto;
import org.example.vocabulary.service.ListService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/list")
public class ListController {

    private final ListService listService;

    @GetMapping("/{prefix}")
    public ResponseEntity<List<ListResponseDto>> getListStartsWith(@PathVariable String prefix) {
        return ResponseEntity.ok(listService.getListsStartsWith(prefix));
    }

}
