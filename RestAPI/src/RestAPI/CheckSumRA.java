package RestAPI;

import java.security.NoSuchAlgorithmException;

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

@Path("/checkSumAPI")
public class CheckSumRA 
{		
	@Path("SHA/{c}")
	@GET
	@Produces("application/xml")
	public String getCheckSumSHA(@PathParam("c") String c) throws NoSuchAlgorithmException {
		String t = c;
		String sum;
		sum = ApiChecksum.createSum(t, "SHA");

		String result = "suma kontrolna dla slowa "+t+" dla algorytmu SHA : \n\n\n\n" + sum;
		return "<ApiChecksum>" + "<text>" + t + "</text>" + "<checkSum>" + result + "</checkSum>" + "</ApiChecksum>";
	}
	
	@Path("MD5/{c}")
	@GET
	@Produces("application/xml")
	public String getCheckSumMD5(@PathParam("c") String c) throws NoSuchAlgorithmException {
		String t = c;
		String sum;
		sum = ApiChecksum.createSum(t, "MD5");

		String result = "suma kontrolna dla slowa "+t+" dla algorytmu MD5 : \n\n\n\n" + sum;
		return "<ApiChecksum>" + "<text>" + t + "</text>" + "<checkSum>" + result + "</checkSum>" + "</ApiChecksum>";
	}
}
