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

/**
 * Handles requests to get a filtered result 
 * to the project
 */
@WebServlet("/getFilteredPosts")
public class getFilteredPostsServlet extends HttpServlet {
  @Override
  // Calls Function where we get the data from the database
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    Query<Entity> query = Query.newEntityQueryBuilder().setKind("PostOnPage").setOrderBy(OrderBy.desc("timestamp"))
        .build();
    QueryResults<Entity> results = datastore.run(query);
    List<PostOnPage> Post = new ArrayList<>();
    while (results.hasNext()) {
      Entity entity = results.next();
      //Saves the entity data into variables
      long id = entity.getKey().getId();
      String title = entity.getString("title");
      long timestamp = entity.getLong("timestamp");
      String content_text = entity.getString("content_text");
      String content_image = entity.getString("content_image");
      String temp_tag = entity.getString("tag");
      List<String> tag = convertStringToList(temp_tag);
      PostOnPage post = new PostOnPage(id, title, tag, content_text, content_image, timestamp);
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
    for (int i = 0; i < array.length; i++) {
      result.add(array[i]);
    }
    return result;
  }
}
