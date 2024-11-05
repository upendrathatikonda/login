package com.jlcindia.bookstore.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import com.jlcindia.bookstore.service.UserService; 
/* 
* @Author : Srinivas Dande 
* @company : Java Learning Center 
* */ 
public class ForgotPWController extends JLCBaseController{ 
public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
 System.out.println("ForgotPWController-process()"); 
 
 // 1.Collect the Input 
 String email = req.getParameter("email"); 
 // 2.Process 
 String pw = userService.getPassword(email);
//3.Prepare to forward 
String page = ""; 
if (pw == null) { 
page = "forgotpw.jsp"; 
String msg = "Invalid Email ID"; 
req.setAttribute("MyMsg", msg); 
} else { 
page = "passwordInfo.jsp"; 
req.setAttribute("MyPassword", pw); 
} 

return page; 
} 
} 

 