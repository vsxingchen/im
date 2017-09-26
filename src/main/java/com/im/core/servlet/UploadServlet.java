package com.im.core.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.im.utils.GenerateUUID;
import com.im.utils.JsonUtil;
import com.im.utils.ReadXml;



/**
 * 上传图片Servlet
 * @author Administrator
 *
 */
public class UploadServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Map<String,Object> map=new HashMap<String,Object>();

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(2048*1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		
		String paths = req.getSession().getServletContext().getRealPath("/"); 
        String  xmlFile = paths + "/WEB-INF/url.xml";
        ReadXml rdxml = new ReadXml(xmlFile);
        String path = rdxml.getPath();	
		String imageUrl=rdxml.getHttpurl();
		
		
	/*	String path=Constants.upFilePath;
		String imageUrl=Constants.imageUrl;*/
		String type=null;
		try {
			List formList = upload.parseRequest(req);
			Iterator<Object> formItem = formList.iterator();

			while (formItem.hasNext()) {
				FileItem item = (FileItem) formItem.next();
				//if (item.isFormField()) {
					System.out.println("Field Name:" + item.getFieldName());
					type=item.getFieldName();
			//	} else {
                     StringBuffer buf=new StringBuffer("");
                     File wjj=new File(path);
                   	 //判断上传+文件夹是否存在，不存在创建
                   	 if(!wjj.exists()){
                   		 wjj.mkdir();
                   	 }
                   	buf.append(path+"/"+type);
                   	imageUrl=imageUrl+"/"+type;
                  	wjj=new File(buf.toString());
                  	if(!wjj.exists()){
                  		wjj.mkdir();
                  	}
                    buf.append("/").append(new SimpleDateFormat("yyyy").format(new Date()));
                    imageUrl=imageUrl+"/"+new SimpleDateFormat("yyyy").format(new Date());
                 	 wjj=new File(buf.toString());
                 	 //判断月文件夹是否存在，不存在创建
                 	 if(!wjj.exists()){
                 		 wjj.mkdir();
                 	 }
                 	 buf.append("/").append(new SimpleDateFormat("MM").format(new Date()));
                 	 wjj=new File(buf.toString());
                 	imageUrl=imageUrl+"/"+new SimpleDateFormat("MM").format(new Date());
                 	 //判断月文件夹是否存在，不存在创建
                 	 if(!wjj.exists()){
                 		 wjj.mkdir();
                 	 }
                 	 
					String att=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
					String fileName = GenerateUUID.getUUID()+item.getName().substring(item.getName().lastIndexOf("."));
					File file = new File(buf.toString()+ "/" + fileName);
					
					OutputStream out = item.getOutputStream();
					InputStream in = item.getInputStream();
					req.getSession().setAttribute("outPutStream", out);
					req.getSession().setAttribute("inPutStream", in);
					item.write(file);
					in.close();
					out.close();
				
					map.put("imageUrl", imageUrl+"/" + fileName);
					map.put("imageName",fileName.substring(0, fileName.lastIndexOf(".")));
					map.put("fileUrl", buf.toString()+"/" + fileName);
					JsonUtil.writeJSON(map, resp, 200, "success");
				}
		//	}
		} catch (FileUploadException e2) {
			e2.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
