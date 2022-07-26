package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.sps.data.PostOnPage;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Handles requests to get all results
 * to the project
 */
@WebServlet("/getAllPost")
public class getAllPostsServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Creates an instance of a datastore object
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    Query<Entity> query = Query.newEntityQueryBuilder().setKind("PostOnPage").setOrderBy(OrderBy.desc("timestamp"))
        .build();
    QueryResults<Entity> results = datastore.run(query);
    List<PostOnPage> Post = new ArrayList<>();
    while (results.hasNext()) {
      Entity entity = results.next();
      //Saves the entity data into variables
      PostOnPage post = 
      new PostOnPage(
          entity.getKey().getId(), 
          entity.getString("title"), 
          convertStringToList(entity.getString("tag")), 
          entity.getString("content_text"), 
          entity.getString("content_image"), 
          entity.getLong("timestamp"));
      Post.add(post);
    }
    Gson gson = new Gson();
    response.setContentType("application/json;");
    response.getWriter().println(gson.toJson(Post));
  }
  //Converts Normal Strings into a List of Strings
  public List<String> convertStringToList(String text) {
    String[] array = null;
    array = text.split(", ");
    List<String> result = new ArrayList<String>();
    //Pass the values of the array into the list
    for (int i = 0; i < array.length; i++) {
      result.add(array[i]);
    }
    //Returns the list
    return result;
  }
}
