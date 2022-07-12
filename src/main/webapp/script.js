// Copyright 2020 Google LLC
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

let getPosts = function(filters) {
    return {
      "Post": [
          {
              "Title": "Test Title",
              "Timestamp": "23409872349",
              "Content": "lorem ipsum dolor sit amet consectetur adipiscing elit proin dictumst enim etiam nisi neque suspendisse vel lectus phasellus elementum magna hendrerit iaculis maximus tempor mollis purus a odio gravida euismod ad nibh torquent justo tellus duis nec eleifend pretium nascetur ornare nam ex erat bibendum dui aptent himenaeos leo tincidunt pellentesque tempus id commodo habitasse laoreet ligula conubia nisl ante donec molestie vestibulum nostra augue arcu primis feugiat ut interdum accumsan quisque vitae finibus penatibus consequat venenatis praesent inceptos nulla taciti varius rutrum ac congue in imperdiet et condimentum auctor vehicula montes nunc litora quam velit urna eget ultricies quis",
              "Tags": [
                  "Depression",
                  "PTSD",
                  "Trauma"
              ]
          },
          {
              "Title": "Test Title 2",
              "Timestamp": "23409872349",
              "Content": "lorem ipsum dolor sit amet consectetur adipiscing elit nisi condimentum venenatis tellus pulvinar sollicitudin nullam tortor risus est penatibus mi lectus nulla rutrum in hac finibus maecenas cursus iaculis eget primis rhoncus habitasse commodo cubilia aptent facilisi habitant egestas feugiat nascetur ligula magna viverra ornare suspendisse fusce praesent volutpat suscipit conubia laoreet magnis sed mollis nisl et lacinia natoque imperdiet dapibus litora potenti aliquet cras fermentum ad mauris massa taciti morbi nam gravida enim maximus ridiculus eros pharetra integer congue diam vestibulum inceptos vel parturient efficitur porttitor platea curae dictum scelerisque a mus posuere bibendum consequat torquent quam vulputate aenean",
              "Tags": [
                  "Tension",
                  "Harrashment"
              ]
          },
          {
            "Title": "Test Title 3",
            "Timestamp": "23409872340",
            "Content": "lorem ipsum dolor sit amet consectetur adipiscing elit taciti porttitor primis diam tempor conubia pulvinar habitasse porta aliquet urna vulputate integer metus nascetur risus massa eu neque leo vivamus parturient volutpat id congue aliquam facilisi libero etiam arcu fermentum efficitur sagittis pellentesque pretium accumsan elementum aptent magna auctor fusce fringilla finibus faucibus senectus duis nullam enim curabitur turpis sapien praesent posuere inceptos semper fames facilisis nulla sollicitudin hendrerit mollis dictum potenti habitant scelerisque nostra platea vehicula ullamcorper imperdiet eget litora lacus sociosqu morbi hac ridiculus tincidunt nisl orci ultrices per interdum tellus justo a ad velit vel tortor lacinia torquent",
            "Tags": [
                "Tension",
                "Harrashment",
                "LGBTQ+"
            ]
        }
      ]
    }
  }

Posts = getPosts();

function refreshTimeline() {
    for(let i = 0; i < Posts.Post.length; i++){
        const ul = document.getElementById('wrapper');
        const li = document.createElement('li');
        li.classList.add('notes')
        console.log(li);
        ul.append(li)
    
        const p = document.createElement('p');
        p.innerText = Posts.Post[i].Title;
        p.classList.add('title')
    
        li.append(p);
    
        const span = document.createElement('span');
        span.innerText= Posts.Post[i].Content;
        span.classList.add('description');
    
        li.append(span)
    
        const tags = document.createElement('ul');
        tags.classList.add('tags')
    
        console.log(Posts.Post[0].Tags[1])
    
        for(let j = 0; j < Posts.Post[i].Tags.length; j++){
            console.log(Posts.Post[i].Tags[j])
            const subTags = document.createElement('li');
            const buttons = document.createElement('button')
            subTags.append(buttons);
            buttons.innerText = Posts.Post[i].Tags[j];
            tags.append(subTags);
        }
    
        li.append(tags);
    }
 }
