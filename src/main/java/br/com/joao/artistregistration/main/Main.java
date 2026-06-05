package br.com.joao.artistregistration.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {
    private Scanner read = new Scanner(System.in);

    public void menu(){

    }

    @Override
    public void run(String... args) throws Exception {
        menu();
    }
}
