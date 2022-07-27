package com.google.sps.data;
import java.util.*;

/** An class which represents the post on page. */
public class PostOnPage {

  //Global variables
  public final long id;
  public final String title;
  public final List<String> tag;
  public final String content_text;
  public final String content_image;
  public final long timestamp;
  
  //Constructor
  public PostOnPage(long id, String title, List<String> tag, String content_text, String content_image, long timestamp) {
    this.id = id;
    this.title = title;
    this.timestamp = timestamp;
    this.content_text = content_text;
    this.content_image = content_image;
    this.tag = tag;
  }
}