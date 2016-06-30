package com.src.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.src.model.Company;
import com.src.model.User;
import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//JdbcTemplate jdbcTemplateObj = new JdbcTemplate(ds);
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("company", new User());
		return "home";
	}
	@RequestMapping(value = "/company", method = RequestMethod.POST)
	public String company(Model model, @ModelAttribute("company") User user) throws ClassNotFoundException, SQLException {
		System.out.println("HAIIIIIIIIIIIIIIIIIIIIII");
		System.out.println("CCCCC "+user.getUsername());
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/servicecart","root","root");  
		
		String sql = "select * from user where password ='"+user.getUsername()+"'and username ='"+user.getPassword()+"'";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery(sql);
		 if(rs.next())
         {
             System.out.println("Db inside RS");
             String message = "Login Success";
             model.addAttribute("message", message);
         }
		 else{
			 String message = "Sorry ! Login failure";
			 model.addAttribute("message", message);
		 }
		
		
		
		return "success";
		
	}
	
	
	
	
	
	
}
