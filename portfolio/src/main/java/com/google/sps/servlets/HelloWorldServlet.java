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
    private static final Map < String, List < String >> commentsMap = Map.of(
        "comments", List.of(
            "Learning a lot of new concepts!",
            "Everybody is very supportive!",
            "Relearning Java right now"
        )
    );
    private static final String JSONComments = new Gson().toJson(commentsMap);
  //GET request handler
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("application/json;");
    response.getWriter().println(JSONComments);

  }
}
