package com.quest.StreamingPlatformPlaylistManager;

import java.util.*;
/**
 * Class to Represents a User with multiple playlists and favorite tracks.
 */
public class User implements UserInterface {
    private final String username;
    private final Map<String, Playlist> playlists;
    private final Set<Track> favoriteTracks;

    public User(String username) {
        this.username = username;
        this.playlists = new HashMap<>();
        this.favoriteTracks = new HashSet<>();
    }

    @Override
    public void createPlaylist(String name) {
        if (playlists.containsKey(name)) {
            throw new IllegalArgumentException("Playlist with name " + name + " already exists.");
        }
        playlists.put(name, new Playlist(name));
    }

//    @Override
//    public void deletePlaylist(String name) {
//        if (playlists.remove(name) == null) {
//            throw new NoSuchElementException("Playlist not found.");
//        }
//    }

    @Override
    public PlaylistInterface getPlaylist(String name) {
        Playlist playlist = playlists.get(name);
        if (playlist == null) {
            throw new NoSuchElementException("Playlist not found.");
        }
        return playlist;
    }

    @Override
    public PlaylistInterface mergePlaylists(String playlist1, String playlist2, String newPlaylistName) {
        PlaylistInterface p1 = getPlaylist(playlist1);
        PlaylistInterface p2 = getPlaylist(playlist2);

        createPlaylist(newPlaylistName);
        Playlist newPlaylist = (Playlist) getPlaylist(newPlaylistName);

        List<Track> tracks1 = ((Playlist) p1).getTracks();
        List<Track> tracks2 = ((Playlist) p2).getTracks();

        for (Track track : tracks1) {
            try {
                newPlaylist.addTrack(track);
            } catch (DuplicateTrackException ignored) {
            }
        }

        for (Track track : tracks2) {
            try {
                newPlaylist.addTrack(track);
            } catch (DuplicateTrackException ignored) {
            }
        }

        return newPlaylist;
    }

    @Override
    public void markFavorite(Track track) {
        System.out.println("Adding to favorites: " + track);  // Debugging line
        favoriteTracks.add(track);
    }


    @Override
    public void unmarkFavorite(Track track) {
        favoriteTracks.remove(track);
    }

    @Override
    public void displayFavorites() {
        System.out.println("Favorite Tracks:");
        if (favoriteTracks.isEmpty()) {
            System.out.println("No favorite tracks found.");
        } else {
            favoriteTracks.forEach(track -> {
                System.out.println(track);  // This will call the Track's toString() method
            });
        }
    }


    public void displayPlaylists() {
        System.out.println("Playlists:");
        playlists.forEach((name, playlist) -> {
            System.out.println("- " + name);
            playlist.displayTracks();
        });
    }
}



