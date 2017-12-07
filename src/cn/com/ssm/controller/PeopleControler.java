package cn.com.ssm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.ssm.entity.CustomPeople;
import cn.com.ssm.entity.People;
import cn.com.ssm.entity.Son;
import cn.com.ssm.service.PeopleService;

@Controller
public class PeopleControler {

	@Autowired
	private PeopleService peopleService;
	
	@RequestMapping(value="/caonima")
	public String aPeople(Map<String,Object> map){
		System.out.println("caonnima");
		map.put("peoples",new People());
		return "caonima";
	}
	
	@RequestMapping(value="/people",method=RequestMethod.GET)
	public String input(Map<String,Object> map){
		map.put("people", new People());
		return "add";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveNewPeople(People people) throws Exception{
		peopleService.insertPeople(people);
		return "redirect:/peoples";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.PUT)
	public String updatePeople(People people) throws Exception{
		peopleService.updatePeople(people);
		return "redirect:/peoples";
	}
	
	@RequestMapping(value="/people/{id}",method=RequestMethod.GET)
	public String saveUpdatePeople(@PathVariable("id") Integer id,Map<String,Object> map) throws Exception{
		People people = peopleService.selectOne(id);
		map.put("people", people);
		return "add";
	}
	
	@RequestMapping(value="/people/{id}",method=RequestMethod.DELETE)
	public String deletePeople(@PathVariable("id") Integer id) throws Exception{
		peopleService.deleteById(id);
		return "redirect:/peoples";
	}
	
	@RequestMapping(value="/peoples",method=RequestMethod.GET)
	public String allPeople(Map<String,Object> map){
		List<People> list = null;
		try {
			list = peopleService.selectSome(new People());
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("peoples", list);
		return "list";
	}
	
	@RequestMapping("/search")
	public String select2(Map<String,Object> map,CustomPeople customPeople){
		List<People> list = null;
		try {
			list = peopleService.select2(customPeople);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("peoples", list);
		
		return "list";
	}
	
	@RequestMapping("/to")
	public String testRedirectOne(){
		
		String url = "/do?people.name=xxx&people.age=11";
		return "redirect:"+url;
	}
	
	@RequestMapping("/do")
	public String testRedirectOne(Son son){
        
		System.out.println("xxxx");
		People people = son.getPeople();
		System.out.println(son.getPeople().toString());
		
		return "list";
	}
}
