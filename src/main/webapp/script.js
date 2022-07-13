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
function filter(){
    var input=document.getElementById("filter_in");
    var filter=input.value.toLowerCase();
    var all_d=document.getElementById("all_data");
    var li=all_d.getElementsByTagName('li');
    var i;
    for(i=0;i<li.length;i++){
        var textv=li[i].getElementsByTagName("a")[0].textContent || 
        li[i].getElementsByTagName("a")[0].innerText;
        if(textv.toLowerCase().indexOf(filter)>=0){
            li[i].style.display="";
        }
        else{
            li[i].style.display="none";
        }
    }
}
