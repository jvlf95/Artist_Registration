package br.com.joao.artistregistration.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Song> songList = new ArrayList<>();

    public Artist(){}

    public Artist(String name, String type){
        this.name = name;
        this.type = Type.getString(type);
    }

    public String getName(){
        return name;
    }

    public Type getType(){
        return type;
    }

    public void setSongList(List<Song> songList){
        songList.forEach(s -> s.setArtist(this));
        this.songList = songList;
    }

    public List<Song> getSongList(){
        return songList;
    }

    @Override
    public String toString(){
        return "\nName: " + getName() +
                "\nType: " + getType();
    }

}
