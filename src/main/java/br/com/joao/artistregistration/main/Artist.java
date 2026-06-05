package br.com.joao.artistregistration.main;

import jakarta.persistence.*;

@Entity
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Type type;

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

    @Override
    public String toString(){
        return "\nName: " + getName() +
                "\nType: " + getType();
    }

}
