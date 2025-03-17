package test.due.album;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import album.Figurina;

public class TestDueAlbum {
	public static void salvaAlbum(List<Figurina>figurine,String file) {
		try (PrintWriter writer=new PrintWriter(new FileWriter(file))) {
			for(Figurina entry:figurine) {
				writer.println(entry.toString());
			}
			System.out.println("salvato con successo");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void salvaAlbumOrdinato(List<Figurina>figurine,String file) {
		try (PrintWriter writer=new PrintWriter(new FileWriter(file))) {
			for(Figurina entry:figurine) {
				writer.println(entry.toString());
			}
			System.out.println("salvato con successo");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
