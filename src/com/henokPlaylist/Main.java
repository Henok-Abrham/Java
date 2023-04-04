package com.henokPlaylist;

import java.util.*;

public class Main {
    //it is static because never changed
    private static ArrayList<Album> albums=new ArrayList<>();
    public static void main(String[] args) {
        Album album = new Album("Yasteseryal","Teddy Afro");
        album.addSong("Yasteseryal",7.02);
        album.addSong("Alemn Alena",3.55);
        album.addSong("Shiemandefer",4.41);
        album.addSong("kier Yhun",4.34);
        //add to ALBUM LIST IN INDEX 0
        albums.add(album);

        album=new Album("Yene Zema","Dawit Tsige");
        album.addSong("Degimo Bezih Lay",4.38);
        album.addSong("Chall Zendro",3.52);
        album.addSong("Etittu",4.36);
        album.addSong("Yene Zema",4.33);
        //add to ALBUM LIST IN INDEX 1
        albums.add(album);
        /*
        create link list for play list mix of song from the above two album and use as a parameter for addPlayList()
        method in album class

        */
        LinkedList<Song> playList_1= new LinkedList<>();
        /*
        ==> now let us add already exist songs from above two albums
        ==> albums.get(0) is to access the first album from Arraylist albums by index 0
        ==> albums.get(1) is  to access the second album from Arraylist albums by index 7
        ==> I use addToPlayList(title,playlist) method defined in Album class
        */
        albums.get(0).addToPlayList("Shiemandefer",playList_1);
        albums.get(0).addToPlayList("Alemn Alena",playList_1);
        albums.get(1).addToPlayList("Yene Zema",playList_1);
        albums.get(1).addToPlayList("Chall Zendro",playList_1);
       // to play with play list
        play(playList_1);


    }
    private static void play(LinkedList<Song> playList){
        //used for accept user action
        Scanner scanner= new Scanner(System.in);
        //this two boolean variable is used to manipulate the loop
        boolean quit=false;
        boolean forward= false;
        ListIterator<Song> listIterator=playList.listIterator();
 if(playList.size()==0){
     System.out.println("this playlist have no song");
 }
 else {
     System.out.println("now playing" +listIterator.next().toString());
     printMenu();
 }
        while(!quit){
            int action=scanner.nextInt();
            //by switch case give options
            switch (action){
                case 0:
                    System.out.println("the play list is complete");
                    quit=true;
                    break;
                case 1:if(!forward){
                    if(listIterator.hasNext()){
                         listIterator.next(); //once forwarded
                    }
                    forward=true; // this means we did forward b/c we can, b/c there is next song in playlist
                    if(listIterator.hasNext()){ //==check for next song from once forwarded point
                        System.out.println("now playing"+listIterator.next().toString()); //no forwarding just display
                    }
                    else{
                        System.out.println("No more song available, reach the end playlist");
                        forward=false; // this means we can't forward, b/c there is no next song in playlist
                    }
                }
                break;
                /* use forward variable as it is b/c if value is true the iterator is in the middle i.e before user press 1 before he press 2 or the application reach in in next music */
                case 2: if(forward){  //this action performed if iterator is in the middle or last of playlist not in beginning
                               if(listIterator.hasPrevious()){
                                      listIterator.previous();
                                    }
                               forward=false; // the last action was not forward or we didn't forward b/c action is backward
                            if(listIterator.hasPrevious()){
                                  System.out.println( "now playing"+listIterator.previous().toString());
                                    }
                            else {
                                 System.out.println("No more previous song, u are in the beginning");
                                 forward = true; //the last action was forwarding
                    }
                   }
                       break;
                case 3:if(forward){
                    if(listIterator.hasPrevious()){
                        listIterator.previous();
                        forward=false;
                    }else {
                        System.out.println("No more previous song, u are in the beginning\"");
                    }

                }
                else {
                    if (listIterator.hasNext()){
                        listIterator.next();
                        forward=true;
                    }
                    else {
                        System.out.println("No more song available, reach the end playlist");
                    }
                }
                break;
                case 4:printList(playList);
                break;
                case 5:printMenu();
                break;
                case 6:if(playList.size()>0){
                    listIterator.remove();
                    if(listIterator.hasNext()){
                        System.out.println("now playing"+listIterator.next().toString());
                    }
                    else {if (listIterator.hasPrevious()){
                        System.out.println( "now playing"+listIterator.previous().toString());
                    }

                    }
                }
                break;
                default:
                    System.out.println("invalid input");

            }
        }
    }

    private static void printMenu(){
        System.out.println("Available options \npress");
        System.out.println("0 - to quit\n"
                +"1 - to play next song\n"
                +"2 - to play previous song\n"
                +"3 - to replay current song\n"
                +"4 - list of all songs\n"
                +"5 - print all available options\n"
                +"6 - delete the current songs\n"
        );
    }


    private static void printList(LinkedList<Song> playList){
        ListIterator<Song> iterator=playList.listIterator();
        System.out.println("__________________________________");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("____________________________________");
    }

}