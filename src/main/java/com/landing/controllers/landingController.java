
package com.landing.controllers;

import com.landing.EmailServiceImpl;
import com.landing.domain.PostComment;
import com.landing.domain.Survey;
import com.landing.services.AddSurveyService;
import com.landing.services.PostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by pipe on 9/11/17.
 */


@RestController
public class landingController {
    @Autowired
    private PostCommentService postCommentService;

    @Autowired
    private AddSurveyService addSurveyService;


    @Autowired
    public EmailServiceImpl emailService;

    private static final Map<String, Map<String, String>> labels;

    static {
        labels = new HashMap<>();

        //Simple email
        Map<String, String> props = new HashMap<>();
        props.put("headerText", "Send Simple Email");
        props.put("messageLabel", "Message");
        props.put("additionalInfo", "");
        labels.put("send", props);

        //Email with template
        props = new HashMap<>();
        props.put("headerText", "Send Email Using Template");
        props.put("messageLabel", "Template Parameter");
        props.put("additionalInfo",
                "The parameter value will be added to the following message template:<br>" +
                        "<b>This is the test email template for your email:<br>'Template Parameter'</b>"
        );
        labels.put("sendTemplate", props);

    }

    @RequestMapping(value = "/postComment", method = RequestMethod.POST)
    public String addComment(@RequestBody PostComment postComment) {
        postCommentService.savePostComment(postComment);
        return "success";
    }

    @RequestMapping(value = "/getComments",method = RequestMethod.GET)
    public ArrayList<PostComment> getComments() {
        Iterable<PostComment> postCommentIterable = postCommentService.findAllPostComments();
        Iterator<PostComment> postCommentIterator = postCommentIterable.iterator();
        ArrayList<PostComment> comments = new ArrayList<>();
        while (postCommentIterator.hasNext()) {
            PostComment postComment = postCommentIterator.next();
            comments.add(postComment);
        }

        return comments;
    }

    @RequestMapping(value = "/survey", method = RequestMethod.POST)
    public String addSurvey(@RequestBody Survey guest) {
        addSurveyService.addSurvey(guest);
        String[] to = {"pipe1411@gmail.com","echevarriae2@gmail.com"};
        emailService.sendSimpleMessage(to,"New Survey!",guest.getName() + " has completed a survey.");

        return "success";
    }
}

