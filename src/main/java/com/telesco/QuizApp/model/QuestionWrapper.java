package com.telesco.QuizApp.model;

import lombok.Data;

@Data
public class QuestionWrapper {
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option4;
    private String option3;

    public QuestionWrapper(Question source) {
        this.id = source.getId();
        this.questionTitle = source.getQuestionTitle();
        this.option1 = source.getOption1();
        this.option2 = source.getOption2();
        this.option3 = source.getOption3();
        this.option4 = source.getOption4();
    }


}
