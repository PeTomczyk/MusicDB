package com.user;

import com.user.model.Artist;
import com.user.model.Datasource;
import com.user.model.SongArtist;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if (!datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }


        List<Artist> artists = datasource.queryArtists(Datasource.ORDER_BY_ASC);
        if (isNullOrEmpty(artists)) {
            System.out.println("No artists!");
            return;
        }
        for (Artist artist : artists) {
            System.out.println("ID: " + artist.getId() + ", Artist Name: " + artist.getName());
        }


        List<String> albumsForArtist =
                datasource.queryAlbumsForArtist("Pink Floyd", Datasource.ORDER_BY_DESC);
        if (isNullOrEmpty(albumsForArtist)) {
            System.out.println("No album!");
            return;
        }
        for (String album : albumsForArtist) {
            System.out.println(album);
        }


        List<SongArtist> songArtists =
                datasource.queryArtistsForSong("Mama I'm Coming Home", Datasource.ORDER_BY_ASC);

        if (isNullOrEmpty(songArtists)) {
            System.out.println("No artists for the song!");
            return;
        }
        for (SongArtist songArtist : songArtists) {
            System.out.println("Artist name: " + songArtist.getArtistName() +
                    ", Album name: " + songArtist.getAlbumName() +
                    ", Track: " + songArtist.getTrack());
        }


        datasource.querySongsMetadata();

        datasource.close();
    }

    public static <T> boolean isNullOrEmpty(List<T> list) {
        return list == null || list.isEmpty();
    }
}
