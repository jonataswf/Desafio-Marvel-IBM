package com.ibm.desafio.marvel.messages;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Messages {

    protected static final String ID_INVALIDO = "ID inválido ou não encontrada";
    protected static final String FK_HERO_ID = " fk_hero_id já está atribuido a um ator";
    protected static final String FK_CRIADOR_ID_FILME= " fk_criador_id já está atribuido a um filme";
    protected static final String FK_CRIADOR_ID_REVISTA= " fk_criador_id já está atribuido a uma revista";
    protected static final String DADOS_TABELA_DELETADOS= "Dados da tabela deletados com sucesso";
    protected static final String DELETADO_COM_SUCESSO= "Deletado com sucesso";
    protected static final String ERRO_AO_DELETAR= "Erro ao deletar: ID não encontrada ou nulo";


}
