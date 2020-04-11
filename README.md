Simple client for [ChuckNorris API][1]

# Description

The app will display a random Chuck Norris joke when started. 
Notes:
 - Each time the "Another Joke" button is pressed a new joke will be displayed.
 - "View Categories" button allows the selection of a Joke category
 - Category list is cached in the database with 1 min expiration, same as the WeatherApp demo
 - The last category selected will be saved in shared preferrences
 - There's no error checking. If any http call fails, the app will crash
 - The UI is very basic since I'm not a designer :)


[1]:https://api.chucknorris.io/