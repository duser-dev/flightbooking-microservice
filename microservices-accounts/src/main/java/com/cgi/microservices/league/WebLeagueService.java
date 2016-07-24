package com.cgi.microservices.league;

/**
 * Hide the access to the microservice inside this local service.
 * 
 * @author Paul Chapman
 */
// @Service
public class WebLeagueService {

	// @Autowired
	// protected RestTemplate restTemplate;
	//
	// protected String serviceUrl;
	//
	// protected Logger logger =
	// Logger.getLogger(WebLeagueService.class.getName());
	//
	// public WebLeagueService(String serviceUrl) {
	// this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://"
	// + serviceUrl;
	// }
	//
	// // /**
	// // * Default Constructor
	// // */
	// // public WebLeagueService() {
	// // // we do just nothing....
	// // }
	//
	// /**
	// * The RestTemplate works because it uses a custom request-factory that
	// uses
	// * Ribbon to look-up the service to use. This method simply exists to show
	// * this.
	// */
	// @PostConstruct
	// public void demoOnly() {
	// // Can't do this in the constructor because the RestTemplate injection
	// // happens afterwards.
	// // logger.warning("The RestTemplate request factory is " +
	// // restTemplate.getRequestFactory());
	// logger.warning("ahhhhhhhh");
	// }
	//
	// @SuppressWarnings("unchecked")
	// public League findByYear(String yearNumber) {
	// logger.info("findByNumber() invoked: for " + yearNumber);
	// logger.info("Invoking REST Service at : " + serviceUrl + "/teams/" +
	// yearNumber);
	//
	// List teams = restTemplate.getForObject(serviceUrl + "/teams/{number}",
	// List.class, yearNumber);
	// League aLeague;
	//
	// if (teams == null) {
	// logger.warning("repsonse is emtpy...");
	// return null;
	// } else {
	// aLeague = new League();
	// for (int i = 0; i < teams.size(); i++) {
	// LinkedHashMap<String, String> aTeam = (LinkedHashMap<String, String>)
	// teams.get(i);
	// Team lokalTeam = new Team();
	// logger.info(aTeam.toString());
	// logger.info("a key" + aTeam.keySet().toArray()[0]);
	// logger.info("a val" + aTeam.keySet().toArray()[1]);
	//
	// String id = (String) aTeam.keySet().toArray()[0];
	// String name = (String) aTeam.keySet().toArray()[1];
	//
	// //
	// // warum auch immer mag er hier kein Integer...
	// Object tmpId = aTeam.get(id);
	//
	// logger.info("key: " + tmpId);
	//
	// lokalTeam.setId(tmpId.toString());
	// lokalTeam.setName(aTeam.get(name));
	//
	// logger.info("key: " + lokalTeam.getId() + " value: " +
	// lokalTeam.getName());
	// aLeague.addTeam(lokalTeam);
	// }
	// }
	//
	// logger.info(teams.toString());
	//
	// return aLeague;
	// }

}
