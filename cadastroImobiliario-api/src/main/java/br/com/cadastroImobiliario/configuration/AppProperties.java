package br.com.cadastroImobiliario.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
public class AppProperties {

    private final Seguranca seguranca = new Seguranca();

    public static class Seguranca {

        private final Autenticacao autenticacao = new Autenticacao();

        public static class Autenticacao {

            private final Jwt jwt = new Jwt();

            public static class Jwt {

                private String segredo;
                private String segredoBase64;
                private long validadeTokenEmMilissegundos;
                private long validadeTokenEmMilissegundosComLembrar;

                public Jwt() {
                    this.validadeTokenEmMilissegundos = 1800L;
                    this.validadeTokenEmMilissegundosComLembrar = 2592000L;
                }

                public String getSegredo() {
                    return segredo;
                }

                public void setSegredo(String segredo) {
                    this.segredo = segredo;
                }

                public String getSegredoBase64() {
                    return segredoBase64;
                }

                public void setSegredoBase64(String segredoBase64) {
                    this.segredoBase64 = segredoBase64;
                }

                public long getValidadeTokenEmMilissegundos() {
                    return validadeTokenEmMilissegundos;
                }

                public void setValidadeTokenEmMilissegundos(long validadeTokenEmMilissegundos) {
                    this.validadeTokenEmMilissegundos = validadeTokenEmMilissegundos;
                }

                public long getValidadeTokenEmMilissegundosComLembrar() {
                    return validadeTokenEmMilissegundosComLembrar;
                }

                public void setValidadeTokenEmMilissegundosComLembrar(long validadeTokenEmMilissegundosComLembrar) {
                    this.validadeTokenEmMilissegundosComLembrar = validadeTokenEmMilissegundosComLembrar;
                }
            }

            public Jwt getJwt() {
                return jwt;
            }
        }

        public Autenticacao getAutenticacao() {
            return autenticacao;
        }
    }

    public Seguranca getSeguranca() {
        return seguranca;
    }
}
