package media.thehoard.thirdparty.api.trakt.enums


import com.google.gson.annotations.SerializedName

enum class TraktSearchField(val value: Int = 0, val objectName: String = "", val uriName: String = "", val displayName: String = "Unspecified") {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("title")
    TITLE(1, "title", "title", "Title"),
    @SerializedName("tagline")
    TAGLINE(2, "tagline", "tagline", "Tagline"),
    @SerializedName("overview")
    OVERVIEW(4, "overview", "overview", "Overview"),
    @SerializedName("people")
    PEOPLE(8, "people", "people", "People"),
    @SerializedName("translations")
    TRANSLATIONS(16, "translations", "translations", "Translations"),
    @SerializedName("aliases")
    ALIASES(32, "aliases", "aliases", "Aliases"),
    @SerializedName("name")
    NAME(64, "name", "name", "Name"),
    @SerializedName("biography")
    BIOGRAPHY(128, "biography", "biography", "Biography"),
    @SerializedName("description")
    DESCRIPTION(256, "description", "description", "Description")

    /*
	public TraktSearchField join(TraktSearchField second) {
		return join(this, second);
	}

	public static TraktSearchField join(TraktSearchField first, TraktSearchField second) {
		if(first == null || second == null)
			return null;

		if (first.equals(UNSPECIFIED) || second.equals(UNSPECIFIED))
			return UNSPECIFIED;

		int newValue = first.value | second.value;
		String newObjectName = String.join(",", first.objectName, second.objectName);
		String newUriName = String.join(",", first.uriName, second.uriName);
		String newDisplayName = String.join(",", first.displayName, second.displayName);

		return new TraktSearchField(newValue, newObjectName, newUriName, newDisplayName);
	}*/
}
