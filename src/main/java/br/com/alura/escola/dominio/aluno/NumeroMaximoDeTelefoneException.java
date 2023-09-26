package br.com.alura.escola.dominio.aluno;

public class NumeroMaximoDeTelefoneException extends RuntimeException {

    private static final String message = "Número máximo de telefones já cadastrados.";

    public NumeroMaximoDeTelefoneException() {
        super(message);
    }
}
