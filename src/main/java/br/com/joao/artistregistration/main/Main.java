package br.com.joao.artistregistration.main;

import br.com.joao.artistregistration.model.Artist;
import br.com.joao.artistregistration.repository.ArtistRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {
    private Scanner read = new Scanner(System.in);
    private ArtistRepository artistRepository;

    public Main(ArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }

    public void menu(){

        int option  = -1;

        while(option != 0){
            System.out.println("""
                    Choose one of the options down below:
                    1 - Add an artist
                    
                    0 - Exit
                    """);

            System.out.print("\nOption: ");
            option = read.nextInt();
            read.nextLine();

            switch(option){
                case 1:
                    addArtist();
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

    @Override
    public void run(String... args) throws Exception {
        menu();
    }
}
