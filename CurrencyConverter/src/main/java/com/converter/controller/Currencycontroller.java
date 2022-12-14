package com.converter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.converter.model.Currency;
import com.converter.service.CurrencyService;


@Controller
public class Currencycontroller {

	 final double rubel=0.80;
	 final double pound=96.55;
	 final double newshekel=22.89;
	 final double swissfranc=79.51;
	 
	 @Autowired
	 CurrencyService cs;
	
	@RequestMapping("/home")
	public String goHome(Model m) {
		Currency c=new Currency();
		m.addAttribute("user", c);
		return "Homepage";
	}
	@RequestMapping("/convert")
	public String convert(@ModelAttribute("user") Currency c,Model m) {
		double res = 0;
		if( c.getCurrencyfrom().equals("rupee")&&c.getCurrencyname().equals("dollar"))
		{
			String s=cs.searchCurrencyRates("dollar");
			System.out.println("string is "+s);
			Double d=Double.parseDouble(s);
			 res=c.getCurrency1()/d;
		}
		else if(c.getCurrencyfrom().equals("rupee")&&c.getCurrencyname().equals("pound"))
		{
			
			String s=cs.searchCurrencyRates("pound");
			System.out.println("string is "+s);
			Double d=Double.parseDouble(s);
			 res=c.getCurrency1()/d;
		}
		else if(c.getCurrencyfrom().equals("rupee")&&c.getCurrencyname().equals("rubel"))
		{
			 res=c.getCurrency1()/rubel;
		}
		else if(c.getCurrencyfrom().equals("rupee")&&c.getCurrencyname().equals("newshekel"))
		{
			String s=cs.searchCurrencyRates("newshekel");
			System.out.println("string is "+s);
			Double d=Double.parseDouble(s);
			 res=c.getCurrency1()/d;
		}
		else if(c.getCurrencyfrom().equals("rupee")&&c.getCurrencyname().equals("swissfranc"))
		{
			 res=c.getCurrency1()/swissfranc;
		}
		else if(c.getCurrencyfrom().equals("dollar")&&c.getCurrencyname().equals("rupee"))
		{
			String s=cs.searchCurrencyRates("dollar");
			System.out.println("string is "+s);
			Double d=Double.parseDouble(s);
			res=c.getCurrency1()*d;
		}
		else if(c.getCurrencyfrom().equals("dollar")&&c.getCurrencyname().equals("newshekel"))
		{
			 res=c.getCurrency1()*newshekel;
		}
		String  s=String.valueOf(res);
		String s1=s.substring(0, 4);
		s1=s1.concat(c.getCurrencyname());
		m.addAttribute("result", s1);
		return "Homepage";
	}
	
}
