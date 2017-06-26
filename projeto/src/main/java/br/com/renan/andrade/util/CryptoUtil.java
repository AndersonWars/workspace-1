package br.com.renan.andrade.util;

import java.io.*;
import java.security.*;

public class CryptoUtil {
	
	public static byte[] generateCryptedPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] message = md.digest(password.getBytes("UTF-8"));
			return message;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
