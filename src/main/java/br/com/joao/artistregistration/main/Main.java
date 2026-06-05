package br.com.joao.artistregistration.main;

import br.com.joao.artistregistration.model.Artist;
import br.com.joao.artistregistration.model.Song;
import br.com.joao.artistregistration.repository.ArtistRepository;
import br.com.joao.artistregistration.repository.SongRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {
    private Scanner read = new Scanner(System.in);
    private ArtistRepository artistRepository;
    private SongRepository songRepository;

    public Main(ArtistRepository artistRepository, SongRepository songRepository){
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
    }

    public void menu(){

        int option  = -1;

        while(option != 0){
            System.out.println("""
                    Choose one of the options down below:
                    1 - Add an artist
                    2 - Add a song
                    3 - List all songs
                    4 - List all songs from an artist
                    
                    0 - Exit
                    """);

            System.out.print("\nOption: ");
            option = read.nextInt();
            read.nextLine();

            switch(option){
                case 1:
                    addArtist();
                    break;
                case 2:
                    addSong();
                    break;
                case 3:
                    listAllSongs();
                    break;
                case 4:
                    listAllSongsFromArtist();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private void addArtist(){
        System.out.print("\nWrite a name of an artist: ");
        String name = read.nextLine();
        System.out.print("\nWrite the type: ");
        String type = read.nextLine();

        Artist artist = new Artist(name, type);

        artistRepository.save(artist);

        System.out.println("Success");
    }

    private void addSong(){
        List<Artist> artistList = artistRepository.findAll();
        List<Song> songList = new ArrayList<>();

        artistList.forEach(System.out::println);

        System.out.print("\nChoose one of the artist above to add a song to him: ");
        String artistName = read.nextLine();

        Optional<Artist> artistOptional = artistList.stream()
                .filter(a -> a.getName().toLowerCase().equalsIgnoreCase(artistName.toLowerCase()))
                .findFirst();

        if(artistOptional.isPresent()){
            Artist artist = artistOptional.get();

            while(true){
                System.out.print("Write a name of a song from this artist: ");
                String songName = read.nextLine();

                Song song = new Song(songName);
                songList.add(song);

                System.out.println("Do you want to add another song?");
                System.out.print("Answer: ");
                String answer = read.nextLine();

                if(answer.equalsIgnoreCase("yes")){
                }else{
                    break;
                }
            }

            artist.setSongList(songList);
            artistRepository.save(artist);

        }
    }

    private void listAllSongs(){
        List<Song> songList = songRepository.findAllSongs();

        System.out.println("All songs: ");

        songList.forEach(System.out::println);
    }

    private void listAllSongsFromArtist(){
        System.out.print("\nWrite a name of an artist: ");
        String name = read.nextLine();

        List<Song> songList = songRepository.findSongByArtist(name);

        System.out.println("All songs from: " + name);

        songList.forEach(s -> System.out.println(s.getName()));
    }

    @Override
    public void run(String... args) throws Exception {
        menu();
    }
}
