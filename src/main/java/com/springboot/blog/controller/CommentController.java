package com.springboot.blog.controller;

import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "CRUD REST APIs for post resource")
@RestController
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @ApiOperation(value = "create comment by post id REST API")
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable("postId") long postId,
                                                    @RequestBody @Valid CommentDto commentDto) {
        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "get all comments by post id REST API")
    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<CommentDto>> findAllCommentsByPostId(@PathVariable("postId") long postId) {
        return new ResponseEntity<>(commentService.findCommentsByPostId(postId), HttpStatus.OK);
    }

    @ApiOperation(value = "get single comment by post id REST API")
    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> findCommentById(@PathVariable("postId") long postId,
                                                      @PathVariable("commentId") long commentId) {
        return new ResponseEntity<>(commentService.getCommentById(postId, commentId), HttpStatus.OK);
    }

    @ApiOperation(value = "update comment by post id REST API")
    @PutMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable("postId") long postId,
                                                    @PathVariable("commentId") long commentId,
                                                    @RequestBody @Valid CommentDto commentRequest) {
        return new ResponseEntity<>(commentService.updateComment(postId, commentId, commentRequest), HttpStatus.OK);
    }

    @ApiOperation(value = "delete comment by post id REST API")
    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable("postId") long postId,
                                                @PathVariable("commentId") long commentId) {
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
    }
}
