package br.com.alura.escola.dominio.aluno;

import br.com.alura.escola.dominio.Evento;
import br.com.alura.escola.dominio.Ouvinte;

import java.time.format.DateTimeFormatter;

//ouvinte de um evento
public class LogDeAlunoMatriculado extends Ouvinte {
    public void reageAo (Evento evento){
        String momentoformatado = evento.momento().format(DateTimeFormatter.ofPattern("dd//MM/yyyy HH:mm"));
        System.out.println(String.format("Aluno com CPF %s matriculado em: %s", ((AlunoMatriculado)evento).getCpfDoAluno(), momentoformatado));
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculado;
    }
}
