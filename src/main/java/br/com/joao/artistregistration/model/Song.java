package br.com.joao.artistregistration.model;

import jakarta.persistence.*;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinColumn(name = "artist_id")
    private Artist artist;

    public Song(){}

    public Song(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Artist getArtist(){
        return artist;
    }

    public void setArtist(Artist artist){
        this.artist = artist;
    }


}
