package com.henokPlaylist;

public class Song {
    private String title;
    private double duration;

    // empty constructor
   public Song(){

    }
  public Song(String title,double duration){
       this.title=title;
       this.duration=duration;
  }
    //Getter and Setter

    public double getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
