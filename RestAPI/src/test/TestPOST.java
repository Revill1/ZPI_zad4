package test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestPOST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  try {

		        Client client = Client.create();

		        WebResource webResource = client.resource("http://localhost:8000/RestAPI/crunchify/file/url");

		        String input = "{\"message\":\"Hello\"}";

		        ClientResponse response = webResource.type("application/json")
		           .post(ClientResponse.class, input);

		        if (response.getStatus() != 201) {
		            throw new RuntimeException("Failed : HTTP error code : "
		                 + response.getStatus());
		        }

		        System.out.println("Output from Server .... \n");
		        String output = response.getEntity(String.class);
		        System.out.println(output);

		      } catch (Exception e) {

		        e.printStackTrace();

		      }
	}

}
