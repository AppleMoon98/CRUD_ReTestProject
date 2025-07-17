package com.mysite.sbb.board;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepository;
	
	public void createBoard(String subject, String content) {
		Board board = new Board();
		board.setSubject(subject);
		board.setContent(content);
		board.setCreateDate(LocalDateTime.now());
		
		boardRepository.save(board);
	}
	
	public Page<Board> getListBoard(int page) {
		Pageable pageable = PageRequest.of(page, 10);
		return this.boardRepository.findAll(pageable);
	}
	
	public Board getBoard(Integer id) {
		Optional<Board> board = this.boardRepository.findById(id);
		
		if(!board.isPresent())
			throw new DataNotFoundException("해당 게시물을 찾을 수 없습니다."); // 오류 발생시 적을 클래스!!
		return board.get();
	}
}
