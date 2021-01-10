# Microservices
Learning Microservices

Commits:

  1) Initial Commit
      Created 3 microservices : MovieCatalogService, MovieInfoService, RatingsDataService
      MovieCatalogService calls RatingsDataService API to get rating of a particular movie and MovieInfoService API to get name and description of that movie
      MovieInfoService calls an external API called MovidDB to get real time movies information
      RatingsDataService contains hardcodded data for ratings of different movie id
      
      DiscoveryServer is used to help MovieCatalogService find the MovieInfoService and RatingsDataService microservices dynamically. 
      The DiscoveryServer used here is a Eureka Server
