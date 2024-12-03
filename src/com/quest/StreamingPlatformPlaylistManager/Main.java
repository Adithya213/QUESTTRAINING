package com.quest.StreamingPlatformPlaylistManager;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static User user;

    public static void main(String[] args) {
        System.out.println("Welcome to the Streaming Platform Playlist Manager!");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        user = new User(username);

        while (true) {
            displayMenu();
            int choice = getUserChoice();
            try {
                switch (choice) {
                    case 1 -> createPlaylist();
                    case 2 -> addTrackToPlaylist();
                    case 3 -> removeTrackFromPlaylist();
                    case 4 -> displayPlaylists();
                    case 5 -> searchTracks();
                    case 6 -> sortTracksInPlaylist();
                    case 7 -> shuffleTracksInPlaylist();
                    case 8 -> mergePlaylists();
                    case 9 -> rateTrack();
                    case 10 -> manageFavorites();
                    case 11 -> displayFavoriteTracks();
                    case 12 -> {
                        System.out.println("Exiting the application. Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1. Create Playlist");
        System.out.println("2. Add Track to Playlist");
        System.out.println("3. Remove Track from Playlist");
        System.out.println("4. Display Playlists");
        System.out.println("5. Search Tracks");
        System.out.println("6. Sort Tracks in Playlist");
        System.out.println("7. Shuffle Tracks in Playlist");
        System.out.println("8. Merge Playlists");
        System.out.println("9. Rate a Track");
        System.out.println("10. Mark/Unmark Favorite Tracks");
        System.out.println("11. Display Favorite Tracks");
        System.out.println("12. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number:");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void createPlaylist() {
        scanner.nextLine();
        System.out.print("Enter playlist name: ");
        String playlistName = scanner.nextLine();
        user.createPlaylist(playlistName);
        System.out.println("Playlist created successfully.");
    }

    private static void addTrackToPlaylist() {
        scanner.nextLine();
        System.out.print("Enter playlist name: ");
        String playlistName = scanner.nextLine();
        PlaylistInterface playlist = user.getPlaylist(playlistName);

        if (playlist == null) {
            System.out.println("Error: Playlist not found.");
            System.out.print("Would you like to create this playlist? (y/n): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("y")) {
                user.createPlaylist(playlistName);  // Create playlist if not found
                System.out.println("Playlist created successfully.");
                playlist = user.getPlaylist(playlistName);  // Re-fetch the newly created playlist
            } else {
                System.out.println("Returning to main menu.");
                return;
            }
        }

        // Updated section for validating track ID input
        System.out.print("Enter track ID: ");
        int trackId = -1;
        while (true) {
            if (scanner.hasNextInt()) {
                trackId = scanner.nextInt();
                break;  // Exit loop if valid input
            } else {
                System.out.println("Invalid input. Please enter a valid track ID (integer):");
                scanner.next();
            }
        }

        scanner.nextLine();
        System.out.print("Enter track title: ");
        String title = scanner.nextLine();
        System.out.print("Enter track artist: ");
        String artist = scanner.nextLine();
        System.out.print("Enter track duration: ");
        double duration = scanner.nextDouble();
        scanner.nextLine();

        Track track = new Track(trackId, title, artist, duration);
        try {
            playlist.addTrack(track);
            System.out.println("Track added successfully.");
        } catch (DuplicateTrackException e) {
            System.out.println("Error: Track already exists in the playlist.");
        }
    }


    private static void removeTrackFromPlaylist() {
        scanner.nextLine();
        System.out.print("Enter playlist name: ");
        String playlistName = scanner.nextLine();
        PlaylistInterface playlist = user.getPlaylist(playlistName);

        if (playlist == null) {
            System.out.println("Playlist not found.");
            return;
        }

        System.out.print("Enter track ID to remove: ");
//        String trackId = scanner.nextLine().trim();
        int trackId = scanner.nextInt();
        Track track = new Track(trackId, "", "", 0); // ID is sufficient for removal
        playlist.removeTrack(track);
        System.out.println("Track removed successfully.");
    }

    private static void displayPlaylists() {
        user.displayPlaylists();
    }

    private static void searchTracks() {
        scanner.nextLine();
        System.out.print("Enter playlist name: ");
        String playlistName = scanner.nextLine();
        PlaylistInterface playlist = user.getPlaylist(playlistName);

        if (playlist == null) {
            System.out.println("Playlist not found.");
            return;
        }

        System.out.print("Enter search keyword (title/artist): ");
        String keyword = scanner.nextLine();
        var searchResults = playlist.search(keyword);
        if (searchResults.isEmpty()) {
            System.out.println("No tracks found.");
        } else {
            System.out.println("Search Results:");
            searchResults.forEach(System.out::println);
        }
    }

    private static void sortTracksInPlaylist() {
        scanner.nextLine();
        System.out.print("Enter playlist name: ");
        String playlistName = scanner.nextLine();
        PlaylistInterface playlist = user.getPlaylist(playlistName);

        if (playlist == null) {
            System.out.println("Playlist not found.");
            return;
        }

        System.out.println("Sort by: 1. Duration  2. Title");
        int sortChoice = getUserChoice();

        if (sortChoice == 1) {
            playlist.sortByDuration();
            System.out.println("Tracks sorted by duration.");
        } else if (sortChoice == 2) {
            playlist.sortByTitle();
            System.out.println("Tracks sorted by title.");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void shuffleTracksInPlaylist() {
        scanner.nextLine();
        System.out.print("Enter playlist name: ");
        String playlistName = scanner.nextLine();
        PlaylistInterface playlist = user.getPlaylist(playlistName);

        if (playlist == null) {
            System.out.println("Playlist not found.");
            return;
        }

        playlist.shuffleTracks();
        System.out.println("Tracks shuffled.");
    }

    private static void mergePlaylists() {
        scanner.nextLine();
        System.out.print("Enter first playlist name: ");
        String playlist1 = scanner.nextLine();
        System.out.print("Enter second playlist name: ");
        String playlist2 = scanner.nextLine();
        System.out.print("Enter new playlist name: ");
        String newPlaylistName = scanner.nextLine();

        user.mergePlaylists(playlist1, playlist2, newPlaylistName);
        System.out.println("Playlists merged into " + newPlaylistName + ".");
    }

    private static void rateTrack() {
        scanner.nextLine();
        System.out.print("Enter playlist name: ");
        String playlistName = scanner.nextLine();
        PlaylistInterface playlist = user.getPlaylist(playlistName);

        if (playlist == null) {
            System.out.println("Playlist not found.");
            return;
        }

        System.out.print("Enter track ID to rate: ");
//        String trackId = scanner.nextLine().trim();
        int trackId = scanner.nextInt();
        System.out.print("Enter rating (1-5): ");
        int rating = getUserChoice();

        // Find the track by ID
        Track track = null;
        for (Track t : playlist.getTracks()) { // Assuming getTracks() returns all tracks in the playlist
//            if (t.getId().equals(trackId)) {
//                track = t;
//                break;
//            }
            if (t.getId() == trackId) {
                track = t;
                break;
            }
        }

        if (track != null) {
            track.setRating(rating);
            System.out.println("Track rated successfully.");
        } else {
            System.out.println("Track not found.");
        }
    }


    private static void manageFavorites() {
        System.out.println("1. Mark Favorite  2. Unmark Favorite");
        int favChoice = getUserChoice();

        scanner.nextLine(); // Consume newline
        System.out.print("Enter track ID: ");
//        String trackId = scanner.nextLine().trim();
        int trackId = scanner.nextInt();
        Track track = new Track(trackId, "", "", 0); // ID is sufficient

        if (favChoice == 1) {
            user.markFavorite(track);
            System.out.println("Track marked as favorite.");
        } else if (favChoice == 2) {
            user.unmarkFavorite(track);
            System.out.println("Track unmarked as favorite.");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void displayFavoriteTracks() {
        user.displayFavorites();
    }
}
