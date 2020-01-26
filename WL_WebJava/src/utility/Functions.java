package utility;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.InputMismatchException;


public class Functions {

	public boolean validateName(String name) {
		if (name.matches(".*\\d.*") || name.equals("")) {
			return false;
		}
		return true;
	}
	
	public boolean validateBirthday(String date) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			if(format.parse(date).compareTo(format.parse(LocalDate.now().toString())) > 0
					|| format.parse(date).compareTo(format.parse("1990-01-01")) < 0) {
				return false;
			}
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	public boolean validateCPF(String CPF) {
		if (CPF.matches("[^\\d]")) {
			return false;
		}
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11)) {
			return (false);
		}
		char dig10, dig11;
		int sm, i, r, num, peso;
		try {
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11)) {
				dig10 = '0';
			}else {
				dig10 = (char) (r + 48);
			}
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11)) {
				dig11 = '0';
			}else {
				dig11 = (char) (r + 48);
			}
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
				return (true);
			}else {
				return (false);
			}
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	public String generatePassword(String cpf, String dateBirthday) {
		String value = cpf.substring(0, 3)+dateBirthday.substring(5, 7);
		System.out.println("Usandos os valores para senha: "+ value);
		String sha1 = "";
		
		//Method using java libraries
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
	        digest.reset();
	        digest.update(value.getBytes("utf8"));
	        sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (Exception e){
			e.printStackTrace();
		}
		return sha1;
	}
}
