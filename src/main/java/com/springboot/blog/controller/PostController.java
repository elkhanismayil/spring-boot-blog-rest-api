package com.springboot.blog.controller;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.payload.PostResponse;
import com.springboot.blog.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.springboot.blog.utils.AppConstants.*;

@Api(value = "CRUD REST APIs for post resource")
@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ApiOperation(value = "create post REST API")
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody @Valid PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "get all posts REST API")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    @GetMapping
    public ResponseEntity<PostResponse> getAllPost(
            @RequestParam(name = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return new ResponseEntity<>(postService.getAllPost(pageNo, pageSize, sortBy, sortDir), HttpStatus.OK);
    }

    @ApiOperation(value = "get post by id REST API")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getById(@PathVariable("id") long id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "update post by id REST API")
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable("id") long id, @RequestBody @Valid PostDto postDto) {
        return new ResponseEntity<>(postService.updatePost(id, postDto), HttpStatus.OK);
    }

    @ApiOperation(value = "delete post by id REST API")
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") long id) {
        postService.deletePost(id);
        return new ResponseEntity<>("Post successfully deleted!", HttpStatus.OK);
    }
}
