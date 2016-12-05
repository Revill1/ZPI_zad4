package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestPOST {

	public static void main(String[] args) {
		  try {
			  	BufferedReader br = null;
				FileReader fr = null;
		        Client client = Client.create();
		      
		        WebResource webResource = client.resource("http://localhost:8000/RestAPI/crunchify/file/url");
		        String input = "http://mmajchr.kis.p.lodz.pl/zpi2/zadania/3a.txt";
		        ClientResponse response = webResource.type(MediaType.APPLICATION_OCTET_STREAM)
		           .post(ClientResponse.class, input);

		        if (response.getStatus() != 201)
		        {
		            throw new RuntimeException("Failed : HTTP error code : "
		                 + response.getStatus());
		        }

		        System.out.println("Output from Server .... \n");
		        File output = response.getEntity(File.class);
		        
		        String sCurrentLine;
				fr = new FileReader(output);
				br = new BufferedReader(fr);

				while ((sCurrentLine = br.readLine()) != null)
				{
					System.out.println(sCurrentLine);
				}

		        System.out.println(output);
		        br.close();
		  } 
		  catch (Exception e) 
		  {
			  e.printStackTrace();
	      }
	}

}
