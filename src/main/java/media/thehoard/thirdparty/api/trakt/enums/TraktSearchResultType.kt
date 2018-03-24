package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktSearchResultType constructor(val value: Int = 0, val objectName: String = "", val uriName: String = "", val displayName: String = "Unspecified") {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("movie")
    MOVIE(1, "movie", "movie", "Movie"),
    @SerializedName("show")
    SHOW(2, "show", "show", "Show"),
    @SerializedName("episode")
    EPISODE(4, "episode", "episode", "Episode"),
    @SerializedName("person")
    PERSON(8, "person", "person", "Person"),
    @SerializedName("list")
    LIST(16, "list", "list", "List")

    /*
	public TraktSearchResultType join(TraktSearchResultType second) {
		return join(this, second);
	}

	public static TraktSearchResultType join(TraktSearchResultType first, TraktSearchResultType second) {
		if(first == null || second == null)
			return null;

		if (first.equals(UNSPECIFIED) || second.equals(UNSPECIFIED))
			return UNSPECIFIED;

		int newValue = first.value | second.value;
		String newObjectName = String.join(",", first.objectName, second.objectName);
		String newUriName = String.join(",", first.uriName, second.uriName);
		String newDisplayName = String.join(",", first.displayName, second.displayName);

		return new TraktSearchResultType(newValue, newObjectName, newUriName, newDisplayName);
	}*/
}
