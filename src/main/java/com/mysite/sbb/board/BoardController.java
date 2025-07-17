package com.mysite.sbb.board;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	private final BoardService boardService;

	@GetMapping("/create")
	public String createBoard() {
		return "board_form";
	}

	@PostMapping("/create")
	public String createBoard(@RequestParam("subject") String subject, @RequestParam("content") String contet) {
		this.boardService.createBoard(subject, contet);
		return "redirect:/";
	}

	@GetMapping("/list")
	public String getListBoard(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
		Page<Board> paging = this.boardService.getListBoard(page);
		model.addAttribute("paging", paging);
		return "board_list";
	}
	
	@GetMapping("/detail/{id}")
	public String getBoard(Model model, @PathVariable("id") Integer id) {
		Board board = this.boardService.getBoard(id);
		model.addAttribute("board", board);
		return "board_detail";
	}
}
