package com.question.service.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.question.model.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
	public List<Question> findByContent(String content);

}
