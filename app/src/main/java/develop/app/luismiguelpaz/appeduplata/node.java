package develop.app.luismiguelpaz.appeduplata;

import android.support.annotation.NonNull;

public class node implements Comparable<node>{

	private String message;

	public node(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}


	@Override
	public int compareTo(@NonNull node o) {
		return message.compareTo(o.getMessage());
	}
}
