package com.fastcampus.biz.board;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// VO(Value Object) Ŭ����
@Getter
@Setter
public class BoardVO {
	// BOARD ���̺��� �÷��� ������ ������� ����
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;

	// �˻� ���� ����
	private String searchCondition;
	private String searchKeyword;

	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", cnt=" + cnt + "]";
	}
	
}











