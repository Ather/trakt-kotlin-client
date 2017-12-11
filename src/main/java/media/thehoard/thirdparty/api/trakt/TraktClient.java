package media.thehoard.thirdparty.api.trakt;

public class TraktClient {
	public Authentication authentication() {
		return new Authentication();
	}

	public class Authentication {
		public OAuth oAuth() {
			return new OAuth();
		}

		public class OAuth {
			public Authorize authorize() {
				return new Authorize();
			}

			public class Authorize {
				public void get() {

				}
			}

			public Token token() {
				return new Token();
			}

			public class Token {
				public void get() {

				}

				public void delete() {

				}
			}

			public Device device() {
				return new Device();
			}

			public class Device {
				public Code code() {
					return new Code();
				}

				public class Code {
					public void get() {

					}
				}

				public Token token() {
					return new Token();
				}

				public class Token {
					public void get() {

					}
				}
			}
		}
	}

	public Calendars calendars() {
		return new Calendars();
	}

	public class Calendars {
		protected class Common {
			public Shows show() {
				return new Shows();
			}

			public class Shows {
				public void get() {

				}

				public New newShows() {
					return new New();
				}

				public class New {
					public void get() {

					}
				}

				public Premieres premieres() {
					return new Premieres();
				}

				public class Premieres {
					public void get() {

					}
				}
			}

			public Movies movies() {
				return new Movies();
			}

			public class Movies {
				public void get() {

				}
			}

			public Dvd dvd() {
				return new Dvd();
			}

			public class Dvd {
				public void get() {

				}
			}
		}

		public My my() {
			return new My();
		}

		public class My {
			//TODO
		}

		public All all() {
			return new All();
		}

		public class All {
			//TODO
		}
	}

	public Checkin checkin() {
		return new Checkin();
	}

	public class Checkin {
		public void post() {

		}

		public void delete() {

		}
	}

	public Certifications certifications() {
		return new Certifications();
	}

	public class Certifications {
		public void get() {

		}
	}

	public Comments comments() {
		return new Comments();
	}

	public class Comments {
		public void post() {

		}

		public void get() {

		}

		public void update() {

		}

		public void delete() {

		}

		public Replies replies() {
			return new Replies();
		}

		public class Replies {
			public void get() {

			}

			public void post() {

			}
		}

		public Like like() {
			return new Like();
		}

		public class Like {
			public void post() {

			}

			public void delete() {

			}
		}
	}

	public Genres genres() {
		return new Genres();
	}

	public class Genres {
		public void get() {

		}
	}

	public Movies movies() {
		return new Movies();
	}

	public class Movies {
		public Trending trending() {
			return new Trending();
		}

		public class Trending {
			public void get() {

			}
		}

		public Popular popular() {
			return new Popular();
		}

		public class Popular {
			public void get() {

			}
		}

		public Played played() {
			return new Played();
		}

		public class Played {
			public void get() {

			}
		}

		public Watched watched() {
			return new Watched();
		}

		public class Watched {
			public void get() {

			}
		}

		public Collected collected() {
			return new Collected();
		}

		public class Collected {
			public void get() {

			}
		}

		public Anticipated anticipated() {
			return new Anticipated();
		}

		public class Anticipated {
			public void get() {

			}
		}

		public BoxOffice boxOffice() {
			return new BoxOffice();
		}

		public class BoxOffice {
			public void get() {

			}
		}

		public Updates updates() {
			return new Updates();
		}

		public class Updates {
			public void get() {

			}
		}

		public Summary summary() {
			return new Summary();
		}

		public class Summary {
			public void get() {

			}
		}

		public Aliases aliases() {
			return new Aliases();
		}

		public class Aliases {
			public void get() {

			}
		}

		public Releases releases() {
			return new Releases();
		}

		public class Releases {
			public void get() {

			}
		}

		public Translations translations() {
			return new Translations();
		}

		public class Translations {
			public void get() {

			}
		}

		public Comments comments() {
			return new Comments();
		}

		public class Comments {
			public void get() {

			}
		}

		public Lists lists() {
			return new Lists();
		}

		public class Lists {
			public void get() {

			}
		}

		public People people() {
			return new People();
		}

		public class People {
			public void get() {

			}
		}

		public Ratings ratings() {
			return new Ratings();
		}

		public class Ratings {
			public void get() {

			}
		}

		public Related related() {
			return new Related();
		}

		public class Related {
			public void get() {

			}
		}

		public Stats stats() {
			return new Stats();
		}

		public class Stats {
			public void get() {

			}
		}

		public Watching watching() {
			return new Watching();
		}

		public class Watching {
			public void get() {

			}
		}
	}

	public Networks networks() {
		return new Networks();
	}

	public class Networks {
		public List list() {
			return new List();
		}

		public class List {
			public void get() {

			}
		}
	}

	public People people() {
		return new People();
	}

	public class People {
		public Summary summary() {
			return new Summary();
		}

		public class Summary {
			public void get() {

			}
		}

		public Movies movies() {
			return new Movies();
		}

		public class Movies {
			public void get() {

			}
		}

		public Shows shows() {
			return new Shows();
		}

		public class Shows {
			public void get() {

			}
		}
	}

	public Recommendations recommendations() {
		return new Recommendations();
	}

	public class Recommendations {
		public Movies movies() {
			return new Movies();
		}

		public class Movies {
			public void get() {

			}

			public void delete() {

			}
		}

		public Shows shows() {
			return new Shows();
		}

		public class Shows {
			public void get() {

			}

			public void delete() {

			}
		}
	}

	public Scrobble scrobble() {
		return new Scrobble();
	}

	public class Scrobble {
		public void start() {

		}

		public void pause() {

		}

		public void stop() {

		}
	}

	public Search search() {
		return new Search();
	}

	public class Search {
		public Text text() {
			return new Text();
		}

		public class Text {
			public void get() {

			}
		}

		public Id id() {
			return new Id();
		}

		public class Id {
			public void get() {

			}
		}
	}

	public Shows shows() {
		return new Shows();
	}

	public class Shows {
		public Trending trending() {
			return new Trending();
		}

		public class Trending {
			public void get() {

			}
		}

		public Popular popular() {
			return new Popular();
		}

		public class Popular {
			public void get() {

			}
		}

		public Played played() {
			return new Played();
		}

		public class Played {
			public void get() {

			}
		}

		public Watched watched() {
			return new Watched();
		}

		public class Watched {
			public void get() {

			}
		}

		public Collected collected() {
			return new Collected();
		}

		public class Collected {
			public void get() {

			}
		}

		public Anticipated anticipated() {
			return new Anticipated();
		}

		public class Anticipated {
			public void get() {

			}
		}

		public Updates updates() {
			return new Updates();
		}

		public class Updates {
			public void get() {

			}
		}

		public Summary summary() {
			return new Summary();
		}

		public class Summary {
			public void get() {

			}
		}

		public Aliases aliases() {
			return new Aliases();
		}

		public class Aliases {
			public void get() {

			}
		}

		public Translations translations() {
			return new Translations();
		}

		public class Translations {
			public void get() {

			}
		}

		public Comments comments() {
			return new Comments();
		}

		public class Comments {
			public void get() {

			}
		}

		public Lists lists() {
			return new Lists();
		}

		public class Lists {
			public void get() {

			}
		}

		public Progress progress() {
			return new Progress();
		}

		public class Progress {
			public Collection collection() {
				return new Collection();
			}

			public class Collection {
				public void get() {

				}
			}

			public Watched watched() {
				return new Watched();
			}

			public class Watched {
				public void get() {

				}
			}
		}

		public People people() {
			return new People();
		}

		public class People {
			public void get() {

			}
		}

		public Ratings ratings() {
			return new Ratings();
		}

		public class Ratings {
			public void get() {

			}
		}

		public Related related() {
			return new Related();
		}

		public class Related {
			public void get() {

			}
		}

		public Stats stats() {
			return new Stats();
		}

		public class Stats {
			public void get() {

			}
		}

		public Watching watching() {
			return new Watching();
		}

		public class Watching {
			public void get() {

			}
		}

		public Episode episode() {
			return new Episode();
		}

		public class Episode {
			public Next next() {
				return new Next();
			}

			public class Next {
				public void get() {

				}
			}

			public Last last() {
				return new Last();
			}

			public class Last {
				public void get() {

				}
			}
		}
	}

	public Seasons seasons() {
		return new Seasons();
	}

	public class Seasons {
		public Summary summary() {
			return new Summary();
		}

		public class Summary {
			public void get() {

			}
		}

		public Season season() {
			return new Season();
		}

		public class Season {
			public void get() {

			}
		}

		public Comments comments() {
			return new Comments();
		}

		public class Comments {
			public void get() {

			}
		}

		public Lists lists() {
			return new Lists();
		}

		public class Lists {
			public void get() {

			}
		}

		public Ratings ratings() {
			return new Ratings();
		}

		public class Ratings {
			public void get() {

			}
		}

		public Watching watching() {
			return new Watching();
		}

		public class Watching {
			public void get() {

			}
		}
	}

	public Episodes episodes() {
		return new Episodes();
	}

	public class Episodes {
		public Summary summary() {
			return new Summary();
		}

		public class Summary {
			public void get() {

			}
		}

		public Translations translations() {
			return new Translations();
		}

		public class Translations {
			public void get() {

			}
		}

		public Comments comments() {
			return new Comments();
		}

		public class Comments {
			public void get() {

			}
		}

		public Lists lists() {
			return new Lists();
		}

		public class Lists {
			public void get() {

			}
		}

		public Ratings ratings() {
			return new Ratings();
		}

		public class Ratings {
			public void get() {

			}
		}

		public Stats stats() {
			return new Stats();
		}

		public class Stats {
			public void get() {

			}
		}

		public Watching watching() {
			return new Watching();
		}

		public class Watching {
			public void get() {

			}
		}
	}

	public Sync sync() {
		return new Sync();
	}

	public class Sync {
		public Activities activities() {
			return new Activities();
		}

		public class Activities {
			public Last last() {
				return new Last();
			}

			public class Last {
				public void get() {

				}
			}
		}

		public Playback playback() {
			return new Playback();
		}

		public class Playback {
			public void get() {

			}

			public void delete() {

			}
		}

		public Collection collection() {
			return new Collection();
		}

		public class Collection {
			public void get() {

			}

			public void post() {

			}

			public void delete() {

			}
		}

		public Watched watched() {
			return new Watched();
		}

		public class Watched {
			public void get() {

			}
		}

		public History history() {
			return new History();
		}

		public class History {
			public void get() {

			}

			public void post() {

			}

			public void delete() {

			}
		}

		public Ratings ratings() {
			return new Ratings();
		}

		public class Ratings {
			public void get() {

			}

			public void post() {

			}

			public void delete() {

			}
		}

		public Watchlist watchlist() {
			return new Watchlist();
		}

		public class Watchlist {
			public void get() {

			}

			public void post() {

			}

			public void delete() {

			}
		}
	}

	public Users users() {
		return new Users();
	}

	public class Users {
		public Settings settings() {
			return new Settings();
		}

		public class Settings {
			public void get() {

			}
		}

		public Requests requests() {
			return new Requests();
		}

		public class Requests {
			public Followers followers() {
				return new Followers();
			}

			public class Followers {
				public void get() {

				}

				public void approve() {

				}

				public void delete() {

				}
			}
		}

		public Items items() {
			return new Items();
		}

		public class Items {
			public Hidden hidden() {
				return new Hidden();
			}

			public class Hidden {
				public void get() {

				}

				public void post() {

				}

				public void delete() {

				}
			}
		}

		public Likes likes() {
			return new Likes();
		}

		public class Likes {
			public void get() {

			}
		}

		public Profile profile() {
			return new Profile();
		}

		public class Profile {
			public void get() {

			}
		}

		public Collection collection() {
			return new Collection();
		}

		public class Collection {
			public void get() {

			}
		}

		public Comments comments() {
			return new Comments();
		}

		public class Comments {
			public void get() {

			}
		}

		public Lists lists() {
			return new Lists();
		}

		public class Lists {
			public void get() {

			}

			public void create() {

			}
		}

		public List list() {
			return new List();
		}

		public class List {
			public void get() {

			}

			public void update() {

			}

			public void delete() {

			}

			public Like like() {
				return new Like();
			}

			public class Like {
				public void post() {

				}

				public void delete() {

				}
			}

			public Items items() {
				return new Items();
			}

			public class Items {
				public void get() {

				}

				public void delete() {

				}
			}

			public Comments comments() {
				return new Comments();
			}

			public class Comments {
				public void get() {

				}
			}
		}

		public Follow follow() {
			return new Follow();
		}

		public class Follow {
			public void post() {

			}

			public void delete() {

			}
		}

		public Followers followers() {
			return new Followers();
		}

		public class Followers {
			public void get() {

			}
		}

		public Following following() {
			return new Following();
		}

		public class Following {
			public void get() {

			}
		}

		public Friends friends() {
			return new Friends();
		}

		public class Friends {
			public void get() {

			}
		}

		public History history() {
			return new History();
		}

		public class History {
			public void get() {

			}
		}

		public Ratings ratings() {
			return new Ratings();
		}

		public class Ratings {
			public void get() {

			}
		}

		public Watchlist watchlist() {
			return new Watchlist();
		}

		public class Watchlist {
			public void get() {

			}
		}

		public Watching watching() {
			return new Watching();
		}

		public class Watching {
			public void get() {

			}
		}

		public Watched watched() {
			return new Watched();
		}

		public class Watched {
			public void get() {

			}
		}

		public Stats stats() {
			return new Stats();
		}

		public class Stats {
			public void get() {

			}
		}
	}
}
