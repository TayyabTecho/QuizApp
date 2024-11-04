package com.telesco.QuizApp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "questions")
public class Question {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String option1;
    private String questionTitle;
    private String option2;
    private String option4;
    private String option3;
    private String rightoption;
    private String difficultylevel;

    private String Category;





}
