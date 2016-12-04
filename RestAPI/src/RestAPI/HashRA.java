package RestAPI;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import src.ApiChecksum;
import src.ApiCyphering;
import Http.ApiHttp;
import Library.FileLibrary;
import ZipArchive.*;

import src.ApiChecksum;

@Path("/HashAPI")
public class HashRA 
{
	@Path("Hash/{c}")
	@GET
	@Produces("application/xml")
	public String getCheckSumSHA(@PathParam("c") String c) 
	{
		String strToEncrypt = c;
		KeyGenerator kGen;
		String hashKey = null;
		try 
		{
			kGen = KeyGenerator.getInstance("AES");
			kGen.init(128);
			SecretKey sKey = kGen.generateKey();
			byte[] key = sKey.getEncoded();
			byte[] cipher;
			cipher = ApiCyphering.encrypt(strToEncrypt, key, "AES");
			hashKey = cipher.toString();
		}
		catch (NoSuchAlgorithmException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String result = "klucz hash dla "+strToEncrypt+" : \n\n\n\n" + hashKey;
		return "<ApiHash>" + "<text>" + strToEncrypt + "</text>" + "<hashKey>" + result + "</hashKey>" + "</ApiHash>";
	}
}
