package com.robert.manytomany.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robert.manytomany.models.Game;
import com.robert.manytomany.services.GameService;
import com.robert.manytomany.services.GenreService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/games")
public class GameController {

	private final GameService gameServ;
	private final GenreService genreServ;
	public GameController(GameService gameServ,GenreService genreServ) {
		this.gameServ = gameServ;
		this.genreServ = genreServ;
	}
	
	@GetMapping("/create")
	public String createGame(@ModelAttribute("game") Game game, Model model) {
		model.addAttribute("allGenres", genreServ.getAll());
		return "game/create.jsp";
	}
	
	@PostMapping("/process/create")
	public String processCreateGame(@Valid @ModelAttribute("game") Game game, BindingResult result) {
		if(result.hasErrors()) {
			return "game/create.jsp";
		}
		gameServ.createGameWithGenre(game);	
		return "redirect:/";
	}
	

}
