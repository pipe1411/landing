package com.landing.repositories;

import com.landing.domain.PostComment;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by pipe on 9/13/17.
 */
public interface PostCommentRepository extends MongoRepository<PostComment,String> {
}
