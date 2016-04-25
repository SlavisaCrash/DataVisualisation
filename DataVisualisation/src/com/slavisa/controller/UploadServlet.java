package com.slavisa.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.slavisa.model.Image;


/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		String content="";

		 if(isMultipart){
			 
		        FileItemFactory factory = new DiskFileItemFactory();
		        ServletFileUpload upload = new ServletFileUpload(factory);
		       
		        List<FileItem> items = null;
				
						try {
							items = upload.parseRequest(request);
						} catch (FileUploadException e) {
							e.printStackTrace();			            	 
						}
 
		        Iterator<FileItem> iter = items.iterator();
		        while (iter.hasNext()){
		            
		        	FileItem item = iter.next();
		        	
		        	if(!(item.getName()).equals("")){
		        		
			            if(!extractExtensionOfFile(item.getName()).equals(".csv")){
			            	 request.setAttribute("message", "The file must be .csv");
			            }else{
			            	if(!item.isFormField()){
				                 BufferedInputStream buff = new BufferedInputStream(item.getInputStream());
				                 byte[] bytes = new byte[buff.available()];
				                 buff.read(bytes,0,bytes.length);
				                 content = new String(bytes);
				                 request.setAttribute("message", "Upload successful!");
				            }
			            }
		        	}else{
		        		request.setAttribute("message", "No file choosen!");
		        	}          
		          }
		       
		        Image image = new Image();
		        image.generateImage(28, 28, content);
		        request.setAttribute("images", image.getImages());
		     }
		    RequestDispatcher rd = request.getRequestDispatcher("upload.jsp");
			rd.forward(request, response);
	}
	public String extractExtensionOfFile(String fileName){
		
		fileName.trim();
		if(!fileName.equals("")){
			return fileName = fileName.substring(fileName.lastIndexOf("."),fileName.length());
		}
		return null;
	}
	
}
