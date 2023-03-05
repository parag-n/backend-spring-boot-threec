package com.threec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threec.beans.Consumer;
import com.threec.beans.Post;
import com.threec.dao.ConsumerDao;

@Service
public class ConsumerServiceImpl implements ConsumerService{
	@Autowired
	ConsumerDao consumerDao;
	
	public Consumer createConsumer(Consumer consumer) {
		return consumerDao.save(consumer);
	}

	@Override
	public Consumer readConsumer(int consumerId) {
		Optional<Consumer> consumer=consumerDao.findById(consumerId);
		return consumer.orElse(null);
	}

	@Override
	public List<Consumer> readAllConsumers() {
		return consumerDao.findAll();
	}

	@Override
	public Consumer updateConsumer(Consumer consumer) {
		//	========= OLD LOGIC =========
		// it was making checks first, making code slow in case of user not existing
//		if(consumer.getConsumerId()!=0 && consumer.getName()!=null && consumer.getPassword()!=null) {
//			Optional<Consumer> old=consumerDao.findById(consumer.getConsumerId());
//			if(old.isPresent()) {
//				Consumer newConsumer=old.get();
//				newConsumer.setName(consumer.getName());
//				newConsumer.setPassword(consumer.getPassword());
//				consumerDao.save(newConsumer);
//				return newConsumer;
//			}
//		}
//		return null;
		// ========= NEW LOGIC =========
		Consumer old=readConsumer(consumer.getConsumerId());
		if(old==null) return null;
		if(consumer.getFullname()!=null) old.setFullname(consumer.getFullname());
		if(consumer.getEmail()!=null) old.setEmail(consumer.getEmail());
		if(consumer.getPassword()!=null) old.setPassword(consumer.getPassword());
		if(consumer.getPhone()!=null) old.setPhone(consumer.getPhone());
		return consumerDao.save(old);
	}

	@Override
	public boolean deleteConsumer(int consumerId) {
		Consumer consumer= readConsumer(consumerId);
		if(consumer!=null) {
			consumerDao.deleteById(consumerId);
			return true;
		}
		return false;
	}

	@Override
	public Consumer addPost(Consumer consumer) {
		int id=consumer.getConsumerId();
		System.out.println(id);
		Optional<Consumer> findCon=consumerDao.findById(id);
		if(findCon.isPresent()) {
			Consumer con=findCon.get();
//			System.out.println(con);
			List<Post> plist=con.getPosts();
//			System.out.println(plist.get(0).getTitle());
			if(plist==null) plist=new ArrayList<>();
			plist.addAll(consumer.getPosts());
			Post post=plist.get(0);
			post.setConsumer(con);
			Consumer saved=consumerDao.save(con);
			if(saved!=null) return saved;
		}
		return null;
	}
}
