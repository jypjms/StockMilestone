package fisa.stockmilestone.modules.board.controller;

import fisa.stockmilestone.modules.board.dto.GetCommentRes;
import fisa.stockmilestone.modules.board.dto.PostCommentReq;
import fisa.stockmilestone.modules.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/app"})
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping({"/posts/{postId}/comments"})
    public List<GetCommentRes> getAllComments(@PathVariable Long postId) {
        List<GetCommentRes> getCommentRes = commentService.getAllComments(postId);
        return getCommentRes;
    }

    @PostMapping("/posts/{postId}/newcomment")
    public void postNewComment(@PathVariable Long postId, @RequestBody PostCommentReq postCommentReq) {
        commentService.postNewComment(postId, postCommentReq);
    }
}
