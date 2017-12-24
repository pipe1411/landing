package com.landing.persistance;

import com.landing.domain.Survey;
import com.landing.repositories.AddSurveyRepository;
import com.landing.services.AddSurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pipe on 12/24/17.
 */

@Service
@Transactional
public class AddSurveyImpl implements AddSurveyService {
    @Autowired
    private AddSurveyRepository addSurveyRepository;

    @Override
    public Survey addSurvey(Survey survey) {
        return addSurveyRepository.save(survey);
    }
}
