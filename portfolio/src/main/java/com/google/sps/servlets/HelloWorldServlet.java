package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
  //GET request handler
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ArrayList<String> comments = new ArrayList<String>();
    comments.add("I'm learning a lot of new concepts!");
    comments.add("Everybody is very supportive!");
    comments.add("Relearning Java right now");

    String json = convertToJSON(comments);

    response.setContentType("application/json;");
    response.getWriter().println(json);


  }
    private String convertToJSON(ArrayList<String> commentsArr){
        String json = "{";
        json += "\"comments\": ";
        json += "[";
        for(int i = 0; i < commentsArr.size()-1; i++){
            String str = commentsArr.get(i);
            json += "\"" + str + "\"" + ", ";
        }
        json += "\"" + commentsArr.get(commentsArr.size()-1) + "\"";
        json += "]";
        json += "}";
        return json;
    }
}
