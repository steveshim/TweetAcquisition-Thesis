# TweetAcquisiton-Thesis

Acquiring twitter data for master's thesis at csula.

#import the JSON into mongo
* `mongoimport --db movies --collection tweets --file tweets.json`

#export the JSON
* `mongoexport --db movies --collection tweets --out tweets.json`
