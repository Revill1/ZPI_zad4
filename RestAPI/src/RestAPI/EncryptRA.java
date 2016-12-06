package RestAPI;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import src.ApiChecksum;
import src.ApiCyphering;
import Http.ApiHttp;
import Library.FileLibrary;
import ZipArchive.*;

@Path("/encrypt")
public class EncryptRA 
{
	@Path("string")
	@POST
	@Consumes("text/plain")
	public Response getCheckSumSHA(String c) throws NoSuchAlgorithmException 
	{
		KeyGenerator kGen;
		String afterDecrypt = null;
		try {
			kGen = KeyGenerator.getInstance("AES");
			kGen.init(128);
			SecretKey sKey = kGen.generateKey();
			byte[] rawKeys = sKey.getEncoded();
			String encryptString = c;
			String algorythmType = "AES";
			byte[] toDecrypt = encryptString.getBytes();
			afterDecrypt = ApiCyphering.decrypt(toDecrypt, rawKeys, algorythmType);
			System.out.println(afterDecrypt);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Response.ok(afterDecrypt,"text/plain").status(201).build();
	}
}
