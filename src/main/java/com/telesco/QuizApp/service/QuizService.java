package com.telesco.QuizApp.service;

import com.telesco.QuizApp.dao.QuestionRepository;
import com.telesco.QuizApp.dao.QuizDao;
import com.telesco.QuizApp.model.Question;
import com.telesco.QuizApp.model.QuestionWrapper;
import com.telesco.QuizApp.model.Quiz;
import com.telesco.QuizApp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionRepository questionDao;

    public String createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);

        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return "Quiz created successfully";
    }

    public List<QuestionWrapper> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for (Question q : questionsFromDB) {
            QuestionWrapper qw = new QuestionWrapper(q);
            questionsForUser.add(qw);
        }
        return questionsForUser;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for (Response response : responses) {
            if (response.getResponse().equals(questions.get(i).getRightoption())) {
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }

}
