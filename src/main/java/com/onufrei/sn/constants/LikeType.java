package com.onufrei.sn.constants;

public enum LikeType {
	FOR_COMMENT(1),
	FOR_POST(2);

	private final int value;

	LikeType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public String getStringValue() {
		return String.valueOf(value);
	}
}
