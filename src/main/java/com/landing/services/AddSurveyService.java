package com.landing.services;

import com.landing.domain.Survey;
import org.springframework.stereotype.Component;

/**
 * Created by pipe on 12/24/17.
 */

@Component
public interface AddSurveyService {
    Survey addSurvey(Survey survey);
}
