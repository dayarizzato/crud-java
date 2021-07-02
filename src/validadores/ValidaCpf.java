/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validadores;

/**
 *
 * @author Diego
 */
public abstract class ValidaCpf {

    public static boolean validacpf(String strCpf) { // formato XXX.XXX.XXX-XX  
        if (!strCpf.substring(0, 1).equals("")) {
            try {
                boolean validado = true;
                int d1, d2;
                int digito1, digito2, resto;
                int digitoCPF;
                String nDigResult;
                strCpf = strCpf.replace('.', ' ');
                strCpf = strCpf.replace('-', ' ');
                strCpf = strCpf.replaceAll(" ", "");
                d1 = d2 = 0;
                digito1 = digito2 = resto = 0;

                for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
                    digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1, nCount)).intValue();

                    d1 = d1 + (11 - nCount) * digitoCPF;

                    d2 = d2 + (12 - nCount) * digitoCPF;
                };

                resto = (d1 % 11);

                if (resto < 2) {
                    digito1 = 0;
                } else {
                    digito1 = 11 - resto;
                }

                d2 += 2 * digito1;

                resto = (d2 % 11);

                if (resto < 2) {
                    digito2 = 0;
                } else {
                    digito2 = 11 - resto;
                }

                String nDigVerific = strCpf.substring(strCpf.length() - 2, strCpf.length());

                nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

                return nDigVerific.equals(nDigResult);
            } catch (Exception e) {
                System.err.println("Erro !" + e);
                return false;
            }
        } else {
            return false;
        }
    }
}
