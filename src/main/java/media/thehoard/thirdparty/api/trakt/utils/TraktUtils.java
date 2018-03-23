package media.thehoard.thirdparty.api.trakt.utils;

public class TraktUtils {

	public static boolean isNullOrEmpty(String str) {
		if (str != null)
			return str.length() == 0;
		return true;
	}
}
