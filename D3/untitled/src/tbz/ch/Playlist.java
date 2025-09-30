package tbz.ch;

import java.util.List;

public class Playlist {
    private List<Song> songs;

    public Playlist(List<Song> songs) {
        this.songs = songs;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public void removeSong(Song song) throws SongNotFoundException {
        if (!songs.remove(song)) {
            throw new SongNotFoundException("Song not found: " + song.getTitle());
        }
    }


    public List<Song> getSongs() {
        return songs;
    }

    public boolean isEmpty() {
        return songs.isEmpty();
    }
}
