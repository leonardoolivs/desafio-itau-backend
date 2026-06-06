package br.com.itau.validators;

public abstract class SenhaValidator {

    private SenhaValidator next;

    public static SenhaValidator link(SenhaValidator first, SenhaValidator... chain) {
        SenhaValidator head = first;
        for (SenhaValidator nextInChain: chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract boolean check(String senha);

    protected boolean checkNext(String senha) {
        if (next == null) {
            return true;
        }

        return next.check(senha);
    }
}