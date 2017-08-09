package com.stackroute.activitystream.messageutility;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Message extends BaseDomain 
{
	@Id
	private int messageID;
	
	private String messageContent;
	
	private String messageType;
	
	private Date messageTime;
	
	
	private String senderID;
	
	private String receiverID;
	
	private String receiverCircleID;

	public int getMessageID() {
		return messageID;
	}

	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public Date getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}

	

	public String getSenderID() {
		return senderID;
	}

	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}

	public String getReceiverID() {
		return receiverID;
	}

	public void setReceiverID(String receiverID) {
		this.receiverID = receiverID;
	}

	public String getReceiverCircleID() {
		return receiverCircleID;
	}

	public void setReceiverCircleID(String receiverCircleID) {
		this.receiverCircleID = receiverCircleID;
	}
	
}
