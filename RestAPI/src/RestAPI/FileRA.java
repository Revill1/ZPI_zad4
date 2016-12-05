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
	@Consumes(MediaType.APPLICATION_OCTET_STREAM)
	public Response getFile(String url) throws IOException {
		
		FileLibrary fileLibrary = new FileLibrary();
		String path = "C:\\Users\\Adam\\Desktop\\files\\" + "pliczek";
		
		fileLibrary.DownloadFileFromRoute(url, path);
		File file = new File("C:\\Users\\Adam\\Desktop\\files\\pliczek"); 
		
		FileInputStream fis = new FileInputStream(file);
		byte[] b = new byte [1024];
		fis.read(b);
		fis.close();
		
		return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM).status(201).build();	
	}
}
