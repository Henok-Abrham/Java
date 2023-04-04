package com.henokPlaylist;
import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    //Constructor
    public Album(){

    }
    public Album(String name, String artist){
      this.name=name;
      this.artist=artist;
      this.songs=new ArrayList<Song>();
    }
 public Song findSong(String title){
     for (Song checkSong:
          this.songs) {
         if(checkSong.getTitle().equals(title)){
             return checkSong;
         }
     }
     return null;
 }
    public boolean addSong(String title,double duration){
        if(findSong(title)==null){
            songs.add(new Song(title,duration));
            System.out.println("Successfully added to the list");
            return true;
        }
        else {
            System.out.println("Song with name"+title+"already exist in the list");
        }
        return false;
    }
    // add to playlist from this album within track number range
 public boolean addToPlayList(int trackNo, LinkedList<Song> playList) {
     //because the track start form 1 but index in linked list from 0
     int index = trackNo - 1;
     if (index >= 0 && index < this.songs.size()) {
         playList.add(this.songs.get(index));
         return true;
     }
     System.out.println("This album does not have song with track number"+trackNo);
     return false;
 }
 public boolean addToPlayList(String title,LinkedList<Song> playlist){
     for (Song found:
          this.songs) {
         if(found.getTitle().equals(title)){
             playlist.add(found);
             return true;
         }

     }
     System.out.println("This album does not have song with title "+title);
     return false;
 }
}

