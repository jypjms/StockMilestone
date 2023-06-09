package fisa.stockmilestone.modules.board.service;

import fisa.stockmilestone.modules.account.domain.Account;
import fisa.stockmilestone.modules.account.repository.AccountRepository;
import fisa.stockmilestone.modules.board.domain.Post;
import fisa.stockmilestone.modules.board.domain.PostStatus;
import fisa.stockmilestone.modules.board.dto.GetPostRes;
import fisa.stockmilestone.modules.board.dto.PatchPostReq;
import fisa.stockmilestone.modules.board.dto.PostPostReq;
import fisa.stockmilestone.modules.board.exception.NoSuchPostException;
import fisa.stockmilestone.modules.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final AccountRepository accountRepository;

    /*
     * 게시글(Post) 등록
     */
    @Transactional
    public void addNewPost(PostPostReq postPostReq) {
        // TODO JWT에서 accountId 필요
        Account findAccount = accountRepository.findById(2L).orElseThrow(() -> {
            return new IllegalArgumentException("account doesn't exist");
        });

        Post post = Post.builder().account(findAccount).likeNum(0).content(postPostReq.getContent())
                .status(PostStatus.ACTIVE).build();
        postRepository.save(post);
    }

    /*
     * 게시글(Post) 전체 조회
     */
    public List<GetPostRes> getAllPosts() {
        List<GetPostRes> getPostResList = postRepository.findAll().stream().map(post -> new GetPostRes(
                post.getId(),
                post.getAccount().getNickName(),
                post.getLikeNum(),
                post.getContent()
        )).collect(Collectors.toList());
        return getPostResList;
    }

    /*
     * 게시글(Post) 상세 조회
     */
    public GetPostRes getPostRes(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new NoSuchPostException(postId));
        GetPostRes getPostRes = new GetPostRes(
                post.getId(),
                post.getAccount().getNickName(),
                post.getLikeNum(),
                post.getContent());

        return getPostRes;
    }

    /*
     * 게시글(Post) 수정
     */
    @Transactional
    public void updatePost(PatchPostReq patchPostReq) {
        Post post = postRepository.findById(patchPostReq.getId()).orElseThrow(() -> new NoSuchPostException(patchPostReq.getId()));
        post.updatePost(patchPostReq.getContent());
    }

    @Transactional
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new NoSuchPostException(postId));
        postRepository.delete(post);
    }

}
