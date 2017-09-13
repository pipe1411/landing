package com.landing.persistance;

import com.landing.domain.PostComment;
import com.landing.repositories.PostCommentRepository;
import com.landing.services.PostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pipe on 9/13/17.
 */

@Service
@Transactional
public class PostCommentServiceImpl implements PostCommentService {
    @Autowired
    private PostCommentRepository postCommentRepository;

    @Override
    public PostComment savePostComment(PostComment postComment) {
        return postCommentRepository.save(postComment);
    }

    @Override
    public Iterable<PostComment> findAllPostComments() {
        return postCommentRepository.findAll();
    }
}
