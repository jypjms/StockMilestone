package fisa.stockmilestone.modules.board.controller;

import fisa.stockmilestone.modules.board.service.PostService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/app"})
public class PostController {
    PostService postService;
}
