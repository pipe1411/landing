
package com.landing.controllers;

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
import java.util.Iterator;


/**
 * Created by pipe on 9/11/17.
 */


@RestController
public class landingController {
    @Autowired
    private PostCommentService postCommentService;

    @Autowired
    private AddSurveyService addSurveyService;

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

        return "success";
    }
}

