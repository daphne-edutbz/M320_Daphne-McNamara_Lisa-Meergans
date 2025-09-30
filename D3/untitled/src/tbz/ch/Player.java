package tbz.ch;

import java.util.Collections;

public class Player {
    private Playlist playlist;

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public void playAll() throws PlaylistEmptyException {
        if (playlist == null || playlist.isEmpty()) {
            throw new PlaylistEmptyException("Playlist is empty");
        }
        for (Song song : playlist.getSongs()) {
            System.out.println("Playing: " + song);
        }
    }

    public void shufflePlay() throws PlaylistEmptyException {
        if (playlist == null || playlist.isEmpty()) {
            throw new PlaylistEmptyException("Playlist is empty");
        }
        Collections.shuffle(playlist.getSongs());
        for (Song song : playlist.getSongs()) {
            System.out.println("Playing: " + song);
        }
    }

    public void playSong(String title) throws PlaylistEmptyException, SongNotFoundException {
        if (playlist == null || playlist.isEmpty()) {
            throw new PlaylistEmptyException("Playlist is empty");
        }

        boolean found = false;
        for (Song s : playlist.getSongs()) {
            if (s.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Playing: " + s);
                found = true;
                break;
            }
        }

        if (!found) {
            throw new SongNotFoundException("Song not found: " + title);
        }
    }
}
