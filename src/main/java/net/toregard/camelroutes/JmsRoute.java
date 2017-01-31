package net.toregard.camelroutes;

//@Configuration
public class JmsRoute {
//    @Autowired
//    RestTemplate restTemplate;
//
//    @Autowired
//    CVPingLogRepository quoteRepository;
//
//    @Value("${jsonUrl}")
//    String jsonUrl;
//
//    private static final Logger log = LoggerFactory.getLogger(JmsRoute.class);
//
//
//    @Bean
//    RouteBuilder myRouter() {
//        return new RouteBuilder() {
//            @Override
//            public void configure() throws Exception {
//
//                from("{{in.iso20022.pain001}}").
//                        routeId("{{in.iso20022.pain001}}").
//                        process(new Processor() {
//                            public void process(Exchange exchange) throws Exception {
//                                String body = (String)exchange.getIn().getBody();
//                                System.out.println("**Handle paint001**");
//                                System.out.println(body);
//                                System.out.println("*****************");
//                                List<CVPingLog> liste = getJsonData();
//                                List<CVPingLog> result =liste.stream().
//                                        filter(x -> x.getId().startsWith("u")).collect(Collectors.toList());
//                                System.out.println("Starter på u: "+result);
//                                for(CVPingLog q : result){
//                                    quoteRepository.save(q);
//                                }
//                            }
//                        });
//            }
//        };
//    }

//    List<CVPingLog> getJsonData(){
//        CVPingLog[] quote = restTemplate.getForObject(jsonUrl, CVPingLog[].class);
//        log.info(Arrays.asList(quote).toString());
//        return Arrays.asList(quote);
//    }

}

