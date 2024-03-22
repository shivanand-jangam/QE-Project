package com.base;

import com.pages.CartPage;
import com.pages.HomePage;
import com.pages.MenuPage;

public class PageObjectManager {

	private HomePage homePage;
	private MenuPage menuPage;
	private CartPage cartPage;

	public HomePage getHomePage() {
		return homePage = new HomePage();
	}

	public MenuPage getMenuPage() {
		return menuPage = new MenuPage();
	}
	public CartPage geCartPage() {
		return cartPage = new CartPage();
	}

}
