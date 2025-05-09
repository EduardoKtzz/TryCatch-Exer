package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {

		//Instanciando Scanner e definindo o formato das datas
		Scanner sc = new Scanner(System.in);
				
		try {

			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			//Pegando o número do quarto do cliente
			System.out.println();
			System.out.print("Room number: ");
			Integer roomNumber = sc.nextInt();

			//Data de entrada
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkIn = LocalDate.parse(sc.next(), fmt);

			//Data de saida
			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate checkOut = LocalDate.parse(sc.next(), fmt);

			//Instanciando os atributos e exibindo os dados no ToString
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			//Pegando os dados para atualiza-los no sistema
			System.out.println();
			System.out.println("Enter data to update the reservation: ");

			//Nova data de entrada
			System.out.println("Check-in date (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(sc.next(), fmt);

			//Nova data de saida
			System.out.println("Check-out date (dd/MM/yyyy): ");
			checkOut = LocalDate.parse(sc.next(), fmt);

			//Puxando o metado para atualizar as datas
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

		}
		catch (DateTimeParseException e) {
			System.out.println("Formato de data invalido, tente novamente!");
		}
		catch (UnsupportedTemporalTypeException dataPosterior) {
			System.out.println("A data de saída tem que ser maior que a data de entrada!");
		}
		catch (IllegalArgumentException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}

		//Fechando Scanner
		sc.close();
	}
}
