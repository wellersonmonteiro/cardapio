package br.well.cardapio.domain;

public record RegisterDTO(String login, String password, UserRole role) {
}
