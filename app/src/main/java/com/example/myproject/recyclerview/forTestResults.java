package com.example.myproject.recyclerview;

public class forTestResults {
    String subject, theme, correctAnswers, questions;

    public forTestResults(String subject, String theme, String correctAnswers, String questions) {
        this.subject = subject;
        this.theme = theme;
        this.correctAnswers = correctAnswers;
        this.questions = questions;
    }

    public String getSubject() {
        return subject;
    }

    public String getTheme() {
        return theme;
    }

    public String getCorrectAnswers() {
        return correctAnswers;
    }

    public String getQuestions() {
        return questions;
    }
}
