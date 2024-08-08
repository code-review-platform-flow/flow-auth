package com.flow.main.entity;

import org.hibernate.annotations.Where;

import com.flow.main.common.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "coffee_chats")
@Where(clause = "use_yn = true")
public class CoffeeChatsEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coffee_id")
	private Long coffeeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "initiator_user_id", nullable = false)
	private UsersEntity initiatorUser;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recipient_user_id", nullable = false)
	private UsersEntity recipientUser;

	@Column(name = "contents", nullable = false)
	private String contents;

}
