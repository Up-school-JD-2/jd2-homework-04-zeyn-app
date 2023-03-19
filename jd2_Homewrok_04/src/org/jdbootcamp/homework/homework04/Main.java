package org.jdbootcamp.homework.homework04;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Stock stock = new Stock();
		StockManager stockManager = new StockManager(stock);
		stockManager.allItems();

		UserManager userManagement = new UserManager();
		String choice = "";
		Scanner scanner = new Scanner(System.in);

		Cart cart = new Cart();
		User user = new User("Zeynep", "Özdemir", cart);
		userManagement.addNewUser(user);

		System.out.println("Mağazamıza hoşgeldiniz: \n");

		OUTERLOOP: while (true) {
			System.out.println("**********************************************************");
			System.out.println("1-Kullanıcı İşlemleri\n2-Ürünleri İncele\n3-Çıkış Yap");
			choice = scanner.next();

			switch (choice) {
			case "1":
				INNERLOOP: while (true) {
					System.out.println("\n1-Yeni Kullanıcı Ekle\n" + "2-Kullanıcıları Listele\n" + "3-Geri");

					String subChoice = scanner.next();
					switch (subChoice) {
					case "1":
						System.out.println("Kullanıcı bilgilerinizi giriniz: ");
						User newUser = new User();
						userManagement.addNewUser(newUser);
						break;

					case "2":
						System.out.println("Kullanıcılar listeleniyor...");
						userManagement.getUser();
						break;

					case "3":
						break INNERLOOP;

					default:
						System.out.println("Yanlış seçim yaptınız...");
						break;
					}
				}

				break;
			case "2":
				INNERLOOP2: while (true) {
					System.out.println("\n1-Arama Yap\n" + "2-Tüm Ürünleri Listele\n"
							+ "3-Sepetimdeki Ürünleri Göster\n" + "4-Alışverişi Tamamla\n" + "5-Geri");

					String subChoice = scanner.next();
					switch (subChoice) {
					case "1":
						while (true) {
							System.out.println("Kategori Seçiniz: \nAlbüm\nŞarkı");
							String category = scanner.next();

							if (category.charAt(0) == 'A' || category.charAt(0) == 'a') {
								System.out.print("Aramak İstediğiniz Ürün: ");
								String product = scanner.next();

								for (Album album : stock.getAlbums()) {
									if (album.getName().contains(product)) {
										album.printInfo();

										System.out.println("1-Sepete Ekle\t\t\t2-Geri");
										String lastChoice = scanner.next();
										if (lastChoice.equals("1")) {
											cart.add(album);
											break;
										} else if (lastChoice.equals("2")) {
											continue INNERLOOP2;
										} else {
											System.out.println("Önceki Sayfaya Yönlendiriliyosunuz...");
											continue INNERLOOP2;
										}
									}
								}
							}

							else if (category.charAt(0) == 'S' || category.charAt(0) == 's') {
								System.out.println("Aramak İstediğiniz Ürün: ");
								String product = scanner.next();

								for (Song song : stock.getSongs()) {
									if (song.getName().contains(product)) {
										song.printInfo();

										System.out.println("1-Sepete Ekle\t\t\t2-Geri");
										String lastChoice = scanner.next();
										if (lastChoice.equals("1")) {
											cart.add(song);
											break;
										} else if (lastChoice.equals("2")) {
											continue INNERLOOP2;
										} else {
											System.out.println("Önceki Sayfaya Yönlendiriliyosunuz...");
											continue INNERLOOP2;
										}
									}
								}
							}

							else {
								System.out.println("Önceki Sayfaya Yönlendiriliyosunuz...");
								continue INNERLOOP2;
							}
						}
					case "2":
						stockManager.listStock();
						break;

					case "3":
						cart.listItems();
						break;

					case "4":
						System.out.println("Siparişiniz tamamlanmıştır...\nİyi Günler Dileriz");
						break OUTERLOOP;

					case "5":
						break INNERLOOP2;

					default:
						System.out.println("Yanlış seçim yaptınız...");
						break;
					}
				}
				
				break;
			case "3":
				break OUTERLOOP;
			}
		}
	}
}
