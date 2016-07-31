package com.question.service.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.question.model.Answer;
import com.question.model.Question;

@Repository
public interface AnswerRepository extends CrudRepository<Answer,Long>{
	List<Answer> findByQuestion(Question question);
	
}
