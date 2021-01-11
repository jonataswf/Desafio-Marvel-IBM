package com.ibm.desafio.marvel.messages;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Messages {

    protected static final String ID_INVALIDO = "ID inválido ou não encontrada";
    protected static final String HEROI_ATRIBUIDO = " já está atribuido a um ator";
    protected static final String DADOS_TABELA_DELETADOS = "Dados da tabela deletados com sucesso";
    protected static final String DELETADO_COM_SUCESSO = "Deletado com sucesso";
    protected static final String ERRO_AO_DELETAR = "Erro ao deletar: ID não encontrada ou nulo";
    protected static final String CRIADOR_ID = "Criador id: ";
    protected static final String HEROI_ID = "Heroi id: ";
    protected static final String FILME_ID = " Filme id: ";
    protected static final String REVISTA_ID = "Revista id: ";
    protected static final String LIMIT_HEROI_5 = " já possui 5 herois, não é possivel adicionar mais herois";
    protected static final String LIMIT_PODER_5 = " já possui 5 poderes, não é possivel adicionar mais poderes";
    protected static final String LIMIT_CRIACOES_5 = " já possui 5 criações somadas entre filmes, revistas e herois, não é possivel adicionar mais criações";
}
