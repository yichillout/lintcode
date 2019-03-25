package com.jasper.dp;

public class LC154_RegularExpressionMatching {

	// Solution 1 : DP
	public boolean isMatch1(String s, String p) {

		char[] ss = s.toCharArray();
		char[] pp = p.toCharArray();

		int m = ss.length;
		int n = pp.length;

		boolean[][] f = new boolean[m + 1][n + 1];

		int i, j;
		for (i = 0; i <= m; i++) {
			for (j = 0; j <= n; j++) {
				// both s and p are empty
				if (i == 0 && j == 0) {
					f[i][j] = true;
					continue;
				}

				// s is not empty, p is empty
				if (j == 0) {
					f[i][j] = false;
					continue;
				}

				f[i][j] = false;
				if (pp[j - 1] != '*') {
					if (i > 0 && (pp[j - 1] == '.' || pp[j - 1] == ss[i - 1])) {
						f[i][j] |= f[i - 1][j - 1];
					}
				} else {
					// .........c*
					// c=pp[j-2]
					// 0c
					if (j > 1) {
						f[i][j] |= f[i][j - 2];
					}

					// >=1c
					if (i > 0 && j > 1 && (pp[j - 2] == '.' || pp[j - 2] == ss[i - 1])) {
						f[i][j] |= f[i - 1][j];
					}

				}
			}
		}

		return f[m][n];
	}

	// Solution 2
	public boolean isMatch2(String s, String p) {
		if (s == null || p == null) {
			return false;
		}

		boolean[][] memo = new boolean[s.length()][p.length()];
		boolean[][] visited = new boolean[s.length()][p.length()];

		return isMatchHelper(s, 0, p, 0, memo, visited);
	}

	private boolean isMatchHelper(String s, int sIndex, String p, int pIndex, boolean[][] memo, boolean[][] visited) {
		// "" == ""
		if (pIndex == p.length()) {
			return sIndex == s.length();
		}

		if (sIndex == s.length()) {
			return isEmpty(p, pIndex);
		}

		if (visited[sIndex][pIndex]) {
			return memo[sIndex][pIndex];
		}

		char sChar = s.charAt(sIndex);
		char pChar = p.charAt(pIndex);
		boolean match;

		// consider a* as a bundle
		if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
			match = isMatchHelper(s, sIndex, p, pIndex + 2, memo, visited)
					|| charMatch(sChar, pChar) && isMatchHelper(s, sIndex + 1, p, pIndex, memo, visited);
		} else {
			match = charMatch(sChar, pChar) && isMatchHelper(s, sIndex + 1, p, pIndex + 1, memo, visited);
		}

		visited[sIndex][pIndex] = true;
		memo[sIndex][pIndex] = match;
		return match;
	}

	private boolean charMatch(char sChar, char pChar) {
		return sChar == pChar || pChar == '.';
	}

	private boolean isEmpty(String p, int pIndex) {
		for (int i = pIndex; i < p.length(); i += 2) {
			if (i + 1 >= p.length() || p.charAt(i + 1) != '*') {
				return false;
			}
		}
		return true;
	}

	// Solution 3
	public boolean isMatch3(String s, String p) {

		if (s.length() == 0) {
			return checkEmpty(p);
		}
		if (p.length() == 0) {
			return false;
		}

		char s1 = s.charAt(0);
		char p1 = p.charAt(0);
		char p2 = '0';
		if (p.length() > 1) {
			p2 = p.charAt(1);
		}
		if (p2 == '*') {
			if (isCompared(s1, p1)) {
				// s: a|abc p: a*bc
				return isMatch3(s.substring(1), p) || isMatch3(s, p.substring(2));
			} else {
				// s: abs p: b*|abs --> true
				return isMatch3(s, p.substring(2));
			}
		} else {
			if (isCompared(s1, p1)) {
				return isMatch3(s.substring(1), p.substring(1));
			} else {
				return false;
			}
		}
	}

	public boolean isCompared(char s, char p) {
		return s == p || p == '.';
	}

	public boolean checkEmpty(String p) {
		if (p.length() % 2 != 0) {
			return false;
		}
		for (int i = 1; i < p.length(); i += 2) {
			if (p.charAt(i) != '*') {
				return false;
			}
		}
		return true;
	}
}
