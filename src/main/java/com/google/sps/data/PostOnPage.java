// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.data;
import java.util.*;

/** An item on a todo list. */
public class PostOnPage {

  public final long id;
  public final String title;
  public final List<String> tag;
  public final String content_text;
  public final String content_image;
  public final long timestamp;

  public PostOnPage(long id, String title, List<String> tag, String content_text, String content_image, long timestamp) {
    this.id = id;
    this.title = title;
    this.timestamp = timestamp;
    this.content_text = content_text;
    this.content_image = content_image;
    this.tag = tag;
  }
}