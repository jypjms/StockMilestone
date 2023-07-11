package fisa.stockmilestone.modules.board.controller;

import fisa.stockmilestone.modules.global.exception.CustomException;
import fisa.stockmilestone.modules.global.response.BaseResponse;
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
    public BaseResponse<List<GetCommentRes>> getAllComments(@PathVariable Long postId) throws CustomException {
        List<GetCommentRes> getCommentRes = commentService.getAllComments(postId);
        return new BaseResponse<>(getCommentRes);
    }

    @PostMapping("/posts/{postId}/newcomment")
    public BaseResponse<PostCommentReq> postNewComment(@PathVariable Long postId, @RequestBody PostCommentReq postCommentReq) throws CustomException {
        commentService.postNewComment(postId, postCommentReq);
        return new BaseResponse<>(postCommentReq);
    }

    @PatchMapping("/mod-comment/{commentId}")
    public BaseResponse<PatchCommentReq> updateComment(@PathVariable Long commentId, @RequestBody PatchCommentReq patchCommentReq) throws CustomException {
        commentService.updateComment(commentId, patchCommentReq);
        return new BaseResponse<>(patchCommentReq);
    }

    @PatchMapping("/del-comment/{commentId}")
    public void deleteComment(@PathVariable Long commentId) throws CustomException {
        commentService.deleteComment(commentId);
    }
}
