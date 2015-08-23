# News 

News is an app that uses a database which stores newspaper articles, their genre, title and times they have been read.

The main goal of this app is to be functional and that it can be used by anyone. It was build based on different news websites such as CNN or http://sports747.com/

## Main functionalities

As it was said "News" is a newspaper web application. It has a h2 embedded database that contains all the records. The main page shows the latest 9 news in the database. Pages "Sports", "Showbizz" and "News" show news of a specific category, or genre.

There is a selection of top read news on the right of each page. Every time a news is open, the timesRead attribute increases by one.

Every news can be opened in a new page. The id of the news is used in this case, an the news is selected from the database by id. Also, there is an algorithm that compares the selected news with all the other news in the database and the result of this algorithm are three news that are most similar to the one selected. The titles of theese news can be seen in the "Related news" section on the bottom of the page which contains the text of the selected news. The algorithm used is called "The Sørensen–Dice index". 

## Sørensen–Dice index

## License

Copyright Â© 2015 FIXME

Distributed under the Eclipse Public License either version 1.0 or any later version.
