package ch07;
import javax.servlet.http.HttpServletRequest;

public class MyUtil {

	public static int parseInt(HttpServletRequest request, 
			String name) {
		return Integer.parseInt(request.getParameter(name));
	}

}
