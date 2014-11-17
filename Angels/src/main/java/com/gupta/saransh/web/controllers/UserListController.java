/**
 * 
 */
package com.gupta.saransh.web.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.gupta.saransh.models.SearchResponseWrapper;
import com.gupta.saransh.services.SearchAngelList;
/**
 * Controller for the "/userlist" mapping: Handles requests for displaying the list of 'Users' affiliated with 'UCLA'
 * @author Saransh
 *
 */
@Controller
public class UserListController {
	
	@Autowired
	SearchAngelList sal;
	
	@RequestMapping(value="/userList", method= RequestMethod.GET)
	public ModelAndView userList() throws JsonParseException, IOException{
		SearchResponseWrapper searchResponseWrapper =sal.searchUsers("ucla", "User");
		System.out.println(searchResponseWrapper);
		Map<String,Object> model = new HashMap<String, Object>();
		model.put("searchResponseList", searchResponseWrapper.getSearchResponseList());
		
		return new ModelAndView("userList", "model", model);
	}

}
