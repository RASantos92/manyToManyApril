package com.robert.manytomany.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.robert.manytomany.services.GameService;
import com.robert.manytomany.services.GenreService;

@Controller
public class HomeController {
	private final GameService gameServ;
	private final GenreService genreServ;
	public HomeController(GameService gameServ,GenreService genreServ) {
		this.gameServ = gameServ;
		this.genreServ = genreServ;
	}
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("allGames", gameServ.getAll());
		return "main/dashboard.jsp";
	}

}
