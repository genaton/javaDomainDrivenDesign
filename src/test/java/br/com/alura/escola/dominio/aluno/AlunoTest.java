package br.com.alura.escola.dominio.aluno;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AlunoTest {

    private Aluno aluno;
    @BeforeEach
    void beforeEach(){
        this.aluno = new Aluno(
                new CPF("123.456.789-00"),
                "Fulano da Silma",
                new Email("fulano@email.com"));
    }

    @Test
    void deveriaPermitirAdicionar1Telefone(){
        this.aluno.adicionarTelefone("11" , "12345678");
        assertEquals(1, this.aluno.getTelefones().size());
    }
    @Test
    void deveriaPermitirAdicionar2Telefones(){
        this.aluno.adicionarTelefone("11" , "12345678");
        this.aluno.adicionarTelefone("11" , "88888888");
        assertEquals(2, this.aluno.getTelefones().size());
    }

    @Test
    void naoDeveriaPermitirAdicionar3Telefones(){
        assertThrows(IllegalArgumentException.class, () ->{
        this.aluno.adicionarTelefone("11" , "12345678");
        this.aluno.adicionarTelefone("11" , "88888888");
        this.aluno.adicionarTelefone("11" , "77777777");
        });
    }






//teste implementado pelo aluno
//    @Test
//    void alunoNaoDeveriaTerMaisDeDoisNumerosDeTelefone(){
//        Aluno aluno = new Aluno(new CPF("123.456.789-00"), "Fulano", new Email("fulano@email.com"));
//
//        Telefone primeiroTelefone = new Telefone("00", "00000000");
//        Telefone segundoTelefone = new Telefone("11", "11111111");
//        Telefone terceiroTelefone = new Telefone("22", "22222222");
//
//        assertThrows(NumeroMaximoDeTelefoneException.class, () -> {
//            aluno.adicionarTelefone(primeiroTelefone.getDdd(), primeiroTelefone.getNumero());
//            aluno.adicionarTelefone(segundoTelefone.getDdd(), segundoTelefone.getNumero());
//            aluno.adicionarTelefone(terceiroTelefone.getDdd(), terceiroTelefone.getNumero());
//        }) ;

 }

