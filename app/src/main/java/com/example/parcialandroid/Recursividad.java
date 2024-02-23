package com.example.parcialandroid;
import java.util.Scanner;
public class Recursividad {

        public static void dividirentredos(int numero) {
            if (numero == 1) {
                System.out.println(numero);
                return;
            }

            System.out.println(numero);
            dividirentredos(numero / 2);
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingresa un número: ");
            int numero = scanner.nextInt();

            System.out.println("División recursiva:");
            dividirentredos(numero);
        }
    }

