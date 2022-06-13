package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
  List<String> comments = List.of("Learning a lot of new concepts!", "Everybody is very supportive!","Relearning Java right now");
  Map<String,List<String>> commentsMap = new HashMap<String,List<String>>();
  
  //GET request handler
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    commentsMap.put("comments",comments);
    String json = convertToJsonUsingGson(commentsMap);

    response.setContentType("application/json;");
    response.getWriter().println(json);


  }
  private String convertToJsonUsingGson(Map<String,List<String>> map) {
    Gson gson = new Gson();
    String json = gson.toJson(map);
    return json;
  }
}
