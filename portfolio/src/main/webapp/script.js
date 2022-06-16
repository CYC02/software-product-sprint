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

/**
 * Adds a random fun fact to the page.
 */
function addRandomFunFact() {
  const funFacts =
      ['My favorite color is orange.', 'I had 3 turtles.', 'Oranges are my favorite fruit.', 'I have one dimple on my right cheek.'];

  // Pick a random greeting.
  const funFact = funFacts[Math.floor(Math.random() * funFacts.length)];

  // Add it to the page.
  const funFactContainer = document.getElementById('funFact-container');
  funFactContainer.innerText = funFact;
}

async function fetchServerMessage() {
    const serverResponse = await fetch('/hello');
    const textResponse = await serverResponse.text();

    const msgContainer = document.getElementById('msg-container');

    const json = JSON.parse(textResponse);
    const commentsArr = json.comments;
    
    randomComment = "";
    if(commentsArr.length!=0){
        randomComment = commentsArr[Math.floor(Math.random() * commentsArr.length)];
    } 
    else{
        randomComment = "There are no comments to display.";
    }
    
    msgContainer.innerText = randomComment;
    console.log(serverResponse);
    console.log(textResponse);
    console.log(json);
}
