package com.jlcindia.bookstore.servlets;

import java.io.IOException;

import com.jlcindia.bookstore.service.UserService;
import com.jlcindia.bookstore.to.UserTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession; 
/* 
* @Author : Srinivas Dande 
* @company : Java Learning Center 
* */ 
@WebServlet(name = "mylogin", urlPatterns = "/mylogin.jlc") 
public class LoginServlet extends JLCBaseServlet { 
public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
System.out.println("LoginServlet-service()"); 
// 1.Collect the Input 
String username = req.getParameter("username"); 
String password = req.getParameter("password"); 
// 2.Process 
UserTO userTO = userService.verifyUser(username, password); 
// 3.Prepare to forward 
String page = ""; 
if (userTO != null) { 
page = "home.jsp"; 
HttpSession session = req.getSession(); 
session.setAttribute("MyUserInfo", userTO);
} else { 
page = "login.jsp"; 
String loginMsg = "Invalid Username or Password"; 
req.setAttribute("LoginMsg", loginMsg); 
} 
RequestDispatcher rd = req.getRequestDispatcher(page); 
rd.forward(req, res); 
} 
}