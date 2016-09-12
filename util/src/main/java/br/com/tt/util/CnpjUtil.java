package br.com.tt.util;

public class CnpjUtil {

	public static String removerMascara(String cnpj) {
		/*
		 * Remove essa m�scara do CNPJ: 99.999.999/9999-99, deixando
		 * 99999999999999
		 */
		cnpj = cnpj.replaceAll("\\.", "");
		cnpj = cnpj.replaceAll("\\-", "");
		cnpj = cnpj.replaceAll("/", "");
		return cnpj;

	}

	public static String adicionarMarcara(String cnpj) {
		/*
		 * m�scara do CNPJ: 99.999.999/9999-99
		 */
		cnpj = cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8) + "/"
				+ cnpj.substring(8, 12) + "-" + cnpj.substring(12, 14);

		return cnpj;
	}

	public static boolean validar(String cnpj) {

		/*
		 * Considera-se erro CNPJ's formados por uma sequencia de numeros iguais
		 */
		if (cnpj == null || cnpj.length() != 14 || cnpj.equals("00000000000000") || cnpj.equals("11111111111111")
				|| cnpj.equals("22222222222222") || cnpj.equals("33333333333333") || cnpj.equals("44444444444444")
				|| cnpj.equals("55555555555555") || cnpj.equals("66666666666666") || cnpj.equals("77777777777777")
				|| cnpj.equals("88888888888888") || cnpj.equals("99999999999999"))
			return false;

		char dig13, dig14;
		int sm, i, r, num, peso;
		/*
		 * "try" - protege o c�digo para eventuais erros de conversao de
		 * tipo(int)
		 */
		try {

			Long.parseLong(cnpj);
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 2;

			for (i = 11; i >= 0; i--) {
				/*
				 * converte o i-�simo caractere do CNPJ em um n�mero: por
				 * exemplo, transforma o caractere '0' no inteiro 0 (48 � a
				 * posi��o de '0' na tabela ASCII)
				 */
				num = (int) (cnpj.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}
			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig13 = '0';
			else
				dig13 = (char) ((11 - r) + 48);
			/*
			 * Calculo do 2o. Digito Verificador
			 */
			sm = 0;
			peso = 2;
			for (i = 12; i >= 0; i--) {
				num = (int) (cnpj.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}
			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig14 = '0';
			else
				dig14 = (char) ((11 - r) + 48);

			/*
			 * Verifica se os d�gitos calculados conferem com os d�gitos
			 * informados.
			 */
			if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13)))
				return true;
			else
				return false;
		} catch (NumberFormatException e) { // CPF n�o possui somente n�meros

			return false;
		}

	}

}
