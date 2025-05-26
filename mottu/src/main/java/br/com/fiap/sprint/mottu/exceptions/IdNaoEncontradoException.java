package br.com.fiap.sprint.mottu.exceptions;

public class IdNaoEncontradoException extends Exception {

    public IdNaoEncontradoException(String mensagem){
        super(mensagem);
    }

    public IdNaoEncontradoException(){
        super("Entidade não encontrada.");
    }
}