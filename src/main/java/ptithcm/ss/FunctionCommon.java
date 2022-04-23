package ptithcm.ss;

import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FunctionCommon {
	public static Integer getMaxID(SessionFactory factory, String nameTable) {
		Session session = factory.openSession();
		String hql = "SELECT MAX(id" + nameTable + ") FROM " + nameTable;
		Query query = session.createQuery(hql);
		Integer max = query.getFirstResult();
		return max;
	}

	public static String normalizeName(String name) {
		String result = "";
		String arr[] = name.trim().split(" ");
		for (String k : arr) {
			result += k.substring(0, 1).toUpperCase() + k.substring(1).toLowerCase() + " ";
		}
		return result.trim();
	}

	public static Date toDate(String x) {
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(x);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String covertToEng(String value) {
	      try {
	            String temp = Normalizer.normalize(value, Normalizer.Form.NFD);
	            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	            return pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replace("đ", "");
	     } catch (Exception ex) {
	            ex.printStackTrace();
	      }
	      return null;
	}
}
