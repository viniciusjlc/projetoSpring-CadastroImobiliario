package br.com.cadastroImobiliario.util;

public class StringUtil {
    public static String removerMascara(String valorComMascara) {
        return valorComMascara.replaceAll("\\D*", "");
    }

    public static String removerMascaraTratamentoNulo(String valor) {
        return VerificadorUtil.estaNulo(valor) ? null : removerMascara(valor);
    }
}
