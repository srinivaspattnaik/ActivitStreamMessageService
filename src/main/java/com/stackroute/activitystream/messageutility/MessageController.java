package com.stackroute.activitystream.messageutility;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;


@RestController
public class MessageController 
{
	@Autowired
	MessageDAO messageDAO;
	
	@PostMapping("/sendMessage")
	public ResponseEntity<String> sendMessage(@RequestBody Message message)
	{
		message.setMessageID((int)(Math.random()*10000));
		message.setMessageTime(new Date());
		
		System.out.println("Message :"+message.getMessageContent());
		System.out.println("Circle Id:"+message.getReceiverCircleID());
		System.out.println("Message:"+message.getReceiverID());
		
		
		if(messageDAO.sendMessage(message))
		{
			return new ResponseEntity<String>("Successfully Message Send",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in Message Sending",HttpStatus.OK);
		}
	}
	
	@GetMapping("/getMessagesByCircleId/{circleid}")
	public List<Message> getMessageCircleId(@PathVariable("circleid") String circleid)
	{
		System.out.println("Rest Controller : Circle Id="+circleid);
		List<Message> listMessages=messageDAO.getMessageByCircle(circleid);
		
		for(Message message:listMessages)
		{
			Link link1=linkTo(MessageController.class).slash(message.getSenderID()).withSelfRel();
			message.add(link1);
		}
		return listMessages;
	}
		
	@GetMapping("/getMessagesByReceiverId/{receiverid}")
	public ResponseEntity<List<Message>> getMessageByReceiverId(@PathVariable("receiverid") String receiverid)
	{
		receiverid=receiverid+".com";
		
		List<Message> listMessages=messageDAO.getMessageByUser(receiverid);
		
		return new ResponseEntity<List<Message>>(listMessages,HttpStatus.OK);
	}
}
