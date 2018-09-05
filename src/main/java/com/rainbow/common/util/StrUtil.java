package com.rainbow.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @author Ray
 *
 *         Sep 15, 2015
 */
public class StrUtil {

	public static String parseToHex(String str) {

		if (str != null && !str.equals("")) {

			byte[] plainText;
			try {
				plainText = str.getBytes("UTF-8");
				MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
				messageDigest.update(plainText);
				byte[] digest = messageDigest.digest();

				StringBuilder stringBuilder = new StringBuilder("");

				if (digest == null || digest.length <= 0) {
					return null;
				}
				for (int i = 0; i < digest.length; i++) {
					int v = digest[i] & 0xFF;
					String hv = Integer.toHexString(v);
					if (hv.length() < 2) {
						stringBuilder.append(0);
					}
					stringBuilder.append(hv);
				}
				return stringBuilder.toString().toUpperCase();

			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public static String hideName(String name) {
		return name != null ? (name.trim().length() < 3 ? name.substring(0, 1) + "*" : name.substring(0, 1) + "*") : "";
	}

	public static String cutString(String str, int max, String instead) {
		if (str != null && str.length() > max) {
			return str.substring(0, max) + (instead == null ? "" : instead);
		} else {
			return str;
		}
	}

	public static String toLowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	public static String toUpperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	public static Boolean hasValue(String str) {
		return (str != null && !str.equals(""));
	}

	public static String translatePartString(String s) {
		return s.replaceAll("[^a-zA-Z0-9]", "");
	}

	public static class Charset {
		public static final String US_ASCII = "US-ASCII";

		public static final String ISO_8859_1 = "ISO-8859-1";

		public static final String UTF_8 = "UTF-8";

		public static final String UTF_16BE = "UTF-16BE";

		public static final String UTF_16LE = "UTF-16LE";

		public static final String UTF_16 = "UTF-16";

		public static final String GBK = "GBK";

		public static String changeCharset(String str, String newCharset) throws UnsupportedEncodingException {
			if (str != null) {
				byte[] bs = str.getBytes();
				return new String(bs, newCharset);
			}
			return null;
		}

		public static String changeCharset(String str, String oldCharset, String newCharset)
				throws UnsupportedEncodingException {
			if (str != null) {
				byte[] bs = str.getBytes(oldCharset);
				return new String(bs, newCharset);
			}
			return null;
		}
	}
	
	public static String getPinYin(String src) {
		char[] t1 = null;
		t1 = src.toCharArray();
		String[] t2 = new String[t1.length];
		HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
		t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		t3.setVCharType(HanyuPinyinVCharType.WITH_V);
		String t4 = "";
		int t0 = t1.length;
		try {
			for (int i = 0; i < t0; i++) {
				if (Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")) {
					t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
					t4 += t2[0];
				} 
				else if(Character.toString(t1[i]).equalsIgnoreCase(".")) {
					t4 += Character.toString(t1[i]);
				}else if(Character.toString(t1[i]).matches("^[A-Za-z0-9]")){
					t4 += Character.toString(t1[i]);
				}
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			e.printStackTrace();
		}
		return t4;
	}
	

	
	public static String getPinYinHeadChar(String str) {
		String convert = "";
		for (int j = 0; j < str.length(); j++) {
			char word = str.charAt(j);
			String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
			if (pinyinArray != null) {
				convert += pinyinArray[0].charAt(0);
			} else {
				convert += word;
			}
		}
		return convert;
	}

}
