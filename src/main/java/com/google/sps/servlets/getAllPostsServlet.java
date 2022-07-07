package com.google.sps.servlets;
//Google Cloud Datastore Libraries
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
//Java HTTP Libraries
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Gson Library
import com.google.gson.Gson;
import com.google.sps.data.PostOnPage;
//Java List
import java.util.ArrayList;
import java.util.List;

/**
 * Handles requests to get all results
 * to the project
 */
@WebServlet("/")
public class getAllPostsServlet extends HttpServlet {
  @Override
  // Calls Function where we get the data from the database
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Creates an instance of a datastore object
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    //Creates an instance of a Query object
    Query<Entity> query = Query.newEntityQueryBuilder().setKind("PostOnPage").setOrderBy(OrderBy.desc("timestamp"))
        .build();
    //Runs the query
    QueryResults<Entity> results = datastore.run(query);
    //All the results are stored here as a list
    List<PostOnPage> Post = new ArrayList<>();
    while (results.hasNext()) {
      //Go to the next result
      Entity entity = results.next();
      //Saves the entity data into variables
      long id = entity.getKey().getId();
      String title = entity.getString("title");
      long timestamp = entity.getLong("timestamp");
      String content_text = entity.getString("content_text");
      String content_image = entity.getString("content_image");
      String temp_tag = entity.getString("tag");
      List<String> tag = convertStringToList(temp_tag);
      //Pass the values of the variables into a Object
      PostOnPage post = new PostOnPage(id, title, tag, content_text, content_image, timestamp);
      //Adds to the list
      Post.add(post);
    }
    //Creates the JSON object
    Gson gson = new Gson();
    //Prints the JSON content
    response.setContentType("application/json;");
    response.getWriter().println(gson.toJson(Post));
  }
  //Converts Normal Strings into a List of Strings
  public List<String> convertStringToList(String text) {
    //Initialize the string array
    String[] array = null;
    //Split the string into a array
    array = text.split(", ");
    //Creates a List of Stings
    List<String> result = new ArrayList<String>();
    //Pass the values of the array into the list
    for (int i = 0; i < array.length; i++) {
      result.add(array[i]);
    }
    //Returns the list
    return result;
  }
}
