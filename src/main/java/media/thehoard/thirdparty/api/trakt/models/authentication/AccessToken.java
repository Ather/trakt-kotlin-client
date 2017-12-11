package media.thehoard.thirdparty.api.trakt.models.authentication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccessToken extends AbstractToken {
	@SerializedName("code")
	@Expose
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public AbstractToken withCode(String code) {
		this.code = code;
		return this;
	}
}
