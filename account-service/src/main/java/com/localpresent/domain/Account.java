package com.localpresent.domain;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.esotericsoftware.kryo.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Document(collection = "accounts")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {
	@Id
	private String name;
	
	private Date lastSeen;
	
	@Valid
	private List<Item> incomes;
	
	@Valid
	private List<Item> expences;
	
	@Valid
	@NotNull
	private Saving saving;
	
	@Length(min = 0, max = 20_000)
	private String note;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(Date lastSeen) {
		this.lastSeen = lastSeen;
	}

	public List<Item> getIncomes() {
		return incomes;
	}

	public void setIncomes(List<Item> incomes) {
		this.incomes = incomes;
	}

	public List<Item> getExpences() {
		return expences;
	}

	public void setExpences(List<Item> expences) {
		this.expences = expences;
	}

	public Saving getSaving() {
		return saving;
	}

	public void setSaving(Saving saving) {
		this.saving = saving;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
