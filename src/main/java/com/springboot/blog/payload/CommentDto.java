package com.springboot.blog.payload;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description = "Comment model description")
@Data
public class CommentDto {

    @ApiModelProperty(value = "Comment id", position = 1)
    private long id;

    @ApiModelProperty(value = "Comment name", position = 2)
    @NotEmpty(message = "Name should not be null or empty")
    private String name;

    @ApiModelProperty(value = "Comment email", position = 3)
    @Email
    private String email;

    @ApiModelProperty(value = "Comment body", position = 4)
    @NotEmpty
    @Size(min = 10, message = "Comment body should have at least 10 characters")
    private String body;
}
