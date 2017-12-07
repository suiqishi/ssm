package cn.com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.ssm.entity.CustomPeople;
import cn.com.ssm.entity.People;
import cn.com.ssm.mapper.PeopleMapper;
import cn.com.ssm.service.PeopleService;

@Service
public class PeopleServiceImpl implements PeopleService {

	@Autowired
	private PeopleMapper peopleMapper;
	
	@Override
	public People selectOne(int id) throws Exception {
		
		return peopleMapper.selectOne(id);
	}

	@Override
	public List<People> selectSome(People people) throws Exception {
		List<People> list = peopleMapper.selectSome(people);
		return list;
	}

	@Override
	public void insertPeople(People people) throws Exception {
		peopleMapper.insertPeople(people);
	}

	@Override
	public void updatePeople(People people) throws Exception {
		peopleMapper.updatePeople(people);

	}

	@Override
	public void deleteById(int id) throws Exception {
		peopleMapper.deleteById(id);
	}

	@Override
	public List<People> select2(CustomPeople customPeople) throws Exception {	
		return peopleMapper.select2(customPeople);
	}

}
