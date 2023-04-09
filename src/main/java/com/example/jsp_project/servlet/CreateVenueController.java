package com.example.jsp_project.servlet;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "CreateVenueController", urlPatterns = {"/CreateVenueController"})
@MultipartConfig
public class CreateVenueController extends HttpServlet {
}
