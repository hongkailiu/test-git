package tk.hongkailiu.test.webapp.cxf.service;

import org.apache.cxf.jaxrs.client.Client;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.*;
import tk.hongkailiu.test.webapp.cxf.service.impl.PersonServiceSRestImpl;
import tk.hongkailiu.test.webapp.cxf.vo.Person;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import static org.junit.Assert.assertNotNull;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:client-cxf-sei.xml")
public class PersonServiceSRestIT {

	private final static String BASE_ADDRESS = "http://localhost:10001/test-webapp/services/srest";

	// @Autowired
	// @Qualifier("restClient")
	//private PersonServiceRestImpl proxy;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected=WebApplicationException.class)
	public void testWithWebClient1() {
		PersonServiceSRestImpl proxy = JAXRSClientFactory.create(BASE_ADDRESS,
				PersonServiceSRestImpl.class);

		ClientOutInterceptor clientOutInterceptor = new ClientOutInterceptor(
				"admin", "123e456");
		ClientConfiguration config = WebClient.getConfig(proxy);
		config.getOutInterceptors().add(clientOutInterceptor);

		Client client = WebClient.client(proxy);
		WebClient webClient = WebClient.fromClient(client);
		webClient.path("/person/3").type(MediaType.APPLICATION_XML_TYPE)
				.accept(MediaType.APPLICATION_XML_TYPE);
		webClient.get(Person.class);
		
	}

	@Test
	public void testWithWebClient2() {

		PersonServiceSRestImpl proxy = JAXRSClientFactory.create(BASE_ADDRESS,
				PersonServiceSRestImpl.class);

		ClientOutInterceptor clientOutInterceptor = new ClientOutInterceptor(
				"admin", "123456");

		// WebClient client = WebClient.create(BASE_ADDRESS);
		// WebClient.getConfig(client).getOutInterceptors().add(clientOutInterceptor);

		ClientConfiguration config = WebClient.getConfig(proxy);
		config.getOutInterceptors().add(clientOutInterceptor);

		Client client = WebClient.client(proxy);
		WebClient webClient = WebClient.fromClient(client);
		webClient.path("/person/3").type(MediaType.APPLICATION_XML_TYPE)
				.accept(MediaType.APPLICATION_XML_TYPE);
		final Person person = webClient.get(Person.class);
		assertNotNull(person);
	}

}
