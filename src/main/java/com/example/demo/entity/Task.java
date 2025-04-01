package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {

	//フィールド
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "user_id")
	private Integer userId;

	private String title;

	private Integer closingDate;

	private String progress;

	private String memo;

	//メソッド
	public String getTitle() {
		return title;
	}

	public Integer getClosingDate() {
		return closingDate;
	}

	public String getProgress() {
		return progress;
	}

	public String getMemo() {
		return memo;
	}

}
