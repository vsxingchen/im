package com.im.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ReadXml {
	private String httpurl;
	private String path;
	private String thumbnail;
	private String image;
	private String thumbnailUploadPath;
	 
	 
	 
	 public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getThumbnailUploadPath() {
		return thumbnailUploadPath;
	}

	public void setThumbnailUploadPath(String thumbnailUploadPath) {
		this.thumbnailUploadPath = thumbnailUploadPath;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getHttpurl() {
		return httpurl;
	}

	public void setHttpurl(String httpurl) {
		this.httpurl = httpurl;
	}


	public ReadXml(String fileName){
	  DocumentBuilderFactory domfac=DocumentBuilderFactory.newInstance();
	  try {
	   DocumentBuilder dombuilder=domfac.newDocumentBuilder();
	   InputStream is=new FileInputStream(fileName);
	   Document doc=dombuilder.parse(is);
	   Element root=doc.getDocumentElement();
	   NodeList dbinfo=root.getChildNodes();
	   if(dbinfo!=null){
	    for(int i=0;i<dbinfo.getLength();i++){
	     Node db=dbinfo.item(i);
	       for(Node node=db.getFirstChild();node!=null;node=node.getNextSibling()){
	        if(node.getNodeType()==Node.ELEMENT_NODE){
	         if(node.getNodeName().equals("httpurl")){
	          setHttpurl(node.getFirstChild().getNodeValue());
	         }else if(node.getNodeName().equals("image")){
	        	 setImage(node.getLastChild().getNodeValue());
	         }else if(node.getNodeName().equals("thumbnail")){
	        	 setThumbnail(node.getLastChild().getNodeValue());
	         }else if(node.getNodeName().equals("thumbnailUploadPath")){
	        	 setThumbnailUploadPath(node.getLastChild().getNodeValue());
	         }else if(node.getNodeName().equals("path")){
	        	 setPath(node.getLastChild().getNodeValue());
	         }
	        }
	      }        
	       }       
	     }
	  } catch (ParserConfigurationException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  } catch (FileNotFoundException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  } catch (SAXException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  } catch (IOException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }  
	 } 
}
