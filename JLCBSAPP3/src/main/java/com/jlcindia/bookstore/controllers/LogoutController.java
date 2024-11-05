package com.jlcindia.bookstore.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/* 
* @Author : Srinivas Dande 
* @company : Java Learning Center 
* */ 
public class LogoutController extends JLCBaseController{ 
public String process(HttpServletRequest req,HttpServletResponse res) throws Exception{ 
System.out.println("LogoutController-process()"); 
String page="index.jsp"; 
HttpSession session=req.getSession(false); 
if(session!=null) 
session.invalidate(); 
String logoutMsg="You have logged out Successfully"; 
req.setAttribute("LogoutMsg", logoutMsg); 
return page; 
} 
} 
