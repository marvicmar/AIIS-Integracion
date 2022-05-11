package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import aiss.model.Playlist;
import aiss.model.Book;


public class MapBooklistRepository implements PlaylistRepository{

	Map<String, Playlist> playlistMap;
	Map<String, Book> bookMap;
	private static MapBooklistRepository instance=null;
	private int index=0;			// Index to create playlists and songs' identifiers.
	
	
	public static MapBooklistRepository getInstance() {
		
		if (instance==null) {
			instance = new MapBooklistRepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() {
		
		playlistMap = new HashMap<String,Playlist>();
		bookMap = new HashMap<String,Book>();
		
		// Create books
		Book fundamentalsOfWavelets=new Book();
		fundamentalsOfWavelets.setTitle("Fundamentals of Wavelets");
		fundamentalsOfWavelets.setAuthor("Goswami, Jaideva");
		fundamentalsOfWavelets.setGenre("signal_processing");
		fundamentalsOfWavelets.setYear(0);
		fundamentalsOfWavelets.setRate(0);
		fundamentalsOfWavelets.setPagNumber(228);
		fundamentalsOfWavelets.setPublisher("Wiley");
		addSong(fundamentalsOfWavelets);
		
		Book dataSmart=new Book();
		dataSmart.setTitle("Data Smart");
		dataSmart.setAuthor("Foreman, John");
		dataSmart.setGenre("data_science");
		dataSmart.setYear(0);
		dataSmart.setRate(0);
		dataSmart.setPagNumber(235);
		dataSmart.setPublisher("Wiley");
		addBook(dataSmart);
		
		Book godCreatedTheIntegers=new Book();
		godCreatedTheIntegers.setTitle("God Created the Integers");
		godCreatedTheIntegers.setAuthor("Hawking, Stephen");
		godCreatedTheIntegers.setGenre("mathematics");
		godCreatedTheIntegers.setYear(0);
		godCreatedTheIntegers.setRate();
		godCreatedTheIntegers.setPagNumber(197);
		godCreatedTheIntegers.setPublisher("Penguin");
		addBook(godCreatedTheIntegers);
		
		Book Superfreakonomics=new Book();
		Superfreakonomics.setTitle("Superfreakonomics");
		Superfreakonomics.setAuthor("Dubner, Stephen");
		Superfreakonomics.setGenre("economics");
		Superfreakonomics.setYear(0);
		Superfreakonomics.setRate(0);
		Superfreakonomics.setPagNumber(179);
		Superfreakonomics.setPublisher("HarperCollins");
		addBook(Superfreakonomics);
		
		Book Orientalism=new Book();
		Orientalism.setTitle("Orientalism");
		Orientalism.setAuthor("Said, Edward");
		Orientalism.setGenre("history");
		Orientalism.setYear(0);
		Orientalism.setRate(0);
		Orientalism.setPagNumber(197);
		Orientalism.setPublisher("Penguin");
		addBook(Orientalism);
		
		// Create playlists
		Playlist japlaylist=new Playlist();
		japlaylist.setName("AISSPlayList");
		japlaylist.setDescription("AISS PlayList");
		addPlaylist(japlaylist);
		
		Playlist playlist = new Playlist();
		playlist.setName("Favourites");
		playlist.setDescription("A sample playlist");
		addPlaylist(playlist);
		
		// Add songs to playlists
		addSong(japlaylist.getId(), rollingInTheDeep.getId());
		addSong(japlaylist.getId(), one.getId());
		addSong(japlaylist.getId(), smellLikeTeenSpirit.getId());
		addSong(japlaylist.getId(), losingMyReligion.getId());
		
		addSong(playlist.getId(), losingMyReligion.getId());
		addSong(playlist.getId(), gotye.getId());
	}
	
	// Playlist related operations
	@Override
	public void addPlaylist(Playlist p) {
		String id = "p" + index++;	
		p.setId(id);
		playlistMap.put(id,p);
	}
	
	@Override
	public Collection<Playlist> getAllPlaylists() {
			return playlistMap.values();
	}

	@Override
	public Playlist getPlaylist(String id) {
		return playlistMap.get(id);
	}
	
	@Override
	public void updatePlaylist(Playlist p) {
		playlistMap.put(p.getId(),p);
	}

	@Override
	public void deletePlaylist(String id) {	
		playlistMap.remove(id);
	}
	

	@Override
	public void addSong(String playlistId, String songId) {
		Playlist playlist = getPlaylist(playlistId);
		playlist.addSong(songMap.get(songId));
	}

	@Override
	public Collection<Song> getAll(String playlistId) {
		return getPlaylist(playlistId).getSongs();
	}

	@Override
	public void removeSong(String playlistId, String songId) {
		getPlaylist(playlistId).deleteSong(songId);
	}

	
	// Song related operations
	
	@Override
	public void addSong(Song s) {
		String id = "s" + index++;
		s.setId(id);
		songMap.put(id, s);
	}
	
	@Override
	public Collection<Song> getAllSongs() {
			return songMap.values();
	}

	@Override
	public Song getSong(String songId) {
		return songMap.get(songId);
	}

	@Override
	public void updateSong(Song s) {
		Song song = songMap.get(s.getId());
		song.setTitle(s.getTitle());
		song.setAlbum(s.getAlbum());
		song.setArtist(s.getArtist());
		song.setYear(s.getYear());
	}

	@Override
	public void deleteSong(String songId) {
		songMap.remove(songId);
	}
	
}
