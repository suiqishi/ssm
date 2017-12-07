package cn.com.ssm.service;

import java.util.List;

import cn.com.ssm.entity.CustomPeople;
import cn.com.ssm.entity.People;

public interface PeopleService {
	People selectOne(int id) throws Exception;
	List<People> selectSome(People people) throws Exception;
	void insertPeople(People people) throws Exception;
	void updatePeople(People people) throws Exception;
	void deleteById(int id) throws Exception;
	List<People> select2(CustomPeople customPeople) throws Exception;
}
