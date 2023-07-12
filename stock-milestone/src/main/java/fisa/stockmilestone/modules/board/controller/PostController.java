package fisa.stockmilestone.modules.board.controller;

import fisa.stockmilestone.modules.board.dto.GetPostRes;
import fisa.stockmilestone.modules.board.dto.PatchPostReq;
import fisa.stockmilestone.modules.board.dto.PostPostReq;
import fisa.stockmilestone.modules.board.service.PostService;
import fisa.stockmilestone.modules.global.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/app"})
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    /*
     * 게시글(Post) 등록
     */
    @PostMapping({"/post"})
    public void addNewPost(@RequestBody PostPostReq postPostReq) {
        postService.addNewPost(postPostReq);
    }

    /*
     * 게시글(Post) 전체 목록 조회
     */
    @GetMapping({"/posts"})
    public BaseResponse<List<GetPostRes>> getPosts() {
        List<GetPostRes> postResList = postService.getAllPosts();
        return new BaseResponse<>(postResList);
    }

    /*
     * 게시글(Post) 상세 조회
     */
    @GetMapping({"/posts/{postId}"})
    public BaseResponse<GetPostRes> getPost(@PathVariable Long postId) {
        GetPostRes getPostRes = postService.getPostRes(postId);
        return new BaseResponse<>(getPostRes);
    }

    /*
     * 게시글(Post) 수정
     */
    @PatchMapping({"/posts/{postId}"})
    public void updatePost(@RequestBody PatchPostReq petchPostReq) {
        postService.updatePost(petchPostReq);
    }

    /*
     * 게시글(Post) 삭제
     */
    @DeleteMapping({"/posts/{postId}"})
    public void deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
    }
}
