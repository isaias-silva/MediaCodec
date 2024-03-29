package com.zack.api.util.responses.enums;

public enum GlobalResponses {
    USER_NOT_FOUND("usuário não encontrado!"),
    USER_ALREADY_EXISTS("usuário já existe!"),
    USER_REGISTERED("usuário cadastrado com sucesso!"),
    USER_INCORRECT_PASSWORD("senha incorreta."),
    USER_LOGGED("usuário logado com sucesso!"),
    USER_UPDATED("dados atualizados!"),
    USER_EMAIL_CHANGED("e-mail atualizado com sucesso!"),
    USER_FORBIDDEN("não autorizado."),
    USER_UPDATED_PROFILE("perfil atualizado!"),
    USER_IS_AUTHENTICATED("usuário está logado."),
    ONLY_IMAGES("apenas imagens são permitidas."),
    INVALID_TOKEN("token inválido!"),
    INVALID_CODE("código inválido."),
    NEW_CODE_SEND("um novo código foi enviado para seu e-mail."),
    MAIL_ALREADY_VALIDATED("e-mail já validado"),
    MAIL_VALIDATED("e-mail validado com sucesso."),
    NOT_FOUND_MAIL_CACHED("novo e-mail não encontrado no cache"),
    PASSWORD_CHANGE_INIT("foi enviado para seu e-mail um código para troca de senha."),
    MAIL_CHANGE_INIT("foi enviado para seu novo e-mail um código de verificação."),
    EMAIL_NOT_FOUND("e-mail não encontrado"),
    EMAIL_DELETED("e-mail deletado da sua caixa de e-mail."),
    EMAIL_SEND("e-mail enviado!"), INVALID_ROLE("classe de usuário inválida ");

    private final String text;
    GlobalResponses(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }

}
