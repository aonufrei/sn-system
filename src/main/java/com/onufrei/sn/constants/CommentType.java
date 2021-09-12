package com.onufrei.sn.constants;

public enum CommentType {
	FOR_COMMENT(1),
	FOR_POST(2);

	private final int value;

	CommentType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public String getStringValue() {
		return String.valueOf(value);
	}
}
