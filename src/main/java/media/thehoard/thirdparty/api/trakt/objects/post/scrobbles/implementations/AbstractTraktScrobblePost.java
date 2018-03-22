package media.thehoard.thirdparty.api.trakt.objects.post.scrobbles.implementations;

import com.google.gson.annotations.SerializedName;

public abstract class AbstractTraktScrobblePost {
	private float progress;
	@SerializedName("app_version")
	private String appVersion;
	@SerializedName("app_date")
	private String appDate;
}
