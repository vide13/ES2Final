package com.es2.login;

public class UserApiResponse {
	private User data;

	public User getData() {
		return data;
	}

	public void setData(User data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "UserApiResponse [data=" + data + "]";
	}
}
