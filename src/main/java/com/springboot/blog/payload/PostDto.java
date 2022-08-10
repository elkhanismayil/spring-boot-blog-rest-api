package com.springboot.blog.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@ApiModel(description = "Post model information")
@Data
public class PostDto {

    @ApiModelProperty(value = "Blog post id", position = 1)
    private long id;

    @ApiModelProperty(value = "Blog post title", position = 2)
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String title;

    @ApiModelProperty(value = "Blog post description", position = 3)
    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters")
    private String description;

    @ApiModelProperty(value = "Blog post content", position = 4)
    @NotBlank
    private String content;

    @ApiModelProperty(value = "Blog post comments", position = 5)
    private Set<CommentDto> comments;
}
