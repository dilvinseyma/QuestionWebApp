package com.question.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.question.model.Answer;
import com.question.model.Question;
import com.question.service.repo.AnswerRepository;
import com.question.service.repo.QuestionRepository;

@RestController
public class QuestionController {
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	AnswerRepository answerRepository;

	@RequestMapping(value = "/questions/all", method = RequestMethod.GET)
	public List<Question> getQuestions() {

		return (List<Question>) questionRepository.findAll();
	}

	@RequestMapping(value = "/questions", method = RequestMethod.POST)
	public Question saveQuestions(@RequestBody Question question) {
		return questionRepository.save(question);

	}

	@RequestMapping("/question/{id}")
	public Question getQuestionByIdPath(@PathVariable("id") Long questionId) {
		Question question = new Question();
		question = questionRepository.findOne(questionId);
		return question;
	}

	@RequestMapping("/question/{id}/answers")
	public List<Answer> getAnswersByQuestionId(@PathVariable("id") long questionId) {
		Question q1 = new Question();
		q1.setQuestionId(questionId);
		List<Answer> answerList = answerRepository.findByQuestion(q1);
		return answerList;
	}

	@RequestMapping(value = "/question/{id}/answers", method = RequestMethod.POST)
	public Answer saveAnswers(@RequestBody Answer answer, @PathVariable("id") long questionId) {
		Question q1 = new Question();
		q1.setQuestionId(questionId);
		answer.setQuestion(q1);
		//System.out.println(answer);
		return answerRepository.save(answer);

	}
}
