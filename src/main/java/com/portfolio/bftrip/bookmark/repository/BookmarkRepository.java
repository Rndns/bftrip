package com.portfolio.bftrip.bookmark.repository;

import com.portfolio.bftrip.bookmark.domain.Bookmark;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    @Query("select distinct b from Bookmark b join fetch b.user u where u.id = :userId")
    List<Bookmark> findBookmarksByUser(Long userId);
}
