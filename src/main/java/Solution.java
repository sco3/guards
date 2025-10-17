
import static java.lang.String.format;
import static java.lang.System.out;

public class Solution {
	enum Member {
		meth, func
	};

	public void printAlloc(int oldPos, int repPos, Member[] pos, int left) {
		out.print(format("%2d %2d   ", oldPos, repPos));
		for (int i = 0; i < pos.length; i++) {
			out.print(pos[i] + " ");
			if (i == pos.length / 2 - 1) {
				out.print("| ");
			}
		}
		out.println(" " + left);
	}

	public Member[] init(int n) {
		Member[] result = new Member[n * 2];
		for (int i = 0; i < n; i++) {
			result[i] = Member.meth;
			result[n + i] = Member.func;
		}
		return result;
	}

	public int swap(Member[] pos, int oldPos, int repPos, int half) {
		Member temp = pos[oldPos];
		pos[oldPos] = pos[repPos];
		int result = checkDelta(pos, oldPos, repPos, half, temp);
		pos[repPos] = temp;
		return result;
	}

	private int checkDelta(Member[] pos, int oldPos, int repPos, int half, Member temp) {
		int result = 0;
		if ((oldPos < half && repPos >= half) || (oldPos >= half && repPos < half)) {
			if (temp == Member.meth && pos[repPos] == Member.func) {
				if (oldPos < repPos) {
					result = -1;
				} else {
					result = 1;
				}

			} else if (temp == Member.func && pos[repPos] == Member.meth) {
				if (oldPos < repPos) {
					result = 1;
				} else {
					result = -1;
				}
			}
		}
		return result;
	}

	public int[] solve(int n, int m, int[] swaps) {
		Member[] pos = init(n);
		int[] result = new int[m];
		int offset = 0;
		int left = n;
		for (int move = 0; move < m; move++) {
			int oldPos = swaps[offset * 2];
			int repPos = swaps[offset * 2 + 1];
			left += swap(pos, oldPos - 1, repPos - 1, n);
			result[offset] = left;

			offset++;
		}
		return result;
	}
}
