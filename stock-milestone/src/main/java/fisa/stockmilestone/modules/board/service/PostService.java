package fisa.stockmilestone.modules.board.service;

import fisa.stockmilestone.modules.account.domain.Account;
import fisa.stockmilestone.modules.account.repository.AccountRepository;
import fisa.stockmilestone.modules.board.domain.Post;
import fisa.stockmilestone.modules.board.domain.PostImg;
import fisa.stockmilestone.modules.board.domain.PostStatus;
import fisa.stockmilestone.modules.board.dto.PostPostReq;
import fisa.stockmilestone.modules.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final AccountRepository accountRepository;
    @Transactional
    public void addNewPost(Long accountId, PostPostReq postPostReq){
        Account findAccount = accountRepository.findById(accountId).orElseThrow(() -> {return new IllegalArgumentException("account doesn't exist");});

        Post post = Post.builder().account(findAccount).likeNum(0).content(postPostReq.getContent())
                .status(PostStatus.ACTIVE).build();
        postRepository.save(post);
    }

}
