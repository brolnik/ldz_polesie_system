/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldz.polesie.ldz_presentation.exceptions;

/**
 *
 * @author Rola
 */
public class PlayerException extends LDZException {

    private static final String PLAYER_WITH_SAME_LOGIN_EXISTS    = "Błąd, Zawodnik o podanym loginie już istnieje!";
    private static final String NUMBER_ALREADY_USED              = "Błąd, Wybrany przez Ciebie numer został już niestety zajęty!";
    private static final String INVALID_DATA                     = "Błąd, Wprowadzono niepoprawne dane!";
    private static final String PLAYER_WITH_SAME_NICKNAME_EXISTS = "Błąd, Zawodnik o podanym nicku już istnieje!";
    private static final String PLAYER_WITH_SAME_EMAIL_EXISTS    = "Błąd, Zawodnik o podanym adresie email już istnieje!";
    private static final String PLAYER_WITH_SAME_PHONE_EXISTS    = "Błąd, Zawodnik o podanym numerze telefonu już istnieje!";
    private static final String PLAYER_HAS_NOT_ANY_ROLES         = "Błąd, Użytkownik nie posiada żadnych przypisanych ról!";

    public PlayerException() {
    }

    public PlayerException(String message) {
        super(message);
    }

    public PlayerException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlayerException(Throwable cause) {
        super(cause);
    }

    public static PlayerException playerWithSameLoginExists() {
        return new PlayerException(PLAYER_WITH_SAME_LOGIN_EXISTS);
    }

    public static PlayerException playerWithSameNicknameExists() {
        return new PlayerException(PLAYER_WITH_SAME_NICKNAME_EXISTS);
    }

    public static PlayerException playerWithSameMailExists() {
        return new PlayerException(PLAYER_WITH_SAME_EMAIL_EXISTS);
    }

    public static PlayerException playerWithSamePhoneExists() {
        return new PlayerException(PLAYER_WITH_SAME_PHONE_EXISTS);
    }

    public static PlayerException numberAlreadyUsed() {
        return new PlayerException(NUMBER_ALREADY_USED);
    }

    public static PlayerException invalidData() {
        return new PlayerException(INVALID_DATA);
    }

    public static PlayerException playerHasNotAnyRoles() {
        return new PlayerException(PLAYER_HAS_NOT_ANY_ROLES);
    }

}
