package com.portfolio.bftrip.bookmark.controller;

import com.portfolio.bftrip.bookmark.domain.Bookmark;
import com.portfolio.bftrip.bookmark.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookmarks")
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<BookmarkDto.Result> findBookmarksByUser(@PathVariable("userId") Long userId){
        List<Bookmark> findBookmarks = bookmarkService.getBookmarksByUser(userId);
        List<BookmarkDto> collect = findBookmarks.stream()
                .map(b -> new BookmarkDto(b.getId(),b.getPlace().getId(),b.getUser().getId()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new BookmarkDto.Result(collect));
    }

    @PostMapping("/new")
    public ResponseEntity<BookmarkDto> saveBookmark(@RequestBody BookmarkRequest request){;
        Long id = bookmarkService.saveBookmark(request.toEntity());
        return ResponseEntity.ok(new BookmarkDto(id));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBookmark(@PathVariable("id") Long id){
        bookmarkService.deleteBookmark(id);
        return ResponseEntity.noContent().build();
    }
}
