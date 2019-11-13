package com.asama.luong.mvpjavaexample.data.db;

import com.asama.luong.mvpjavaexample.data.db.model.Option;
import com.asama.luong.mvpjavaexample.data.db.model.Question;
import com.asama.luong.mvpjavaexample.data.db.model.User;

import java.util.List;

import io.reactivex.Observable;

public interface DbHelper {

    Observable<Long> insertUser(User user);

    Observable<List<User>> getAllUsers();

    Observable<List<Question>> getAllQuestions();

    Observable<Boolean> isQuestionEmpty();

    Observable<Boolean> isOptionEmpty();

    Observable<Boolean> saveQuestion(Question question);

    Observable<Boolean> saveOptions(Option option);

    Observable<Boolean> saveQuestionList(List<Question> questionList);

    Observable<Boolean> saveOptionList(List<Option> optionList);
}
