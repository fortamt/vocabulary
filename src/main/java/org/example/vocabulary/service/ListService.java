package org.example.vocabulary.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.vocabulary.dto.ListResponseDto;
import org.example.vocabulary.repository.ListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ListService {

    private final ListRepository listRepository;

    public List<ListResponseDto> getListsStartsWith(String prefix) {
        return listRepository.findByNameStartingWith(prefix).stream()
                .map(list -> ListResponseDto.builder()
                        .id(list.getId())
                        .name(list.getName())
                        .wordCount(list.getWordCount())
                        .icon(list.getIcon())
                        .background(list.getBackground())
                        .build())
                .collect(Collectors.toList());
    }

}
