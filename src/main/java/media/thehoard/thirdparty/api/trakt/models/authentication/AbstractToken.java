package media.thehoard.thirdparty.api.trakt.models.authentication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class AbstractToken {

	@SerializedName("client_id")
	@Expose
	private String clientId;
	@SerializedName("client_secret")
	@Expose
	private String clientSecret;
	@SerializedName("redirect_uri")
	@Expose
	private String redirectUri;
	@SerializedName("grant_type")
	@Expose
	private String grantType;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public AbstractToken withClientId(String clientId) {
		this.clientId = clientId;
		return this;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public AbstractToken withClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
		return this;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public AbstractToken withRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
		return this;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public AbstractToken withGrantType(String grantType) {
		this.grantType = grantType;
		return this;
	}

}