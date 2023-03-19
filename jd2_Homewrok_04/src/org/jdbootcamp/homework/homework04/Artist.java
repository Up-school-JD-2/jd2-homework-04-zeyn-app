package org.jdbootcamp.homework.homework04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jdbootcamp.homework.homework04.Album;

public class Artist {
	private String name;
	private List<Album> albums = new ArrayList<>();
	private List<Song> songs = new ArrayList<>();

	public Artist() {

	}

	public Artist(String name) {
		super();
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void listAlbums() {
		int index = 0;

		System.out.println("The albums of \"" + name + "\"");

		for (Album album : albums) {
			System.out.println(++index + ". " + album.getName());
		}
	}

	public void add(Album album) {
		albums.add(album);
	}

	public void listSongs() {
		int index = 0;

		System.out.println("The songs of \"" + name + "\"");

		for (Song song : songs) {
			System.out.println(++index + ". " + song.getName());
		}
	}

	public void add(Song song) {
		songs.add(song);
	}

}
