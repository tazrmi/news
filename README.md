# News 

News is an app that uses a database which stores newspaper articles, their genre, title and times they have been read.

The main goal of this app is to be functional and that it can be used by anyone. It was build based on different news websites such as CNN or http://sports747.com/

## Main functionalities

As it was said "News" is a newspaper web application. It has a h2 embedded database that contains all the records. The main page shows the latest 9 news in the database. Pages "Sports", "Showbizz" and "News" show news of a specific category, or genre.

There is a selection of top read news on the right of each page. Every time a news is open, the timesRead attribute increases by one.

Every news can be opened in a new page. The id of the news is used in this case, an the news is selected from the database by id. Also, there is an algorithm that compares the selected news with all the other news in the database and the result of this algorithm are three news that are most similar to the one selected. The titles of theese news can be seen in the "Related news" section on the bottom of the page which contains the text of the selected news. The algorithm used is called "The Sørensen–Dice index". 

## Sørensen–Dice index

Sørensen–Dice index is a statistic used for comparing the similarity of two samples. The algorithm was driven by the following requirements:

			A true reflection of lexical similarity - strings with small differences should be recognised as being similar. In particular, a significant substring overlap should point to a high level of similarity between the strings.

			A robustness to changes of word order - two strings which contain the same words, but in a different order, should be recognised as being similar. On the other hand, if one string is just a random anagram of the characters contained in the other, then it should (usually) be recognised as dissimilar.

			Language Independence - the algorithm should work not only in English, but in many different languages.
			

The algorithm in this application represents a string similarity metric that rewards both common substrings and a common ordering of those substrings. In addition, the algorithm considers not only the single longest common substring, but other common substrings too. The requirements may sound difficult to satisfy, but the solution is deceptively simple:

			Find out how many adjacent character pairs are contained in both strings.

The intention is that by considering adjacent characters, are is taken to account not only the characters, but also of the character ordering in the original string, since each character pair contains a little information about the original ordering.

For example strings 'France' and 'French'. When you split them up into their character pairs you get:

								France: {Fr, ra, an, nc, ce}

								French: {Fr, re, en, nc, ch}

Then work out which character pairs are in both strings. In this case, the intersection is {Fr, nc}. 

Character pairs that are prepared like this are now eligible to be used to find the Sørensen–Dice index, or, as it is called in this application, the difference.

difference(s1, s2)=(2* |pairs(s1)   ? pairs(s2)|)/(|pairs(s1)|+ |pairs(s2)| )

## License

Copyright Â© 2015 FIXME

Distributed under the Eclipse Public License either version 1.0 or any later version.

