package br.com.fiap.sprint.mottu.exceptions;

public class CommitException extends Exception{

    public CommitException(String mensagem){
        super(mensagem);
    }

    public CommitException() {
        super("Erro ao realizar o commit");
    }
}