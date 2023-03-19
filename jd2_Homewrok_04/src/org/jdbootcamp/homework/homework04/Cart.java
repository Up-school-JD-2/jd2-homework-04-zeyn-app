package org.jdbootcamp.homework.homework04;
import java.util.ArrayList;
import java.util.List;

import org.jdbootcamp.homework.homework04.Album;

public class Cart {
	private User user;
	private double totalPrice = 0.0d;
	private List<Song> songs = new ArrayList<>();
	private List<Album> albums = new ArrayList<>();

	public Cart() {

	}

	public Cart(User user) {
		this.user = user;
		user.setCart(this);
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void add(Song song) {
		songs.add(song);
		totalPrice += song.getPrice();
	}

	public void add(Album album) {
		albums.add(album);
		totalPrice += album.getPrice();
	}

	public void listItems() {
		int index = 0;
		if (!albums.isEmpty()) {
			// System.out.println("...Albümler...");
			for (Album album : albums) {
				System.out.println(++index + ". " + album.getName());
			}
		}
		if (!songs.isEmpty()) {
			// System.out.println("...Şarkılar...");
			for (Song song : songs) {
				System.out.println(++index + ". " + song.getName());
			}
		}

		System.out.println("Toplam tutar: " + totalPrice);
	}

}
