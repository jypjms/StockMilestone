package fisa.stockmilestone.modules.board.controller;

import fisa.stockmilestone.config.BaseException;
import fisa.stockmilestone.config.BaseResponse;
import fisa.stockmilestone.modules.board.dto.GetCommentRes;
import fisa.stockmilestone.modules.board.dto.PatchCommentReq;
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

    @PatchMapping("/mod-comment/{commentId}")
    public void updateComment(@PathVariable Long commentId, @RequestBody PatchCommentReq patchCommentReq){
        commentService.updateComment(commentId, patchCommentReq);
    }

    @PatchMapping("/del-comment/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
    }

    @ExceptionHandler(BaseException.class)
    public BaseResponse exceptionHandle(BaseException ne){
        System.out.println(ne);
        return new BaseResponse<>(ne.getStatus());
    }
}
