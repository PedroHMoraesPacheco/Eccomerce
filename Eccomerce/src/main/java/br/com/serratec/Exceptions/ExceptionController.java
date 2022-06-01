package br.com.serratec.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionController {
	

	@ExceptionHandler(InvalidoCpfException.class)
	public ResponseEntity<?> cpfInvalidoException(InvalidoCpfException exception){
			HttpHeaders headers = new HttpHeaders();
			headers.add("ERRO! O Cpf é Inválido!", exception.getMensagem());
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ProdutoInvalidoException.class)
	public ResponseEntity<?> produtoInexistenteException(ProdutoInvalidoException exception){
			HttpHeaders headers = new HttpHeaders();
			headers.add("ERRO! O Produto é Inválido!", exception.getMensagem());
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(CategoriaInvalidaException.class)
	public ResponseEntity<?> categoriaInvalidaException(CategoriaInvalidaException exception){
			HttpHeaders headers = new HttpHeaders();
			headers.add("ERRO! A Categoria é Inválida!", exception.getMensagem());
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(ProdutoNaoEcontradoException.class)
	public ResponseEntity<?> produtoNaoEcontradoException(ProdutoNaoEcontradoException exception){
			HttpHeaders headers = new HttpHeaders();
			headers.add("ERRO! O Produto não foi encontrado!", exception.getMensagem());
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}
	
}
