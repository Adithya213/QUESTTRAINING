package com.quest.StreamingPlatformPlaylistManager;

import java.util.*;

/**
 * Class to Represents a playlist that contains a list of tracks.
 */

public class Playlist implements PlaylistInterface {
    private  String name;
    private  List<Track> tracks;

    public Playlist(String name) {
        this.name = name;
        this.tracks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public void addTrack(Track track) throws DuplicateTrackException {
        if (tracks.contains(track)) {
            throw new DuplicateTrackException("Track with ID " + track.getId() + " already exists in the playlist.");
        }
        tracks.add(track);
    }

    @Override
    public void removeTrack(Track track) {
        if (!tracks.remove(track)) {
            throw new NoSuchElementException("Track not found in the playlist.");
        }
    }

    @Override
    public List<Track> search(String keyword) {
        keyword = keyword.toLowerCase();
        List<Track> result = new ArrayList<>();
        for (Track track : tracks) {
            if (track.getTitle().toLowerCase().contains(keyword) ||
                    track.getArtist().toLowerCase().contains(keyword)) {
                result.add(track);
            }
        }
        return result;
    }

    @Override
    public void sortByDuration() {
        tracks.sort(Comparator.comparingDouble(Track::getDuration));
    }

    @Override
    public void sortByTitle() {
        tracks.sort(Comparator.comparing(Track::getTitle));
    }

    @Override
    public void shuffleTracks() {
        Collections.shuffle(tracks);
    }

    @Override
    public void displayTracks() {
        System.out.println("Playlist: " + name);
        for (Track track : tracks) {
            System.out.println(track);
        }
    }

//    @Override
//    public List<Track> findDuplicates() {
//        Set<Track> uniqueTracks = new HashSet<>();
//        List<Track> duplicates = new ArrayList<>();
//        for (Track track : tracks) {
//            if (!uniqueTracks.add(track)) {
//                duplicates.add(track);
//            }
//        }
//        return duplicates;
//    }

    @Override
    public List<Track> getTracks() {
        return this.tracks; // Return the list of tracks in the playlist
    }
}
