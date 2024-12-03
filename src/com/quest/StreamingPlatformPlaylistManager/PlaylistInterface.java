package com.quest.StreamingPlatformPlaylistManager;

import java.util.List;

public interface PlaylistInterface {
    void addTrack(Track track) throws DuplicateTrackException;
    void removeTrack(Track track);
    List<Track> search(String keyword);
    void sortByDuration();
    void sortByTitle();
    void shuffleTracks();
    void displayTracks();
   // List<Track> findDuplicates();
    List<Track> getTracks(); // This will return the list of tracks in the playlist

}


