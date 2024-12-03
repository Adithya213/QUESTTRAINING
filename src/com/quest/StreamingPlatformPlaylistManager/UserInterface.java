package com.quest.StreamingPlatformPlaylistManager;

public interface UserInterface {
    void createPlaylist(String name);
    //void deletePlaylist(String name);
    PlaylistInterface getPlaylist(String name);
    PlaylistInterface mergePlaylists(String playlist1, String playlist2, String newPlaylistName);
    void markFavorite(Track track);
    void unmarkFavorite(Track track);
    void displayFavorites();
}


