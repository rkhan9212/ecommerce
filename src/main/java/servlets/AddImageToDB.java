package servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@WebServlet(urlPatterns={"/AddImageToDB"})
@MultipartConfig(maxRequestSize=1024*1024*25)
public class AddImageToDB extends HttpServlet{

	private String extractFileName(Part part) {
	    String contentDisp = part.getHeader("content-disposition");
	    String[] items = contentDisp.split(";");
	    for (String s : items) {
	        if (s.trim().startsWith("filename")) {
	            return s.substring(s.indexOf("=") + 2, s.length()-1);
	        }
	    }
	    return "";
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Part p = req.getPart("kaddu");
		
		System.out.println(p.getSize());
		System.out.println(p.getContentType());
		System.out.println( "Original File Name: " + this.extractFileName(p) );
		
		String currPath = req.getRealPath("/");
		
		System.out.printf(" Curr Path: %s\n",currPath);
		
		File f = new File( currPath + "/" + this.extractFileName(p) );
		
		if( !f.exists() ){
			f.createNewFile();
		}
		
		byte b[] = new byte[ (int)p.getSize() ];
		
		p.getInputStream().read(b);
		
		FileOutputStream fos = new FileOutputStream(f);
		
		fos.write(b);
		
		fos.close();
		
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				  "cloud_name", "dkatvt5ae",
				  "api_key", "739479476772532",
				  "api_secret", "um-dQdBtosrMhlL_kFQiCoydWic"));
		
		Map uploadResult = cloudinary.uploader().upload( f , ObjectUtils.emptyMap());
	
		System.out.println(uploadResult.get("secure_url"));
	}	
	
}
