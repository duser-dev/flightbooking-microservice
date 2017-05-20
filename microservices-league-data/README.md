# League Data Microservice

This service is responsible for retrieving the external data from a Web API that provides league data. The current version uses [OpenLigaDB](http://www.openligadb.de) to retrieve the data.
By default, 1. Bundesliga data is retrieved. A different league can be chosen by changing the spring.application.league and spring.application.numMatchdays properties (e.g. "EM-2016" and 5 for the Euro 2016).

## HTTP API

The service runs on port 4567 by default. It provides the following interface paths:
 * `/league/{season}` returns the data structure for the whole league for a given season. A League consists of a list of teams, and a list of matchdays. E.g. for the 1. Bundesliga, there are 18 teams and 23 matchdays. It has an optional refresh forceRefresh parameter, which can be used to refresh the data from the external data source. Otherwise the return value is cached.
 * `/teams/{season}` returns the list of teams for the given season.
 * `/matchday/{season}` returns all matchdays for the given season. It has an optional refresh forceRefresh parameter, which can be used to refresh the data from the external data source. Otherwise the return value is cached.
 * `/matchday/{season}/{day}` returns the matches for the given matchday of the given season.
 
## Data format

The JSON data structures are in the following format: (More info can be found in 'LeagueData.java') 
 * League contains an ID, a list of teams and a list of matchdays
 * Team contains an ID and a name
 * Matchday contains a list of matches
 * Match contains the match ID, two teams, two Results (halftime and end result) and a match date.
 * Result contains the goals for team 1 and the goals for team 2.
 
 