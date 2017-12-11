package media.thehoard.thirdparty.api.trakt.models.authentication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RefreshToken extends AbstractToken {

	@SerializedName("refresh_token")
	@Expose
	private String refreshToken;

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public AbstractToken withCode(String refreshToken) {
		this.refreshToken = refreshToken;
		return this;
	}
}
