package com.onufrei.sn.constants;

import java.util.Arrays;

public enum CommentType {
	SIMPLE(1),
	REPLY(2);

	private final int value;

	CommentType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static CommentType fromValue(int value) {
		return Arrays.stream(CommentType.values()).filter(it -> it.getValue() == value).findFirst().orElse(null);
	}

	public String getStringValue() {
		return String.valueOf(value);
	}
}
