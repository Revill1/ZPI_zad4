package RestAPI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Library.FileLibrary;

@Path("/file")
public class FileRA {

	@Path("url")
	@POST
	@Consumes("text/plain")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFile(String url) throws IOException {
		 String result = "Data post: "+url;
/*
		FileLibrary fileLibrary = new FileLibrary();
		String path = "C:\\Users\\Adam\\Desktop\\files\\" + "pliczek";
	
	//	url = "http://mmajchr.kis.p.lodz.pl/zpi2/zadania/3a.txt";
		
		fileLibrary.DownloadFileFromRoute("http://mmajchr.kis.p.lodz.pl/zpi2/zadania/3a.txt", path);
		File file = new File("C:\\Users\\Adam\\Desktop\\files\\pliczek"); 
		
		FileInputStream fis = new FileInputStream(file);
		byte[] b = null;
		fis.read(b);
		
		if(null != file)
		{
			System.out.println(b.toString());
		}
		else
		{
			System.out.println("file not ok");
		}
				  return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
				      .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" ) //optional
				      .build();	*/
				return  Response.status(201).entity(result).build(); 
	}
}
