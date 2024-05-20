package com.mycompany.exercicio_1;

import java.util.Scanner;

public class Exercicio_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("PROGRAMA DAS FAIXA ETÁRIA");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();
        
        if (idade <= 12){
            System.out.printf("%s, você é uma Criança. ", nome);
        }else if ((idade > 12) && (idade < 18)){
            System.out.printf("%s, você é um Adolescente. ", nome);
        }else{
            System.out.printf("%s, você é um Adulto. ", nome);
        }
        
        scanner.close();
                
    }
}
