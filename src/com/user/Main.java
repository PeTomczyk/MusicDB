package com.user;

import com.user.model.Artist;
import com.user.model.Datasource;
import com.user.model.SongArtist;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if (!datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        //List artists
//        List<Artist> artists = datasource.queryArtists(Datasource.ORDER_BY_ASC);
//        if (isNullOrEmpty(artists)) {
//            System.out.println("No artists!");
//            return;
//        }
//        for (Artist artist : artists) {
//            System.out.println("ID: " + artist.getId() + ", Artist Name: " + artist.getName());
//        }

        //List albums for artist
//        List<String> albumsForArtist =
//                datasource.queryAlbumsForArtist("Pink Floyd", Datasource.ORDER_BY_DESC);
//        if (isNullOrEmpty(albumsForArtist)) {
//            System.out.println("No album!");
//            return;
//        }
//        for (String album : albumsForArtist) {
//            System.out.println(album);
//        }

        //List songs by artist
//        List<SongArtist> songArtists =
//                datasource.queryArtistsForSong("Mama I'm Coming Home", Datasource.ORDER_BY_ASC);
//        if (isNullOrEmpty(songArtists)) {
//            System.out.println("No artists for the song!");
//            return;
//        }
//        for (SongArtist songArtist : songArtists) {
//            System.out.println("Artist name: " + songArtist.getArtistName() +
//                    ", Album name: " + songArtist.getAlbumName() +
//                    ", Track: " + songArtist.getTrack());
//        }

        //Get metadata
//        datasource.querySongsMetadata();

        //Count
        int count = datasource.getCount(Datasource.TABLE_SONGS);
        System.out.println("Number of songs: " + count);

        //View
//        datasource.createViewForSongArtists();

        //Get input:title from user
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a song title: ");
//        String title = scanner.nextLine();
//        //SQL Injection example:
//        //title: Go Your Own Way" or 1=1 or "
//        //String builder:
//        //*** SQL statement = SELECT name, album, track FROM artist_list WHERE title = "Go Your Own Way" or 1=1 or""
//        //PreparedStatement: (protection against sql injection)
//        //*** SQL statement = SELECT name, album, track FROM artist_list WHERE title = "Go Your Own Way or 1=1 or""
//        songArtists = datasource.querySongInfoView(title);
//        if (isNullOrEmpty(songArtists)) {
//            System.out.println("Couldn't find the artist for the song");
//            return;
//        }
//        for (SongArtist artist : songArtists) {
//            System.out.println("FROM VIEW: Artist name: " + artist.getArtistName() +
//                    ", Album name: " + artist.getAlbumName() +
//                    ", Track name: " + artist.getTrack());
//        }

        //Manual transaction
//        datasource.insertSong("Touch of Grey (extended mix)", "Grateful Dead", "In the Dark", 2);

        datasource.close();
    }

    public static <T> boolean isNullOrEmpty(List<T> list) {
        return list == null || list.isEmpty();
    }
}
