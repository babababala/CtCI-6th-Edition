package Q1_01_Is_Unique;

public class QuestionB {

	/* Assumes only letters a through z. */
	public static boolean isUniqueChars(String str) {
		if (str.length() > 26) { // Only 26 characters
			return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) return false;
			//左移是为了让每个字符都有一个1位和31个零位，统一格式
			//因为这里假定输入只有26个字母，而且int是 32位，有32个0，可以装下。
			//然后每进来一个就与checker相与，同位均为1则为1，也就是大于0
			//而checker在下面这一行里面经历了或，也就是把对应那一位改成了1，这里checker就是个标志器，每个进来的字母只需要
			//对比自己对应那一位是不是1，是1说明之前进来过，然后相与结果就会大于0，return false； 之前是0的话，跳过if，再将
			//对应位置为1，等待下次检验
			checker |= (1 << val);
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word));
		}
	}

}
