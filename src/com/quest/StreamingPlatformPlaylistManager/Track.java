package com.quest.StreamingPlatformPlaylistManager;
import java.util.Objects;
/**
 * Class for a Track in a playlist.
 */
public class Track {
    private final int id;//unique
    private final String title;
    private final String artist;
    private final double duration;//in min
    private int rating; // Rating on a scale of 1 to 5

    public Track(int id, String title, String artist, double duration) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.rating = 0; // Default rating
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public double getDuration() {
        return duration;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        } else {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Same object
        if (obj == null || getClass() != obj.getClass()) return false; // Check for null or different class
        Track track = (Track) obj;  // Cast the object to a Track
        return id == track.id;  // Compare the `id` field (as it's primitive, we use `==`)
    }

    @Override
    public int hashCode() {
        return id;
    }

@Override
public String toString() {
    return "Track[ID=" + id + ", Title=" + title + ", Artist=" + artist + ", Duration=" + duration + " mins, Rating=" + rating + "]";
}
}

