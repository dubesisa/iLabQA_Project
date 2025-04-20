Feature: API Functionality
   Scenario: DOG API TEST
     Given  site -  https://dog.ceo/api/
     Then Perform an API request to produce a list of all dog breeds
     Then Using code verify retriever breed is within the list
     Then Perform an API request to produce a list of sub-breeds for retriever
     Then Perform an API request to produce a random image  link for the subbreed golden