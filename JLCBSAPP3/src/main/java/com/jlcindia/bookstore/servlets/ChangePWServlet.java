package com.jlcindia.bookstore.servlets;
import java.io.IOException;

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
@WebServlet(name = "changepw", urlPatterns = "/changepw.jlc") 
public class ChangePWServlet extends JLCBaseServlet { 
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
System.out.println("ChangePWServlet-service()"); 
// 1.Collect the Input 
String currentpw = req.getParameter("currentpw"); //Not using now 
String newpw = req.getParameter("newpw"); 
String confirmpw = req.getParameter("confirmpw"); 
// 2.Process 
int updateStatus = 0; 
if (newpw.equals(confirmpw)) { 
HttpSession session = req.getSession(false); 
if (session == null) { 
String msg = "Session Expired. Login Again"; 
req.setAttribute("LoginMsg", msg); 
RequestDispatcher rd = req.getRequestDispatcher("login.jsp"); 
rd.forward(req, res); 
} 
else { 
UserTO userTO = (UserTO) session.getAttribute("MyUserInfo"); 
int userId = (int) userTO.getUserId(); 
updateStatus = userService.changePassword(userId, newpw) ; 
} 
} 
// 3.Prepare to forward 
String page = ""; 
if (updateStatus==1) { 
page = "changepwStatus.jsp"; 
String msg = "Your Password Updated Successfully..."; 
req.setAttribute("PwMsg", msg); 
} else { 
page = "changepw.jsp"; 
String msg = "Something Wrong ..Enter Passwords correctly..."; 
req.setAttribute("PwMsg", msg); 
} 
RequestDispatcher rd = req.getRequestDispatcher(page);
rd.forward(req, res); 
} 
}