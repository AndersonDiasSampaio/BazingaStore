package br.com.bazingaStore.util;

public class CpfCheck {

	public CpfCheck() {
		// TODO Auto-generated constructor stub
	}

	public boolean cpfTest(String a) {
		boolean h = true;
		boolean k = true;
		boolean l = true;
		String j = "";
		String u = "";
		String cpfEQ;
		Integer sum, sum2;
		j = a;

		if (j.length() == 11) {
			Integer q, w, e, r, t, y, i, o, p, dig1, dig2, digD1, digD2;
			q = Integer.parseInt(j.substring(0, 1));
			System.out.println(j.substring(0));
			w = Integer.parseInt(j.substring(1, 2));
			e = Integer.parseInt(j.substring(2, 3));
			r = Integer.parseInt(j.substring(3, 4));
			t = Integer.parseInt(j.substring(4, 5));
			y = Integer.parseInt(j.substring(5, 6));
			i = Integer.parseInt(j.substring(6, 7));
			o = Integer.parseInt(j.substring(7, 8));
			p = Integer.parseInt(j.substring(8, 9));
			digD1 = Integer.parseInt(j.substring(9, 10));
			digD2 = Integer.parseInt(j.substring(10, 11));

			// digD2 = Integer.parseInt(j.substring(11, 11));
			sum = p * 2 + o * 3 + i * 4 + y * 5 + t * 6 + r * 7 + e * 8 + w * 9 + q * 10;
			System.out.println(sum);
			if ((sum % 11) < 2) {
				dig1 = 0;

			} else {
				dig1 = 11 - (sum % 11);
			}
			sum2 = dig1 * 2 + p * 3 + o * 4 + i * 5 + y * 6 + t * 7 + r * 8 + e * 9 + w * 10 + q * 11;
			if ((sum2 % 11) < 2) {
				dig2 = 0;

			} else {
				dig2 = 11 - (sum2 % 11);
			}
			cpfEQ = a.substring(0, 9) + dig1 + dig2;
			if (cpfEQ.equals(j)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}

	}

}
