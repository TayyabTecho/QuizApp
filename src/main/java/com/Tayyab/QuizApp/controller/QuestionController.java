package com.Tayyab.QuizApp.controller;

import com.Tayyab.QuizApp.model.Question;
//import com.telesco.QuizApp.service.QuestionService;
import com.Tayyab.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;


    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }


    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {

        return  questionService.getQuestionsByCategory(category);

    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);

    }

//    @GetMapping("get/id")
//    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id) {
//
//        return questionService.getQuizQuestions(id);
//
//    }


}
