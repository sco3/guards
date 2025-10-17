

import static java.lang.String.format;
import static java.lang.System.out;

public class Solution {
	enum Member {
		meth, func
	};

	public void printAlloc(int oldPos, int repPos, Member[] pos) {
		out.print(format("%2d %2d   ", oldPos, repPos));
		for (int i = 0; i < pos.length; i++) {
			out.print(pos[i] + " ");
			if (i == pos.length / 2 - 1) {
				out.print("| ");
			}
		}
		out.println();
	}

	public Member[] init(int n) {
		Member[] result = new Member[n * 2];
		for (int i = 0; i < n; i++) {
			result[i] = Member.meth;
			result[n + i] = Member.func;
		}
		return result;
	}

	public void swap(Member[] pos, int oldPos, int repPos) {
		oldPos--;
		repPos--;
		Member temp = pos[oldPos];
		pos[oldPos] = pos[repPos];
		pos[repPos] = temp;

	}

	public int[] solve(int n, int m, int[] swaps) {
		Member[] pos = init(n);
		int[] result = new int[m];
		int offset = 0;
		for (int move = 0; move < m; move++) {
			int oldPos = swaps[offset * 2];
			int repPos = swaps[offset * 2 + 1];
			swap(pos, oldPos, repPos);
			//printAlloc(oldPos, repPos, pos);
			int left = countLeftSide(n, pos);
			result[offset] = left;

			offset++;
		}
		return result;
	}

	private int countLeftSide(int n, Member[] pos) {
		int left = 0;
		for (int i = 0; i < n; i++) {
			if (pos[i] == Member.meth) {
				left++;
			}
		}
		return left;
	}

}
