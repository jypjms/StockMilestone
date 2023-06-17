package fisa.stockmilestone.modules.board.repository;

import fisa.stockmilestone.modules.board.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Override
    Optional<Post> findById(Long aLong);

}
