package com.zqxq.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
public String doMd5(String param){
	byte[] hash;
	  try
	    {
	      hash = MessageDigest.getInstance("MD5").digest(param.getBytes("UTF-8"));
	    }
	  catch (NoSuchAlgorithmException e)
	    {
	      e.printStackTrace();
	      return "";
	    }
	    catch (UnsupportedEncodingException e)
	    {
	      e.printStackTrace();
	      return "";
	    }
	      StringBuilder localStringBuilder = new StringBuilder(hash.length * 2);
	      for (byte b : hash)
	      {
	        
	        if ((b & 0xFF) < 0x10) {
	          localStringBuilder.append("0");
	        }
	        localStringBuilder.append(Integer.toHexString(b & 0xFF));
	      }
	      System.out.println("MD5:"+localStringBuilder.toString());
	      
	      return localStringBuilder.toString();
	    }
	   
}
