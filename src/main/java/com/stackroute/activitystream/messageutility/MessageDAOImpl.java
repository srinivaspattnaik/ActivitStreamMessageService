package com.stackroute.activitystream.messageutility;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("messageDAO")
public class MessageDAOImpl implements MessageDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public MessageDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	@Override
	public boolean sendMessage(Message message) 
	{
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(message);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;	
		}
	}

	@Transactional
	public List<Message> getMessageByCircle(String circleid)
	{
		System.out.println("DAO - Circle Id="+circleid);
		Query query=sessionFactory.getCurrentSession().createQuery("from Message where receiverCircleID=:circleid");
		query.setParameter("circleid",circleid);
		List<Message> listMessages=query.list();
		return listMessages;
	}
	
	@Transactional
	public List<Message> getMessageByUser(String receiverid)
	{
		Query query=sessionFactory.getCurrentSession().createQuery("from Message where receiverID=:receiverID");
		query.setParameter("receiverID",receiverid);
		List<Message> listMessages=query.list();
		return listMessages;
	}
}
