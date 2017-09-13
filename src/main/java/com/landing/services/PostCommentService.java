package com.landing.services;

import com.landing.domain.PostComment;
import org.springframework.stereotype.Component;

/**
 * Created by pipe on 9/13/17.
 */

@Component
public interface PostCommentService {
    PostComment savePostComment(PostComment postComment);
    Iterable<PostComment> findAllPostComments();
}
