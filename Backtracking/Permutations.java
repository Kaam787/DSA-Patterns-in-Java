import java.util.ArrayList;
import java.util.List;

public class Permutations {
	// Generate all permutations of an integer array
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		List<Integer> current = new ArrayList<>();
		backtrack(nums, used, current, res);
		return res;
	}

	private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> res) {
		if (current.size() == nums.length) {
			res.add(new ArrayList<>(current));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i]) continue;
			used[i] = true;
			current.add(nums[i]);
			backtrack(nums, used, current, res);
			// undo
			current.remove(current.size() - 1);
			used[i] = false;
		}
	}

	// Simple demo runner
	public static void main(String[] args) {
		Permutations p = new Permutations();
		int[] nums = {1, 2, 3};
		List<List<Integer>> perms = p.permute(nums);
		System.out.println("Permutations of [1,2,3]:");
		for (List<Integer> perm : perms) {
			System.out.println(perm);
		}
	}
}
