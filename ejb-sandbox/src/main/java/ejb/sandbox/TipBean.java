package ejb.sandbox;

import javax.ejb.Stateless;

@Stateless
public class TipBean {
	private final static String tips[] = {
			"I hear and I forget. I see and I remember. I do and I understand",
			"Study the past if you would define the future",
			" Life is simple, it's just not easy." };

	public String getTip() {
		return tips[(int) (Math.random() * tips.length)];
	}
}