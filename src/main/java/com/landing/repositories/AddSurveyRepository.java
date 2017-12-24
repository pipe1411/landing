package com.landing.repositories;

import com.landing.domain.Survey;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by pipe on 12/24/17.
 */
public interface AddSurveyRepository extends MongoRepository<Survey, String>{
}
