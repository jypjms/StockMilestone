package fisa.stockmilestone.modules.board.controller;

import fisa.stockmilestone.modules.board.dto.GetPostRes;
import fisa.stockmilestone.modules.board.dto.PostPostReq;
import fisa.stockmilestone.modules.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/app"})
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    // /post 등록
    @PostMapping({"/post"})
    public void addNewPost(@RequestBody PostPostReq postPostReq){
        postService.addNewPost(postPostReq);
    }
    @GetMapping({"/posts"})
    public List<GetPostRes> getPosts(){
        List<GetPostRes> postResList = postService.getAllPosts();
        return postResList;
    }

    // /posts/{postId} 불러오기

    // /posts/{postId}


    // /posts/{postId}



}
